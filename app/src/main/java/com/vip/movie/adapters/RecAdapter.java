package com.vip.movie.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.vip.movie.R;
import com.vip.movie.activitys.DetailsTwoActivity;
import com.vip.movie.details.bean.DetailsBean;
import com.vip.movie.found.bean.EventBusStickMessage;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by Administrator on 2017/12/8 0008.
 */

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.MyViewHolder> {
    List<DetailsBean.RetBean.ListBean.ChildListBean> mDatas;
    Context context;
//    List<DetailsBean.RetBean.ListBean.ChildListBean> list;
    public RecAdapter(List<DetailsBean.RetBean.ListBean.ChildListBean> mDatas, Context context) {
        this.mDatas = mDatas;
        this.context = context;
//        Log.d("55555555555:::::",mDatas.size()+"");
//        list=mDatas.get(0).getChildList();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                context).inflate(R.layout.rec_item, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position)
    {
            String img=mDatas.get(position).getPic();
            Uri uri = Uri.parse(img);
            holder.my_image_view.setImageURI(uri);
            holder.movie_title.setText(mDatas.get(position).getTitle());
            holder.my_image_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EventBus.getDefault().postSticky(new EventBusStickMessage(mDatas.get(position).getDataId()));
                    Intent intent = new Intent(context, DetailsTwoActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
    }

    @Override
    public int getItemCount()
    {
//        Log.d("getItemCount", "MyViewHolder: -------------"+mDatas.size());
        return mDatas.size();

    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView movie_title;
        SimpleDraweeView my_image_view;
        public MyViewHolder(View view)
        {
            super(view);
            movie_title = (TextView) view.findViewById(R.id.movie_title);
            my_image_view=(SimpleDraweeView) view.findViewById(R.id.my_image_view);
        }
    }
}
