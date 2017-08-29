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

        // TODO
        // Initializing Firebase programmatically here does not work with FirebaseRemoteConfig.
        // If you comment out this block & comment in google_app_id in strings.xml to let Firebase
        // initialize automatically, FirebaseRemoteConfig *does* work. But I need to be able to
        // initialize Firebase programmatically so I can specify the values below at runtime.
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
