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
import com.vip.movie.adapters.HomeAdapter;
import com.vip.movie.details.bean.DetailsBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/12/10 0010.
 */

@SuppressLint("ValidFragment")
public class JianFragment extends Fragment {
    @BindView(R.id.id_recyclerview)
    RecyclerView idRecyclerview;
    Unbinder unbinder;

    HomeAdapter mAdapter;
    private List<DetailsBean> mData;

    @SuppressLint("ValidFragment")
    public JianFragment(List<DetailsBean> mData) {
        this.mData = mData;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_layout, container, false);
        unbinder = ButterKnife.bind(this, view);
        for (int i = 0; i < mData.size(); i++) {
            idRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
            idRecyclerview.setAdapter(mAdapter = new HomeAdapter(getActivity(), mData));
        }
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
