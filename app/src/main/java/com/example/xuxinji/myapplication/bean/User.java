package com.example.xuxinji.myapplication.bean;

/**
 * Created by xuxinji on 2017/8/21.
 */

public class User {
    private String name;
    private String pass;


    public User(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public User() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
