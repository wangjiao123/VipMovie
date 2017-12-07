package com.vip.movie.header.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.vip.movie.R;
import com.vip.movie.header.bean.Home;

import java.io.LineNumberInputStream;
import java.util.List;

/**
 * Created by TA on 2017/12/6.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    private  List<Home.RetBean.ListBean> list;

    public MyAdapter(Context context,   List<Home.RetBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

       View view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent,
                false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.iv.setImageURI(list.get(4).getChildList().get(position).getPic());
        holder.tv.setText(list.get(4).getChildList().get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private final SimpleDraweeView iv;
        private final TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);

            iv = itemView.findViewById(R.id.main_iv);
            tv = itemView.findViewById(R.id.main_tv);
        }
    }
}
