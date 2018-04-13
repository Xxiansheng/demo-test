package com.example.xuxinji.myapplication.mvp.view;

import com.example.xuxinji.myapplication.bean.User;

/**
 * Created by xuxinji on 2017/10/30.
 */

public interface IUserView {
    String getUserName();

    String getUserPass();

    void showLoading();

    void hideLoading();

    void loginSuccess(User user);

    void loginFail();

    void clearUserName();

    void claerUserPass();

    void showNetworkError();
}
