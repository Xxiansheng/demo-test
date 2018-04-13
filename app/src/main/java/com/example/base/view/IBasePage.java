package com.example.base.view;

/**
 * Created by xuxinji
 * 2018/2/11
 */

public interface IBasePage {
    // 获取页面
    int getLayoutId();

    // 初始化界面
    void init();

    // 设置监听器
    void setListener();
}
