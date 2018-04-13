package com.example.xuxinji.myapplication.main;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.xuxinji.myapplication.R;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by xuxinji on 2017/7/5.
 * 简单实现本地浏览文件
 */

public class FileActivity extends AppCompatActivity {

    private ArrayList<String> items = null;  //文件列表
    private ArrayList<String> paths = null;  //文件路径
    private String rootPath = "/";
    private ListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        getFileDir(rootPath);

        initListViewClick();
    }


    private void initView() {
        mListView = (ListView) findViewById(R.id.list_view);


    }

    private void getFileDir(String filePath) {
        items = new ArrayList<>();
        paths = new ArrayList<>();
        File file = new File(filePath);
        File[] files = file.listFiles();

        if (!filePath.equals(rootPath)) {
            items.add("返回根目录" + rootPath);
            paths.add(rootPath);
            items.add("返回上一级文件");
            paths.add(file.getParent());
        }
        for (File fileTemp : files) {
            items.add(fileTemp.getName());
            paths.add(fileTemp.getPath());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(FileActivity.this, android.R.layout.simple_expandable_list_item_1, items);

        mListView.setAdapter(adapter);
    }

    private void initListViewClick() {
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                File file = new File(paths.get(i));
                if (file.canRead()) {
                    if (file.isDirectory()) {
                        getFileDir(paths.get(i));
                    } else {
                        new AlertDialog.Builder(FileActivity.this)
                                  .setTitle("Message")
                                  .setMessage("[" + file.getName() + "] is a file")
                                  .setPositiveButton("ok", new DialogInterface.OnClickListener() {

                                      @Override
                                      public void onClick(DialogInterface dialog, int which) {

                                      }
                                  }).show();
                    }
                }
            }
        });
    }

}
