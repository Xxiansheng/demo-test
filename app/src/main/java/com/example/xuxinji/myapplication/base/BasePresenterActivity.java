package com.example.xuxinji.myapplication.base;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by xuxinji on 2017/8/21.
 */

public abstract class BasePresenterActivity<V extends Vu> extends Activity {
    protected V vu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            vu = getVuClass().newInstance();
            vu.init(getLayoutInflater(), null);
            setContentView(vu.getView());
            onBindVu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected abstract Class<V> getVuClass();

    private void onBindVu() {
    }

    @Override
    protected final void onDestroy() {
        super.onDestroy();
    }

    private void onDestroyVu() {
    }


}
