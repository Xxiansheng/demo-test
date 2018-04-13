package com.example.xuxinji.myapplication.main;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.xuxinji.myapplication.R;

import java.io.File;
import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static String TAG = "Observable";
    public ListView mListView;
    private ArrayList<String> data = new ArrayList<>();//文件列表
    private ArrayList<String> paths = new ArrayList<>();  //文件路径
    private String rootPath = "/";

    private Button jumpBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        //简单的Observe事例
        initObserval();

        initListViewClick();

        getFileDir(rootPath); //获取路径

    }


    private void initView() {
        mListView = (ListView) findViewById(R.id.list_view);
        jumpBtn = (Button) findViewById(R.id.jump_btn);
        jumpBtn.setOnClickListener(this);
    }


    private void initObserval() {

        data = new ArrayList<>();
        final File file = new File(rootPath);

      /*
      //拆开写
      Observable<File[]> observable = Observable.create(new ObservableOnSubscribe<File[]>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<File[]> e) throws Exception {
                e.onNext(file.listFiles());
            }
        });

        Observer<File[]> observer = new Observer<File[]>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull File[] o) {
                for (File file : o) {
                    data.add(file.getName());
                }
                //把数据加载到适配器上显示
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1, data);

                mListView.setAdapter(adapter);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "error");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete");
            }
        };

        //建立两者之间的联系
        observable.subscribe(observer);
*/

       /* //链表方式
        Observable.create(new ObservableOnSubscribe<File[]>() {

            @Override
            public void subscribe(@NonNull ObservableEmitter<File[]> e) throws Exception {
                e.onNext(file.listFiles());
            }
        }).subscribe(new Observer<File[]>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull File[] files) {
                for (File file : files) {
                    data.add(file.getName());
                }
                //把数据加载到适配器上显示
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1, data);

                mListView.setAdapter(adapter);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });*/

       /* //利用Flowable实现
        Flowable.create(new FlowableOnSubscribe<File[]>() {

            @Override
            public void subscribe(@NonNull FlowableEmitter<File[]> e) throws Exception {
                e.onNext(file.listFiles());
            }
        }, BackpressureStrategy.BUFFER).subscribe(new Subscriber<File[]>() {
            @Override
            public void onSubscribe(Subscription s) {
                s.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(File[] files) {
                for (File file : files) {
                    data.add(file.getName());
                    paths.add(file.getPath());
                }
                //把数据加载到适配器上显示
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1, data);

                mListView.setAdapter(adapter);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        });*/

        //使用just（）方法
        Observable.just(file.listFiles()).subscribe(new Consumer<File[]>() {
            @Override
            public void accept(File[] files) throws Exception {
                for (File file : files) {
                    data.add(file.getName());
                    paths.add(file.getPath());
                }
                //把数据加载到适配器上显示
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1, data);

                mListView.setAdapter(adapter);
            }
        });


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
                        new AlertDialog.Builder(MainActivity.this)
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

    private void getFileDir(String filePath) {
        if (!filePath.equals(rootPath)) {
            data.add("返回根目录" + rootPath);
            paths.add(rootPath);
            data.add("返回上一级文件");
            paths.add(new File(rootPath).getParent());
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.jump_btn:
                Intent intent = new Intent(this, PhoneActivity.class);
                startActivity(intent);
        }
    }
}