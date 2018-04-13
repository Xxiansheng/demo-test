package com.example.xuxinji.myapplication.rxjava;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.xuxinji.myapplication.R;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by xuxinji on 2017/7/19.
 */

public class SubscriberActivity extends AppCompatActivity{
    private  int drawableRes = R.mipmap.ic_launcher;
    private ImageView image;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        image = new ImageView(this);

        initSubscriber();

    }

    private void initSubscriber() {
        Observable.create(new ObservableOnSubscribe<Drawable>() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void subscribe( ObservableEmitter<Drawable> e) throws Exception {
                Drawable drawable = getTheme().getDrawable(drawableRes);
                e.onNext(drawable);
                e.onComplete();
            }
        }).subscribe(new Observer<Drawable>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext( Drawable drawable) {
                image.setImageDrawable(drawable);
            }

            @Override
            public void onError( Throwable e) {
                Toast.makeText(SubscriberActivity.this, "Error!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {

            }
        });
    }


}
