package com.example.xuxinji.myapplication.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.xuxinji.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xuxinji on 2017/8/16.
 */
// FIXME: 2017/8/22 没有写完 
public class RecycyleViewActivity extends AppCompatActivity {
    @BindView(R.id.recycle_view)
    RecyclerView mRecycleView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        ButterKnife.bind(this);
        initView();
    }

    // TODO: 2017/8/22 没有初始化好 
    private void initView() {
        mRecycleView.setLayoutManager(new LinearLayoutManager(this)); //线性显示：horizon，vertical
        //mRecycleView.setLayoutManager(new GridLayoutManager(this, 2));//网格布局显示
        //mRecycleView.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL)); //瀑布布局显示




    }


}
