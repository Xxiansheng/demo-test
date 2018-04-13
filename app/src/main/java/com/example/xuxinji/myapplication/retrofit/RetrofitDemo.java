package com.example.xuxinji.myapplication.retrofit;

import android.os.Environment;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;

/**
 * Created by xuxinji on 2017/7/20.
 */

public class RetrofitDemo {
    ApiService apiService;

    File file = new File(Environment.getExternalStorageDirectory(),"ic_launch");
    RequestBody photoRequestBody = RequestBody.create(MediaType.parse("image/png"),file);
    MultipartBody.Part photo = MultipartBody.Part.createFormData("photos","icon.png",photoRequestBody);
    Call<Object> call = apiService.registerUser(photo,RequestBody.create(null,"abc"),RequestBody.create(null,"123"));

}
