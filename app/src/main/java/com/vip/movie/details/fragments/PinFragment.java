package com.vip.movie.details.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vip.movie.R;
import com.vip.movie.adapters.PinlunAdapter;
import com.vip.movie.bean.PinlunBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/12/10 0010.
 */

@SuppressLint("ValidFragment")
public class PinFragment extends Fragment {
    @BindView(R.id.recyclerviews)
    RecyclerView idRecyclerview;
    Unbinder unbinder;
    PinlunAdapter pinlunAdapter;
    List<PinlunBean.RetBean.ListBean> mDatas;

    @SuppressLint("ValidFragment")
    public PinFragment(List<PinlunBean.RetBean.ListBean> mDatas) {
        this.mDatas = mDatas;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item2_layout, container, false);
        unbinder = ButterKnife.bind(this, view);
        idRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        //Toast.makeText(getActivity(),mDatas+"fragment数据", Toast.LENGTH_SHORT).show();
        idRecyclerview.setAdapter(pinlunAdapter = new PinlunAdapter(getActivity(), mDatas));

//        Log.d("pinlun", "fragment: "+mDatas+"");
//        pinlunAdapter.notifyDataSetChanged();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
