package com.example.xuxinji.myapplication.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.xuxinji.myapplication.R;
import com.example.xuxinji.myapplication.bean.User;
import com.example.xuxinji.myapplication.mvp.presenter.IUserPresenter;
import com.example.xuxinji.myapplication.mvp.view.IUserView;

/**
 * Created by xuxinji on 2017/10/30.
 */

public class UserLoginActivity extends AppCompatActivity implements IUserView, View.OnClickListener {

    private EditText nameEdt, passEdt;
    private Button loginBtn, clearBtn;

    private IUserPresenter presenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    private void initView() {
        presenter = new IUserPresenter();
    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public String getUserPass() {
        return null;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void loginSuccess(User user) {

    }

    @Override
    public void loginFail() {

    }

    @Override
    public void clearUserName() {

    }

    @Override
    public void claerUserPass() {

    }

    @Override
    public void showNetworkError() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn:
                presenter.login();
                break;
            default:
        }
    }
}
