package com.example.xuxinji.myapplication.task;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xuxinji on 2017/7/18.
 */

public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

    private final String mEmail;
    private final String mPassword;

    UserLoginTask(String mEmail, String mPassword) {
        this.mEmail = mEmail;
        this.mPassword = mPassword;
    }


    @Override
    protected Boolean doInBackground(Void... voids) {
        try {
            String result = "";
            BufferedReader in = null;
            String path ="http://localhost:8080/login/?"+"email = "+mEmail+"& password = "+mPassword;
            URL url = new URL(path);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5*1000);
            connection.setRequestMethod("GET");
            InputStream inputStream = connection.getInputStream();
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = "";
            while ((line = in.readLine()) != null) {
                result +="\\\\\\\\\\\\\\\\n" + line;
            }

        }catch (Exception e){
            e.printStackTrace();
        }



        return null;
    }


    private void getLogin(){
        Retrofit retrofit = new Retrofit.Builder()
                  .baseUrl("http://localhost:8080/")
                  .addConverterFactory(GsonConverterFactory.create())
                  .build();
    }



}
