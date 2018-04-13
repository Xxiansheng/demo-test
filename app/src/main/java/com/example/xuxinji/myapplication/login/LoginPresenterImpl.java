package com.example.xuxinji.myapplication.login;

import com.example.xuxinji.myapplication.bean.User;

/**
 * Created by xuxinji on 2017/8/21.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {
    private LoginView loginView;
    private LoginInteractor loginInteractor;


    public LoginPresenterImpl(LoginView view) {
        loginView = view;
        loginInteractor = new LoginInteractorImpl();
    }


    @Override
    public void validateCredentials(String name, String password) {
        if (loginView != null) {
            loginView.showProgress();
        }

        loginInteractor.login(name, password, this);
    }

    @Override
    public void onDesrtoy() {
        loginView = null;
    }

    @Override
    public void onUserNameError() {
        if (loginView != null) {
            loginView.setUserNameError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if (loginView != null) {
            loginView.setPasswordError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onSuccess(User user) {
        if (loginView != null) {
            loginView.navigateToHome();
            loginView.hideProgress();
        }
    }
}
