package com.vip.movie.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vip.movie.R;

import java.util.List;

/**
 * Created by Administrator on 2017/12/6 0006.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>{
    Context context;
    List<String> mDatas;

    public HomeAdapter(Context context, List<String> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        Log.d("main", "setScrollViewContent: 11111111111111111111111111111111111111");
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
               context).inflate(R.layout.item_home, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        holder.details_text.setText(mDatas.get(position));
    }

    @Override
    public int getItemCount()
    {
        return mDatas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView details_text;

        public MyViewHolder(View view)
        {
            super(view);
            details_text = (TextView) view.findViewById(R.id.details_text);
        }
    }
}
