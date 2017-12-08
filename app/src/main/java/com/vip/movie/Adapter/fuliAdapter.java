package com.vip.movie.Adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.vip.movie.R;
import com.vip.movie.fuli.Bean.Women;

import java.util.List;

/**
 * Created by 闫鑫 on 2017/12/7.
 */

public class fuliAdapter extends RecyclerView.Adapter<fuliAdapter.MyViewHolder>{
    private List<Women.NewslistBean> newslis;
    private Context context;

    public fuliAdapter(List<Women.NewslistBean> newslis, Context context) {
        this.newslis = newslis;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                context).inflate(R.layout.fuli_item, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        AbstractDraweeController build = Fresco.newDraweeControllerBuilder()
                .setUri(newslis.get(position).getPicUrl())
                .build();
        holder.sdw.setController(build);
    }

    @Override
    public int getItemCount()
    {
        return newslis.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {

        SimpleDraweeView sdw;

        public MyViewHolder(View view)
        {
            super(view);
            sdw= (SimpleDraweeView) view.findViewById(R.id.simple);
        }
    }

}
