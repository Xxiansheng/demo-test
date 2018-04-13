package com.example.xuxinji.myapplication.login;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;

import com.example.xuxinji.myapplication.bean.User;

import es.dmoral.toasty.Toasty;

/**
 * Created by xuxinji on 2017/8/21.
 */

public class LoginInteractorImpl implements LoginInteractor {
    private Context context;

    @Override
    public void login(final String name, final String password, final OnLoginFinishedListener listener) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean error = false;
                if (TextUtils.isEmpty(name)) {
                    listener.onUserNameError();
                    error = true;
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    listener.onPasswordError();
                    error = true;
                    return;
                }

                if (!error) {
                    if (("123456").equals(name) && ("123123").equals(password)) {
                        User user = new User(name, password);
                        user.setName(name);
                        user.setPass(password);
                        listener.onSuccess(user);
                    }
                }
            }
        }, 2000);
    }
}
