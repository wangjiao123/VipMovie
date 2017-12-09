package com.vip.movie.thematic.apdate;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.vip.movie.R;
import com.vip.movie.thematic.bean.Myhome;

import java.util.List;

/**
 * Created by 景瑾 on 2017/12/6.
 */

public class ZhiAdapter extends RecyclerView.Adapter<ZhiAdapter.MyViewHolder>{
    Context context;
    List<Myhome.RetBean.ListBean.ChildListBean>  mDatas;

    public ZhiAdapter(List<Myhome.RetBean.ListBean.ChildListBean> mdatas, Context context) {
        this.mDatas = mdatas;
        this.context = context;
    }

    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position);
        void onItemLongClick(View view , int position);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                context).inflate(R.layout.itim_buju, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position)
    {
        holder.tv.setText(mDatas.get(position).getTitle());


        ImageLoader.getInstance().displayImage(mDatas.get(position).getPic(),holder.sim);
       /* //创建DraweeController
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                //重试之后要加载的图片URI地址
                .setUri(mDatas.get(position).getPic())
                //设置点击重试是否开启
                .setTapToRetryEnabled(true)
                //动画播放
                .setAutoPlayAnimations(true)
                //设置旧的Controller
                .setOldController(holder.sim.getController())
                //构建
                .build();
        //设置DraweeController
        holder.sim.setController(controller);*/


        if (mOnItemClickLitener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener()
            {
                @Override
                public boolean onLongClick(View v)
                {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemLongClick(holder.itemView, pos);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount()
    {
        return mDatas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView tv;
        SimpleDraweeView sim;
        public MyViewHolder(View view)
        {
            super(view);
            sim=view.findViewById(R.id.swpp);
            tv = (TextView) view.findViewById(R.id.bujute);
        }
    }
}