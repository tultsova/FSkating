package com.example.fskating;

import android.app.Application;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class FSApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    }
}
