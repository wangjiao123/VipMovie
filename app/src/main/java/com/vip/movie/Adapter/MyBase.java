package com.vip.movie.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.vip.movie.R;
import com.vip.movie.greendao.User;

import java.util.List;

/**
 * Created by wangjiao on 2017/12/11.
 */

public class MyBase extends BaseAdapter{

    List<User> users;
    Context context;

    public MyBase(List<User> users, Context context) {
        this.users = users;
        this.context = context;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (null==convertView){
            convertView = View.inflate(context, R.layout.itemview,null);
            holder = new ViewHolder();
            holder.textView = convertView.findViewById(R.id.viewtext);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        String name = users.get(position).getName();
        holder.textView.setText(name);
        return convertView;
    }
    class ViewHolder{
        TextView textView;
    }
}
