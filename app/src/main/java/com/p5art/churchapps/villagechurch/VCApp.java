package com.p5art.churchapps.villagechurch;


import android.app.Application;
import android.content.Context;

public class VCApp extends Application {
    private static VCApp instance;

    public static Context getContext() {
        return instance.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
        SharedPreferenceManager.init();
    }
}
