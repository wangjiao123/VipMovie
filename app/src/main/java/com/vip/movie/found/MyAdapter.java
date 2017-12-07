package com.vip.movie.found;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.vip.movie.R;
import com.vip.movie.activitys.DetailsTwoActivity;
import com.vip.movie.found.bean.CardBean;
import com.vip.movie.found.bean.EventBusStickMessage;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by Administrator on 2017/12/7 0007.
 */

public class MyAdapter extends RecyclerView.Adapter {
    List<CardBean.RetBean.ListBean> list;
    Context context;

    public MyAdapter(List<CardBean.RetBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        SimpleDraweeView avatarImageView = ((MyViewHolder) holder).avatarImageView;
//            avatarImageView.setImageResource(Integer.parseInt(list.get(position).getRet().getList().get(position).getChildList().get(position).getPic()));
        //   avatarImageView.setImageResource(Integer.parseInt((list.get(position).getPic())));
        CardBean.RetBean.ListBean cardBean = list.get(position);
        String imgUrl = cardBean.getPic();
        avatarImageView.setImageURI(Uri.parse(imgUrl));
        ((MyViewHolder) holder).tv_name.setText(list.get(position).getDescription());
        ((MyViewHolder) holder).tv_names.setText(list.get(position).getTitle());


        avatarImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().postSticky(new EventBusStickMessage(list.get(position).getDataId()));
                Intent intent = new Intent(context, DetailsTwoActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        SimpleDraweeView avatarImageView;
        ImageView likeImageView;
        ImageView dislikeImageView;
        TextView tv_name, tv_names;

        MyViewHolder(View itemView) {
            super(itemView);
            avatarImageView = itemView.findViewById(R.id.iv_avatar);
            likeImageView = (ImageView) itemView.findViewById(R.id.iv_like);
            dislikeImageView = (ImageView) itemView.findViewById(R.id.iv_dislike);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_names = (TextView) itemView.findViewById(R.id.tv_names);
        }

    }
}
