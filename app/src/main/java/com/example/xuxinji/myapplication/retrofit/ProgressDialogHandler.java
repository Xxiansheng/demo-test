package com.example.xuxinji.myapplication.retrofit;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

/**
 * Created by xuxinji on 2017/8/21.
 */

public class ProgressDialogHandler extends Handler {
    public static final int SHOW_PROGRESS_DIALOG = 1;
    public static final int DISMISS_PROGRESS_DIALOG = 2;

    private ProgressDialog progressDialog;

    private Context context;
    private boolean canclable;
    private ProgressCancelListener progressCancelListener;

    public ProgressDialogHandler(Context context, ProgressCancelListener listener, boolean canclable) {
        super();
        this.context = context;
        progressCancelListener = listener;
        this.canclable = canclable;
    }

    private void initProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(context);
            progressDialog.setCancelable(canclable);

            if (canclable) {
                progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        progressCancelListener.onCancelProGress();
                    }
                });
            }

            if (!progressDialog.isShowing()) {
                progressDialog.show();
            }
        }
    }

    private void dismissProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case SHOW_PROGRESS_DIALOG:
                initProgressDialog();
                break;

            case DISMISS_PROGRESS_DIALOG:
                dismissProgressDialog();
                break;
        }
    }
}
