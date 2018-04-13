package com.example.xxj.mvp;

import android.app.Application;

/**
 * Created by xuxinji on 2017/10/31.
 */

public class MyApp extends Application {
    private static MyApp instance;

    public static MyApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
