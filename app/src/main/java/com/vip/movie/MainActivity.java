package com.vip.movie;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hjm.bottomtabbar.BottomTabBar;
import com.vip.movie.found.Fragmentthree;
import com.vip.movie.header.Fragmentone;
import com.vip.movie.me.Framgmentfour;
import com.vip.movie.thematic.Fragmenttwo;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {


    @BindView(R.id.bottomTabBar)
    BottomTabBar bottomTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();
    }

    private void init() {
        bottomTabBar.init(getSupportFragmentManager())
                .setImgSize(55, 55)
                .setFontSize(10)
                .setChangeColor(Color.RED, Color.GRAY)
                .addTabItem("首页", R.mipmap.found_select, R.mipmap.found, Fragmentone.class)
                .addTabItem("分类", R.mipmap.special_select, R.mipmap.special, Fragmenttwo.class)
                .addTabItem("购物车", R.mipmap.fancy_select, R.mipmap.fancy, Fragmentthree.class)
                .addTabItem("个人", R.mipmap.my_select, R.mipmap.my, Framgmentfour.class)
                .isShowDivider(false);


    }
}