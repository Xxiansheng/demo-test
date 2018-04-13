package com.example.xuxinji.myapplication.retrofit;

import android.content.Context;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import es.dmoral.toasty.Toasty;

/**
 * Created by xuxinji on 2017/8/21.
 */

public class ProgressSubscriber<T> extends rx.Subscriber<T> implements ProgressCancelListener {

    private SubscriOnNextListener<T> listener;
    private Context context;
    private ProgressDialogHandler handler;


    public ProgressSubscriber(SubscriOnNextListener<T> listener, Context context) {
        this.listener = listener;
        this.context = context;
        handler = new ProgressDialogHandler(context,this,true);
    }

    private void showProgressDialog(){
        if (handler != null){
            handler.obtainMessage(ProgressDialogHandler.SHOW_PROGRESS_DIALOG).sendToTarget();
        }
    }

    private void dismissProgressDialog(){
        if (handler != null){
            handler.obtainMessage(ProgressDialogHandler.DISMISS_PROGRESS_DIALOG).sendToTarget();
            handler = null;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        showProgressDialog();
    }

    @Override
    public void onCompleted() {
        dismissProgressDialog();
        Toasty.success(context,"获取数据成功").show();
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof SocketTimeoutException){
            Toasty.error(context,"网络中断，请检查网络状态").show();
        }else if(e instanceof ConnectException) {
            Toasty.error(context,"网络中断，请检查网络状态").show();
        }else {
            Toasty.error(context,""+e.getMessage()).show();
        }
        dismissProgressDialog();
    }

    @Override
    public void onNext(T t) {
        if (listener != null){
         listener.onNext(t);
        }
    }

    @Override
    public void onCancelProGress() {
        if (!this.isUnsubscribed()){
            this.unsubscribe();
        }
    }
}
