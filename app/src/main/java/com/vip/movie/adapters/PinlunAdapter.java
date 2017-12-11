package com.vip.movie.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.vip.movie.R;
import com.vip.movie.bean.PinlunBean;

import java.util.List;

/**
 * Created by Administrator on 2017/12/9 0009.
 */

public class PinlunAdapter  extends RecyclerView.Adapter<PinlunAdapter.MyViewHolder>{
    Context context;
    List<PinlunBean.RetBean.ListBean> mDatas;

    public PinlunAdapter(Context context, List<PinlunBean.RetBean.ListBean> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
        Log.d("mdatas", "onCreateViewHolder: "+mDatas);
    }
    @Override
    public PinlunAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        PinlunAdapter.MyViewHolder holder = new PinlunAdapter.MyViewHolder(LayoutInflater.from(
                context).inflate(R.layout.pinlun_item_home, parent,
                false));
        Log.d("mdatas", "onCreateViewHolder: "+mDatas);
        return holder;
    }

    @Override
    public void onBindViewHolder(PinlunAdapter.MyViewHolder holder, int position)
    {

//        for(int i=0;i<mDatas.get(position).getRet().getList().size();i++) {
            String img=mDatas.get(position).getUserPic();
            Uri uri = Uri.parse(img);
            holder.headimg.setImageURI(uri);
            holder.phonenum.setText(mDatas.get(position).getPhoneNumber());
            holder.timer.setText(mDatas.get(position).getTime());
            holder.mytalk.setText(mDatas.get(position).getMsg());
       // }
    }

    @Override
    public int getItemCount()
    {
        Log.d("000000000000000", "getItemCount: "+mDatas.size());
        return mDatas.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView phonenum,timer,mytalk;
        SimpleDraweeView headimg;

        public MyViewHolder(View view)
        {
            super(view);
           phonenum=(TextView) view.findViewById(R.id.phonenum);
            timer=(TextView) view.findViewById(R.id.timer);
            mytalk=(TextView) view.findViewById(R.id.mytalk);
            headimg=(SimpleDraweeView) view.findViewById(R.id.headimg);
        }
    }

}
