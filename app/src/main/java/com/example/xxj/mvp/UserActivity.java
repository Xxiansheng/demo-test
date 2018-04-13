package com.example.xxj.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.xxj.mvp.bean.User;

import javax.inject.Inject;

/**
 * Created by xuxinji
 * 2018/4/12
 */

public class UserActivity extends AppCompatActivity{
    @Inject
    User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user.doSomething();
    }
}
