package com.example.inject.bean;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by xuxinji
 * 2018/4/13
 */

public class Salad {
    private static final String TAG = "Salad";

    @Inject
    private Pear pear;

    @Inject
    private Banana banana;

    @Inject
    private SaladSauce saladSauce;

    public Salad() {
        pear = new Pear();
        banana = new Banana();
        saladSauce = new SaladSauce();
        makeSalad(pear, banana, saladSauce);
    }

    public void makeSalad(Pear pear, Banana banana, SaladSauce sauce) {
        Log.e(TAG, "makeSalad: 我在搅拌制作水果沙拉");
    }
}
