package com.vip.movie.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vip.movie.R;
import com.vip.movie.details.bean.DetailsBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/6 0006.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>{
    Context context;
    List<DetailsBean> mDatas;
    RecyclerView details_recyclerview;
    RecAdapter mAdapter;
     List<DetailsBean.RetBean.ListBean.ChildListBean> list;

    public HomeAdapter(Context context, List<DetailsBean> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
        list=new ArrayList<>();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
               context).inflate(R.layout.item_home, parent,
                false));

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        holder.details_text.setText(mDatas.get(position).getRet().getDescription());
        holder.title.setText(mDatas.get(position).getRet().getTitle());
        for(int i=0;i<mDatas.get(position).getRet().getList().size();i++) {
            List<DetailsBean.RetBean.ListBean.ChildListBean> lists = mDatas.get(position).getRet().getList().get(i).getChildList();
            list.addAll(lists);
        }

        //这个错误点
        Log.d("333333333333:",list.toString());
    }

    @Override
    public int getItemCount()
    {
        return mDatas.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView details_text,title;
        RecyclerView details_recyclerview;
        public MyViewHolder(View view)
        {
            super(view);
            details_text = (TextView) view.findViewById(R.id.details_text);
            title = (TextView) view.findViewById(R.id.title);
            details_recyclerview=(RecyclerView) view.findViewById(R.id.details_recyclerview);
            details_recyclerview.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
            details_recyclerview.setAdapter(mAdapter = new RecAdapter(list,context));
        }
    }
}
