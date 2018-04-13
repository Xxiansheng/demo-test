package com.example.xuxinji.myapplication.login;

import com.example.xuxinji.myapplication.bean.User;

/**
 * Created by xuxinji on 2017/8/21.
 */

public interface LoginInteractor {

    interface OnLoginFinishedListener {

        void onUserNameError();

        void onPasswordError();

        void onSuccess(User user);
    }

    void login(String name,String password,OnLoginFinishedListener listener);
}


