package com.vip.movie.thematic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.vip.movie.R;
import com.vip.movie.activitys.DetailsTwoActivity;
import com.vip.movie.found.bean.EventBusStickMessage;
import com.vip.movie.thematic.apdate.ZhiAdapter;
import com.vip.movie.thematic.bean.Myhome;
import com.vip.movie.thematic.bean.Myxiang;
import com.vip.movie.thematic.twopresenter.Twopresenter;
import com.vip.movie.thematic.twoview.Twoview;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Zhuantifenlei extends AppCompatActivity implements Twoview {

    @BindView(R.id.id_recyclerview)
    RecyclerView idRecyclerview;
    @BindView(R.id.fanhui)
    ImageView fanhui;
    @BindView(R.id.lin)
    RelativeLayout lin;
    private RecyclerView mRecyclerView;
    private ArrayList<String> mDatas;
    private ZhiAdapter mAdapter;
    private RecyclerView.LayoutManager manager;
    private int b;
    private String zhi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuantifenlei);
        ButterKnife.bind(this);

Intent intent = getIntent();
        zhi = intent.getStringExtra("zhi");

        Twopresenter twopresenter = new Twopresenter(this);
        twopresenter.login();
    }

    @Override
    public void onLoginSuccess(List<Myhome.RetBean.ListBean> list) {

        ArrayList<Myhome.RetBean.ListBean> listBeans = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Myhome.RetBean.ListBean listBean = list.get(i);
            List<Myhome.RetBean.ListBean.ChildListBean> childList = list.get(i).getChildList();
            if (list.get(i).getTitle().equals("") || childList.get(0).getPic().equals("") || list.get(i).getTitle().equals("Banner") || list.get(i).getTitle().equals("免费推荐") || childList.get(0).getPic().equals("http://phonemovie.ks3-cn-beijing.ksyun.com/image/2017/11/28/1511855662282067261.jpg") || childList.get(0).getPic().equals("http://phonemovie.ks3-cn-beijing.ksyun.com/image/2017/12/06/1512542491372002306.jpg")) {
                listBeans.add(listBean);
            }
        }
        list.removeAll(listBeans);
        b = Integer.parseInt(zhi);
        final List<Myhome.RetBean.ListBean.ChildListBean> childList = list.get(b-1).getChildList();
        Toast.makeText(this, "哈哈"+childList.get(1).getTitle().toString(), Toast.LENGTH_SHORT).show();
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        manager = new GridLayoutManager(Zhuantifenlei.this, 3);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mAdapter = new ZhiAdapter(childList, this));
        mAdapter.setOnItemClickLitener(new ZhiAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {

                EventBus.getDefault().postSticky(new EventBusStickMessage(childList.get(position).getDataId()));
                Intent in=new Intent(Zhuantifenlei.this, DetailsTwoActivity.class);
                startActivity(in);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(Zhuantifenlei.this, "长按" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onLoginSuccess2(final Myxiang.RetBean list) {
        //final List<Myxiang.RetBean.ListBean.ChildListBean> childList = list.getList().get(0).getChildList();
       /* mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        manager = new GridLayoutManager(Zhuantifenlei.this, 3);
       *//* mRecyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));*//*
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mAdapter = new ZhiAdapter(childList, this));

        mAdapter.setOnItemClickLitener(new ZhiAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(Zhuantifenlei.this, "点击+" + position, Toast.LENGTH_SHORT).show();
                EventBus.getDefault().postSticky(new EventBusStickMessage(childList.get(position).getDataId()));
                Intent in=new Intent(Zhuantifenlei.this, DetailsTwoActivity.class);
                startActivity(in);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(Zhuantifenlei.this, "长按" + position, Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    @OnClick(R.id.fanhui)
    public void onViewClicked() {
        finish();
    }


}
