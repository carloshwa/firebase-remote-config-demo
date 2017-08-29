package com.example.firebaseremoteconfigdemo;

import android.app.Application;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;


public class ExampleApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setApplicationId(getString(R.string.firebase_app_id))
                .setApiKey(getString(R.string.firebase_api_key))
                .setDatabaseUrl(getString(R.string.firebase_url))
                .build();
        FirebaseApp.initializeApp(this, options);

        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                .setDeveloperModeEnabled(BuildConfig.DEBUG)
                .build();
        FirebaseRemoteConfig.getInstance().setConfigSettings(configSettings);
    }
}
