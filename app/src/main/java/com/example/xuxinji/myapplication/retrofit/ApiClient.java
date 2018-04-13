package com.example.xuxinji.myapplication.retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xuxinji on 2017/8/21.
 */

public class ApiClient {
    public static Retrofit retrofit;

    public static Retrofit retrofit() {
        if (retrofit == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            OkHttpClient okHttpClient = builder.build();
            retrofit = new Retrofit.Builder()
                      .baseUrl(ApiService.API_SERVER_URL)
                      .addConverterFactory(GsonConverterFactory.create())
                      .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                      .client(okHttpClient)
                      .build();
        }
        return retrofit;
    }


}
