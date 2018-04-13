package com.example.xuxinji.myapplication.main;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by xuxinji on 2017/7/18.
 */

public interface Api {
    @GET("/login/")
    Call<LoginActivity> getData(@Query("name") String name, @Query("password") String password);
}
