package com.example.xuxinji.myapplication.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.xuxinji.myapplication.R;

/**
 * Created by xuxinji on 2017/7/18.
 */

public class SecondActivity extends AppCompatActivity {

    private ImageView img;
    private Button button;
    String url = "http://img6.cache.netease.com/photo/0001/2017-07-21/CPS4KTFL6VVV0001.jpg";
    String gifUrl = "http://p1.pstatp.com/large/166200019850062839d3";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initView();


    }

    private void initView() {
        img = (ImageView) findViewById(R.id.imageView);
        button = (Button) findViewById(R.id.down_img);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Glide.with(SecondActivity.this)
                          .load(url)
                          .placeholder(R.mipmap.ic_launcher)
                          .error(R.mipmap.ic_launcher_round)
                          .diskCacheStrategy(DiskCacheStrategy.NONE)
                          .into(img);


            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


}
