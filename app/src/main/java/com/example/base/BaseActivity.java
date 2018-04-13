package com.example.base;

import android.view.View;

import com.example.base.view.IBasePage;
import com.zhy.autolayout.AutoLayoutActivity;

/**
 * Created by xuxinji
 * 2018/2/11
 */

public class BaseActivity extends AutoLayoutActivity implements IBasePage{

    private View contentView;

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public void init() {

    }

    @Override
    public void setListener() {

    }
}
