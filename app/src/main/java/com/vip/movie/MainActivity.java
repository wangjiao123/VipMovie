package com.vip.movie;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import com.vip.movie.found.Fragmentthree;
import com.vip.movie.header.Fragmentone;
import com.vip.movie.me.Framgmentfour;
import com.vip.movie.thematic.Fragmenttwo;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends FragmentActivity implements View.OnClickListener {
    @BindView(R.id.shou)
    RadioButton shou;
    @BindView(R.id.fen)
    RadioButton fen;
    @BindView(R.id.gou)
    RadioButton gou;
    @BindView(R.id.my)
    RadioButton my;
    @BindView(R.id.fl)
    FrameLayout fl;
    FragmentManager fm;
    private Fragmentone one;
    private Fragmenttwo two;
    private Fragmentthree three;
    private Framgmentfour four;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fm = getSupportFragmentManager();
        one = new Fragmentone();
        two = new Fragmenttwo();
        three = new Fragmentthree();
        four = new Framgmentfour();
        shou.setOnClickListener(this);
        fen.setOnClickListener(this);
        gou.setOnClickListener(this);
        my.setOnClickListener(this);
        fm.beginTransaction().replace(R.id.fl , one).commit();
        shou.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.fancy_select), null, null);
        shou.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
        fen.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.found), null, null);
        fen.setTextColor(ContextCompat.getColor(this, R.color.colorHint));
        gou.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.special), null, null);
        gou.setTextColor(ContextCompat.getColor(this, R.color.colorHint));
        my.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.my), null, null);
        my.setTextColor(ContextCompat.getColor(this, R.color.colorHint));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.shou:
            fm.beginTransaction().replace(R.id.fl , one).commit();
                shou.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.fancy_select), null, null);
                shou.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
                fen.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.found), null, null);
                fen.setTextColor(ContextCompat.getColor(this, R.color.colorHint));
                gou.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.special), null, null);
                gou.setTextColor(ContextCompat.getColor(this, R.color.colorHint));
                my.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.my), null, null);
                my.setTextColor(ContextCompat.getColor(this, R.color.colorHint));
            break;
            case R.id.fen:
                fm.beginTransaction().replace(R.id.fl , two).commit();

                shou.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.fancy), null, null);
                shou.setTextColor(ContextCompat.getColor(this, R.color.colorHint));
                fen.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.found_select), null, null);
                fen.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
                gou.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.special), null, null);
                gou.setTextColor(ContextCompat.getColor(this, R.color.colorHint));
                my.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.my), null, null);
                my.setTextColor(ContextCompat.getColor(this, R.color.colorHint));
                break;
            case R.id.gou:
                fm.beginTransaction().replace(R.id.fl , three).commit();
                shou.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.fancy), null, null);
                shou.setTextColor(ContextCompat.getColor(this, R.color.colorHint));
                fen.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.found), null, null);
                fen.setTextColor(ContextCompat.getColor(this, R.color.colorHint));
                gou.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.special_select), null, null);
                gou.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
                my.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.my), null, null);
                my.setTextColor(ContextCompat.getColor(this, R.color.colorHint));
                break;
            case R.id.my:
                fm.beginTransaction().replace(R.id.fl , four).commit();
                shou.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.fancy), null, null);
                shou.setTextColor(ContextCompat.getColor(this, R.color.colorHint));
                fen.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.found), null, null);
                fen.setTextColor(ContextCompat.getColor(this, R.color.colorHint));
                gou.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.special), null, null);
                gou.setTextColor(ContextCompat.getColor(this, R.color.colorHint));
                my.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.my_select), null, null);
                my.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
                break;
        }
    }
}