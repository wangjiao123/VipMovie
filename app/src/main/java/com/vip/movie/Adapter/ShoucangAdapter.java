package com.vip.movie.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.vip.movie.R;
import com.vip.movie.activitys.DetailsTwoActivity;
import com.vip.movie.found.bean.EventBusStickMessage;
import com.vip.movie.greendao.User;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by 闫鑫 on 2017/12/10.
 */

public class ShoucangAdapter extends RecyclerView.Adapter<ShoucangAdapter.MyViewHolder>{
    private Context context;
    private List<User> list;

    public ShoucangAdapter(Context context, List<User> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                context).inflate(R.layout.shoucang_item, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position)
    {
        holder.tv.setText(list.get(position).getName());
        DraweeController build = Fresco.newDraweeControllerBuilder()
                .setUri(list.get(position).getPic())
                .build();
       holder.sc_draw.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String video = list.get(position).getVideo();
               Toast.makeText(context,video,Toast.LENGTH_SHORT).show();
               EventBus.getDefault().postSticky(new EventBusStickMessage(video));
               Intent intent=new Intent(context, DetailsTwoActivity.class);
               context.startActivity(intent);
           }
       });
    }
    @Override
    public int getItemCount()
    {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView tv;
        SimpleDraweeView sc_draw;
        public MyViewHolder(View view)
        {
            super(view);
            sc_draw=view.findViewById(R.id.sc_draw);
            tv=view.findViewById(R.id.sc_title);
        }
    }
}
