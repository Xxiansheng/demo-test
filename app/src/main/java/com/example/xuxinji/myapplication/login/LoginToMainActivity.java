package com.example.xuxinji.myapplication.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.xuxinji.myapplication.R;
import com.example.xuxinji.myapplication.bean.User;

import es.dmoral.toasty.Toasty;

/**
 * @author xuxinji
 * @date 2017/8/21
 */

public class LoginToMainActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    private EditText username, password;
    private ProgressBar progressBar;
    private User user;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(R.id.button).setOnClickListener(this);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        presenter = new LoginPresenterImpl(this);
        user = new User();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                presenter.validateCredentials(username.getText().toString(), password.getText().toString());
                break;

            default:
        }
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUserNameError() {
        if (!username.getText().toString().equals(user.getName())) {
            username.setError("用户名不正确");
        }
    }

    @Override
    public void setPasswordError() {
        if (!password.getText().toString().equals(user.getPass())) {
            password.setError("密码错误");
        }
    }

    @Override
    public void navigateToHome() {
        Toasty.success(LoginToMainActivity.this, "登录成功").show();
        progressBar.setVisibility(View.GONE);
    }

    @Override
    protected void onDestroy() {
        presenter.onDesrtoy();
        super.onDestroy();
    }
}
