package com.example.xuxinji.myapplication.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by xuxinji on 2017/8/21.
 */

public interface Vu {
    void init(LayoutInflater inflater, ViewGroup viewGroup);
    View getView();
}
