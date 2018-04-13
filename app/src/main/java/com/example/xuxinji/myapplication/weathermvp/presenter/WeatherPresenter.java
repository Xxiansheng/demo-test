package com.example.xuxinji.myapplication.weathermvp.presenter;

import com.example.xuxinji.myapplication.base.BasePresenter;
import com.example.xuxinji.myapplication.weathermvp.model.WeatherModel;
import com.example.xuxinji.myapplication.weathermvp.view.WeatherView;
import com.hwangjr.rxbus.RxBus;

import rx.Subscriber;
import rx.Subscription;


/**
 * Created by xuxinji on 2017/8/21.
 */

public class WeatherPresenter extends BasePresenter<WeatherView> {

    public WeatherPresenter(WeatherView view) {
        attachView(view);
    }

    public void loadData(String cityId) {
        addSubscription(apiService.loadData(cityId), new Subscriber<WeatherModel>() {

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(WeatherModel weatherModel) {
                mvpView.getWeatherSuccess(weatherModel);
            }
        });

    }


}
