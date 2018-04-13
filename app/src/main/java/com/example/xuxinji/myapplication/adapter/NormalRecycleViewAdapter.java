package com.example.xuxinji.myapplication.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by xuxinji on 2017/8/16.
 */

public class NormalRecycleViewAdapter extends RecyclerView.Adapter<NormalRecycleViewAdapter.NormalTextViewHolder>{


    @Override
    public NormalTextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(NormalTextViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class NormalTextViewHolder extends RecyclerView.ViewHolder{

        public NormalTextViewHolder(View itemView) {
            super(itemView);
        }
    }
}
