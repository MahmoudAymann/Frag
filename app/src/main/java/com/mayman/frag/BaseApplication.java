package com.mayman.frag;

import android.app.Application;


public class BaseApplication extends Application {

    private static BaseApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        new SetupBinding();
    }

    public static synchronized BaseApplication getInstance() {
        return mInstance;
    }

}
