package com.example.inject.bean.module;

import com.example.inject.bean.Banana;
import com.example.inject.bean.Pear;
import com.example.inject.bean.SaladSauce;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xuxinji
 * 2018/4/13
 */

@Module
public class SaladModule {
    @Provides
    public Pear providePear() {
        return new Pear();
    }

    @Provides
    public Banana provideBanana() {
        return new Banana();
    }

    @Provides
    public SaladSauce provideSaladSauce() {
        return new SaladSauce();
    }
}
