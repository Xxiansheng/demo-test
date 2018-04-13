package com.example.inject.bean.component;

import com.example.inject.bean.Banana;
import com.example.inject.bean.Pear;
import com.example.inject.bean.Salad;
import com.example.inject.bean.SaladSauce;
import com.example.inject.bean.module.SaladModule;

import dagger.Component;

/**
 * Created by xuxinji
 * 2018/4/13
 */
@Component(modules = {SaladModule.class})
public interface SaladComponent {
    Pear providePear();

    Banana provideBanana();

    SaladSauce provideSaladSauce();

    void inject(Salad salad);
}
