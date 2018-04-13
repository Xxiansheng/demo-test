package com.example.xuxinji.myapplication.base;

import com.example.xuxinji.myapplication.retrofit.ApiClient;
import com.example.xuxinji.myapplication.retrofit.ApiService;


import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by xuxinji on 2017/8/21.
 */

public class BasePresenter<V> {
    public V mvpView;

    protected ApiService apiService;
    private CompositeSubscription subscription;

    public void attachView(V mvpView) {
        this.mvpView = null;
        apiService = ApiClient.retrofit().create(ApiService.class);
    }

    public void deteachView() {
        this.mvpView = null;
        onUnSubscribe();
    }

    private void onUnSubscribe() {
        if (subscription != null && subscription.hasSubscriptions()) {
            subscription.unsubscribe();
        }
    }

    public <T> void addSubscription(Observable<T> obserable, Subscriber<T> subscriber) {
        if (subscription == null) {
            subscription = new CompositeSubscription();
        }
        subscription.add(obserable
                  .subscribeOn(Schedulers.io())
                  .observeOn(AndroidSchedulers.mainThread())
                  .subscribe(subscriber));
    }

}
