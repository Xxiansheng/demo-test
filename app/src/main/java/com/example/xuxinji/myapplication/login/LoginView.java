package com.example.xuxinji.myapplication.login;

/**
 *
 * @author xuxinji
 * @date 2017/8/21
 */

public interface LoginView {
    /**
     *显示加载
     */
    void showProgress();

    /**
     *隐藏加载
     */
    void hideProgress();

    /**
     *用户名错误
     */
    void setUserNameError();

    /**
     *密码错误提示
     */
    void setPasswordError();

    /**
     *跳转到主页
     */
    void navigateToHome();
}
