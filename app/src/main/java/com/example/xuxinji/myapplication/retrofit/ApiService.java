package com.example.xuxinji.myapplication.retrofit;

import com.example.xuxinji.myapplication.weathermvp.model.WeatherModel;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by xuxinji on 2017/7/20.
 */

public interface ApiService {
    String API_SERVER_URL = "http://apistore.baidu.com/microservice/";

    @GET("users?sortby={sortby}")
    Call<List<Object>> getObjectBySort(@Path("sortBy") String sort);

    //文件上传
    @Multipart
    @POST("register")
    Call<Object> registerUser(@Part MultipartBody.Part photo, @Part("userName") RequestBody userName, @Part("password") RequestBody password);

    //加载天气
    @GET("weather")
    Observable<WeatherModel> loadData(@Query("citypinyin") String cityId);
}
