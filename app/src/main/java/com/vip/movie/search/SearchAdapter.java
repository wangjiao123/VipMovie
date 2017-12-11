package com.vip.movie.search;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.vip.movie.R;
import com.vip.movie.activitys.DetailsTwoActivity;
import com.vip.movie.found.bean.EventBusStickMessage;
import com.vip.movie.search.sbean.SearchBean;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by wangjiao on 2017/12/10.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder>
{
        List<SearchBean.RetBean.ListBean> userses;
        Context context;

    public SearchAdapter(List<SearchBean.RetBean.ListBean> userses, Context context) {
            this.userses = userses;
            this.context = context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder holder=new MyViewHolder(View.inflate(context,R.layout.item_search,null));
        return holder;
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position)
        {
        holder.tv.setText(userses.get(position).getTitle());
        Uri uri =  Uri.parse(userses.get(position).getPic());
//        DraweeController controller = Fresco.newDraweeControllerBuilder()
//        .setUri(uri)
//        .setAutoPlayAnimations(true)
//        .build();
        holder.image.setImageURI(userses.get(position).getPic());
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().postSticky(new EventBusStickMessage(userses.get(position).getDataId()));
                Intent intent=new Intent(context, DetailsTwoActivity.class);
                context.startActivity(intent);
            }
        });
        }

    @Override
    public int getItemCount()
        {
        return userses.size();
        }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        SimpleDraweeView image;
        TextView tv;

        public MyViewHolder(View view)
        {
            super(view);
            tv = (TextView) view.findViewById(R.id.search_text);
            image = (SimpleDraweeView) view.findViewById(R.id.search_image);

        }
    }
}