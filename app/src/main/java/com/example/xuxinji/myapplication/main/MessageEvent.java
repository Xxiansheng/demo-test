package com.example.xuxinji.myapplication.main;

/**
 * Created by xuxinji on 2017/7/18.
 */

public class MessageEvent {
    private String message;

    MessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
