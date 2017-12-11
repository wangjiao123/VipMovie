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
import com.vip.movie.found.bean.EventBusStickMessage;
import com.vip.movie.greendao.User;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by chentong on 2017/12/9.
 */

public class HistoAdpater  extends RecyclerView.Adapter<HistoAdpater.MyViewHolder>{
    Context context;
    List<User> mdata;

    public HistoAdpater(Context context, List<User> mdata) {
        this.context = context;
               this.mdata = mdata;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                context).inflate(R.layout.item_his, parent,
                false));
        return holder;
    }



    public void onBindViewHolder(final MyViewHolder holder, final int position)
    {
        //  holder.tv.setText(data.get(position).getTitle());
        holder.tv.setText(mdata.get(position).getName());
          /*  ImageLoader imageLoader=ImageLoader.getInstance();
            imageLoader.getInstance().displayImage(data.get(position).getPicUrl(),holder.imageView);*/

//得到图片的url
        Uri uri= Uri.parse(mdata.get(position).getPic());
        holder.draweeView.setImageURI(uri);//设置给Fresco
        holder.draweeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().postSticky(new EventBusStickMessage(mdata.get(position).getVideo()));
                Intent intent=new Intent(context, DetailsTwoActivity.class);
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount()
    {
        return mdata.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView tv;
       public SimpleDraweeView draweeView;
        public MyViewHolder(View view)
        {
            super(view);
            tv = (TextView) view.findViewById(R.id.i_text);
           draweeView=(SimpleDraweeView) view.findViewById(R.id.my_image_view);

        }
    }
}

