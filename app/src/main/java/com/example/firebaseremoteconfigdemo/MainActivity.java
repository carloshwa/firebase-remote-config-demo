package com.example.firebaseremoteconfigdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public class MainActivity extends AppCompatActivity implements OnCompleteListener<Void> {
    private static final String TAG = MainActivity.class.getName();
    private static final String KEY_MESSAGE = "message";

    private TextView messageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        messageTextView = findViewById(R.id.message_text);

        FirebaseRemoteConfig.getInstance().fetch(0).addOnCompleteListener(this, this);
    }

    @Override
    public void onComplete(@NonNull Task<Void> task) {
        if (task.isSuccessful()) {
            FirebaseRemoteConfig.getInstance().activateFetched();
            final String message = FirebaseRemoteConfig.getInstance().getString(KEY_MESSAGE);
            Log.d(TAG, "FirebaseRemoteConfig fetched message: " + message);
            messageTextView.setText(message);
        } else {
            Log.e(TAG, task.getException() == null ? "FirebaseRemoteConfig fetch error." : task.getException().getMessage());
        }
    }
}
