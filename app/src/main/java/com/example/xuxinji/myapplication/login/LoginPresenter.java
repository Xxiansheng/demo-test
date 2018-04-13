package com.example.xuxinji.myapplication.login;

/**
 * Created by xuxinji on 2017/8/21.
 */

public interface LoginPresenter {
    void validateCredentials(String name,String password);
    void onDesrtoy();
}
