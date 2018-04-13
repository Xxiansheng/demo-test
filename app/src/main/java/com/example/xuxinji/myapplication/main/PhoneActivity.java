package com.example.xuxinji.myapplication.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.xuxinji.myapplication.R;
import com.example.xxj.mvp.bean.User;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by xuxinji on 2017/7/18.
 */

public class PhoneActivity extends AppCompatActivity {



    private EditText phoneNum;
    private Button clear, btn;
    private TextView tv_mess;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        User user = new User();

        initView();
        initListener();
    }


    private void initView() {
        phoneNum = (EditText) findViewById(R.id.phoneNum);
        clear = (Button) findViewById(R.id.cancle);
        tv_mess = (TextView) findViewById(R.id.textView);
        btn = (Button) findViewById(R.id.btn);

        tv_mess.setText("PhoneActivity");
        btn.setText("发送事件");
    }

    private void initListener() {
        phoneNum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                if (charSequence == null || charSequence.length() == 0)
                    return;

                StringBuilder sBuild = new StringBuilder();
                for (int i = 0; i < charSequence.length(); i++) {
                    if (i != 3 && i != 8 && charSequence.charAt(i) == ' ') {
                        continue;
                    } else {
                        sBuild.append(charSequence.charAt(i));
                        if ((sBuild.length() == 4 || sBuild.length() == 9)
                                && sBuild.charAt(sBuild.length() - 1) != ' ') {
                            sBuild.insert(sBuild.length() - 1, ' ');
                        }
                    }
                }
                if (!sBuild.toString().equals(charSequence.toString())) {
                    int index = start + 1;
                    if (sBuild.charAt(start) == ' ') {
                        if (before == 0) {
                            index++;
                        } else {
                            index--;
                        }
                    } else {
                        if (before == 1) {
                            index--;
                        }
                    }
                    phoneNum.setText(sBuild.toString());
                    phoneNum.setSelection(index);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });




        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneNum.setText("");
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new MessageEvent("欢迎使用EventBus"));
                finish();
            }
        });
    }
}
