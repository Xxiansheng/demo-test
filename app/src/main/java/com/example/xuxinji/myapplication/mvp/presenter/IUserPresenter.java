package com.example.xuxinji.myapplication.mvp.presenter;

import android.os.Handler;
import android.text.TextUtils;

import com.example.xuxinji.myapplication.bean.User;
import com.example.xuxinji.myapplication.mvp.model.UserModel;
import com.example.xuxinji.myapplication.mvp.view.IUserView;

/**
 * Created by xuxinji on 2017/10/30.
 */

public class IUserPresenter {
    private UserModel userModel;
    private IUserView userView;
    private Handler handler = new Handler();

    public void IUserPresenter(IUserView userView) {
        this.userView = userView;
        this.userModel = new UserModel();
    }

    public void login() {
       String name = userView.getUserName();
       String pass = userView.getUserPass();
       if (checkParameter(name,pass)){
           userModel.login(name,pass, new UserModel.onLoginListener() {
               @Override
               public void loginSuccess(User user) {
                   userView.loginSuccess(user);
               }

               @Override
               public void loginFailed() {
                   userView.loginFail();
               }
           });
       }

    }

    public void claer() {
        userView.claerUserPass();
        userView.clearUserName();
    }


    private boolean checkParameter(String account, String password) {
        if (TextUtils.isEmpty(account) | TextUtils.isEmpty(password)) {
            userView.loginFail();//提示错误
            return false;
        }
        return true;
    }
}
