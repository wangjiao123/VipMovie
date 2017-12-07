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
import com.vip.movie.thematic.apdate.ZhiAdapter;
import com.vip.movie.thematic.bean.Myhome;
import com.vip.movie.thematic.bean.Myxiang;
import com.vip.movie.thematic.twopresenter.Twopresenter;
import com.vip.movie.thematic.twoview.Twoview;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuantifenlei);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String zhi = intent.getStringExtra("zhi");
        Twopresenter twopresenter = new Twopresenter(this);
        twopresenter.tiao(zhi);
    }

    @Override
    public void onLoginSuccess(List<Myhome.RetBean.ListBean> list) {

    }

    @Override
    public void onLoginSuccess2(Myxiang.RetBean list) {
        List<Myxiang.RetBean.ListBean.ChildListBean> childList = list.getList().get(0).getChildList();
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        manager = new GridLayoutManager(Zhuantifenlei.this, 3);
       /* mRecyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));*/
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mAdapter = new ZhiAdapter(childList, this));

        mAdapter.setOnItemClickLitener(new ZhiAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(Zhuantifenlei.this, "点击+" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(Zhuantifenlei.this, "长按" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.fanhui)
    public void onViewClicked() {
        finish();
    }
}