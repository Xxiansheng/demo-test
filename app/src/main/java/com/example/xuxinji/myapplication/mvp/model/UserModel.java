package com.example.xuxinji.myapplication.mvp.model;

import com.example.xuxinji.myapplication.bean.User;

/**
 * @author xuxinji
 * @date 2017/10/30
 */

public class UserModel {


    public void login(String name, String pass, onLoginListener listener) {
        if (name.equals("123456") && pass.equals("123456")) {
            listener.loginSuccess(new User(name, pass));
        } else {
            listener.loginFailed();
        }

    }

    public interface onLoginListener {

        void loginSuccess(User user);

        void loginFailed();
    }
}
