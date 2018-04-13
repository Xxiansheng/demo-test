package com.example.xuxinji.myapplication.retrofit;

import android.app.Application;
import android.content.Context;

/**
 * Created by xuxinji on 2017/8/21.
 */

public class MyApplication extends Application{
    private static MyApplication instance;

    public static Context getAppContext(){
        return instance == null ? null : instance.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
