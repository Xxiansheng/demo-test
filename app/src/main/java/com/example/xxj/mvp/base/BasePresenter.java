package com.example.xxj.mvp.base;

import java.lang.ref.WeakReference;

/**
 * Created by xuxinji on 2017/10/31.
 */

public abstract class BasePresenter<M, V> {

    protected M mModel;
    protected WeakReference<V> mViewRef;

    protected void onAttach(M model, V view) {
        mModel = model;
        mViewRef = new WeakReference<V>(view);
    }

    protected V getView() {
        return isViewAttach() ? mViewRef.get() : null;
    }

    protected boolean isViewAttach() {
        return mViewRef != null && mViewRef.get() != null;
    }

    protected void onDestroy() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

}
