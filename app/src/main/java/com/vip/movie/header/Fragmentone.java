package com.vip.movie.header;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;
import com.vip.movie.R;
import com.vip.movie.activitys.DetailsTwoActivity;

import com.vip.movie.activitys.SearchActivity;
import com.vip.movie.base.BaseFragment;
import com.vip.movie.header.adapter.MyAdapter;
import com.vip.movie.header.bean.EventBusStickMessage;
import com.vip.movie.header.bean.Home;

import com.vip.movie.header.control.ObservableScrollView;
import com.vip.movie.header.presenter.HomePresenter;
import com.vip.movie.header.view.HView;
import com.vip.movie.utils.Api;
import com.vip.movie.utils.Toasts;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * Created by Tangao on 2017/12/4.
 */


public class Fragmentone extends BaseFragment implements HView, SwipeRefreshLayout.OnRefreshListener{

    @Override
    protected int getLayout() {
        return R.layout.one;
    }

    @BindView(R.id.xb)
    XBanner xb;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    Unbinder unbinder;
    @BindView(R.id.osl)
    ObservableScrollView obser;
    @BindView(R.id.tv_biaoti)
    TextView mBiaoti;
    @BindView(R.id.tbar)
    Toolbar tbar;
    @BindView(R.id.swipe)
    SwipeRefreshLayout swipe;
    @BindView(R.id.et)
    EditText et;
    @BindView(R.id.et_re)
    RelativeLayout etre;
    private int height;
    private HomePresenter homePresenter;
    private MyAdapter myAdapter;
    private List<Home.RetBean.ListBean> list1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.one, null);
        unbinder = ButterKnife.bind(this, view);
        homePresenter = new HomePresenter(this);
        homePresenter.getHome(Api.HOMEURL);
        initView();

        et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasts.showShort(getActivity() , "sdfsadfsadfasdf");
                startActivity(new Intent(getActivity() , SearchActivity.class));
            }
        });
        return view;

    }


    private void initView() {

        et.setFocusable(false);
        LinearLayoutManager linerLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(linerLayoutManager);

        mBiaoti.bringToFront();
        final ViewTreeObserver vto = xb.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                xb.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                height = xb.getHeight();
                xb.getWidth();
            }
        });
        swipe.setOnRefreshListener(this);
        obser.setScrollViewListener(new ObservableScrollView.ScrollViewListener() {
            @Override
            public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy) {
                if (y <= 0) {
                    mBiaoti.setVisibility(View.GONE);
                    tbar.setBackgroundColor(Color.argb((int) 0, 227, 29, 26));//AGB由相关工具获得，或者美工提供
                    et.setVisibility(View.VISIBLE);
                } else if (y > 0 && y <= height) {
                    mBiaoti.setVisibility(View.VISIBLE);
                    float scale = (float) y / height;
                    float alpha = (255 * scale);
                    // 只是layout背景透明
                    tbar.setBackgroundColor(Color.argb((int) alpha, 227, 29, 26));
                    et.setVisibility(View.GONE);
                } else {
                    mBiaoti.setVisibility(View.VISIBLE);
                    tbar.setBackgroundColor(Color.argb((int) 255, 227, 29, 26));
                    etre.setVisibility(View.VISIBLE);
                }
            }
        });


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void getHome(final Home.RetBean list) {
        final List<String> images = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            images.add(list.getList().get(0).getChildList().get(i).getPic());
        }
        xb.setData(images, null);
        xb.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, View view, int position) {
                Glide.with(getActivity()).load(images.get(position)).into((ImageView) view);
            }
        });


        //recyclerView条目添加适配器
        list1 = list.getList();
        myAdapter = new MyAdapter(getActivity(), list1);
        recycler.setAdapter(myAdapter);//设置适配器


        myAdapter.setOnItemClieckLinster(new MyAdapter.OnItemClieckLinster() {
            @Override
            public void onItemClickListener(View view, int pos) {
                //玩去
                EventBus.getDefault().postSticky(new EventBusStickMessage(list1.get(4).getChildList().get(pos).getDataId()));
                startActivity(new Intent(getActivity() , DetailsTwoActivity.class));
            }

            @Override
            public void onItemLongClickListener(View view, int pos) {
            }
        });

        //Xbanner跳转
        xb.setOnItemClickListener(new XBanner.OnItemClickListener() {
            @Override
            public void onItemClick(XBanner banner, int position) {
                //玩去
                EventBus.getDefault().postSticky(new EventBusStickMessage(list.getList().get(0).getChildList().get(position).getDataId()));
                Toasts.showShort(getActivity(), "tangtangtangtangtang");
                startActivity(new Intent(getActivity() , DetailsTwoActivity.class));
            }
        });




    }


    @Override
    public void onRefresh() {
        homePresenter.getHome(Api.HOMEURL);
        myAdapter.notifyDataSetChanged();
        swipe.setRefreshing(false);
        Toasts.showShort(getActivity(), "刷新成功！");
    }



}
