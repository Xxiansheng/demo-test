package com.example.xuxinji.myapplication.weathermvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.xuxinji.myapplication.R;
import com.example.xuxinji.myapplication.weathermvp.model.WeatherModel;
import com.example.xuxinji.myapplication.weathermvp.presenter.WeatherPresenter;

/**
 * Created by xuxinji on 2017/8/22.
 */

public class WeatherActivity extends AppCompatActivity implements WeatherView, View.OnClickListener {

    private Button button;
    private TextView tv_show;
    private EditText edt;
    private WeatherPresenter presenter = new WeatherPresenter(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        initView();
    }

    private void initView() {
        tv_show = (TextView) findViewById(R.id.tv_show);
        button = (Button) findViewById(R.id.btn);
        edt = (EditText) findViewById(R.id.edt);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn:
                presenter.loadData(edt.getText().toString());
                break;
        }
    }

    @Override
    public void getWeatherSuccess(WeatherModel weatherModel) {
        tv_show.setText(" "+weatherModel.getRetData().getWeather()+" "+weatherModel.getRetData().getWD());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null){
            presenter.deteachView();
        }
    }
}
