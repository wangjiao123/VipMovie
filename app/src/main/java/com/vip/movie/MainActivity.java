package com.vip.movie;


import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.color.ColorChooserDialog;
import com.vip.movie.base.BaseActivity;
import com.vip.movie.found.Fragmentthree;
import com.vip.movie.header.Fragmentone;
import com.vip.movie.me.Framgmentfour;
import com.vip.movie.thematic.Fragmenttwo;
import com.vip.movie.utils.theme.ThemeUtil;

import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;

import butterknife.BindView;
import butterknife.OnClick;





public class MainActivity extends BaseActivity implements View.OnClickListener,ColorChooserDialog.ColorCallback {
    public static final String Set_Theme_Color = "Set_Theme_Color";

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
    @BindView(R.id.Ilike)
    TextView Ilike;
    @BindView(R.id.myload)
    TextView myload;
    @BindView(R.id.fuli)
    TextView fuli;
    @BindView(R.id.share)
    TextView share;
    @BindView(R.id.talk)
    TextView talk;
    @BindView(R.id.setting)
    TextView setting;
    @BindView(R.id.about)
    TextView about;
    @BindView(R.id.title)
    TextView title;
    private Fragmentone one;
    private Fragmenttwo two;
    private Fragmentthree three;
    private Framgmentfour four;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        EventBus.getDefault().register(this);
        super.initView();

        fm = getSupportFragmentManager();
        one = new Fragmentone();
        two = new Fragmenttwo();
        three = new Fragmentthree();
        four = new Framgmentfour();
        shou.setOnClickListener(this);
        fen.setOnClickListener(this);
        gou.setOnClickListener(this);
        my.setOnClickListener(this);

        //ll111
        fm.beginTransaction().replace(R.id.fl , one).commit();
        shou.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.fancy_select), null, null);
        shou.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
        fen.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.found), null, null);
        fen.setTextColor(ContextCompat.getColor(this, R.color.colorHint));
        gou.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.special), null, null);
        gou.setTextColor(ContextCompat.getColor(this, R.color.colorHint));
        my.setCompoundDrawablesRelativeWithIntrinsicBounds(null, ContextCompat.getDrawable(this, R.mipmap.my), null, null);
        my.setTextColor(ContextCompat.getColor(this, R.color.colorHint));
        //设置透明状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        }
    }



    @Subscriber(tag = Framgmentfour.SET_THEME)
    public void setTheme(String content) {
        new ColorChooserDialog.Builder(this, R.string.theme)
                .customColors(R.array.colors, null)
                .doneButton(R.string.done)
                .cancelButton(R.string.cancel)
                .allowUserColorInput(false)
                .allowUserColorInputAlpha(false)
                .show(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.shou:
                fm.beginTransaction().replace(R.id.fl, one).commit();
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
                fm.beginTransaction().replace(R.id.fl, three).commit();
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
                fm.beginTransaction().replace(R.id.fl, four).commit();
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


    @Override
    public void onColorSelection(@NonNull ColorChooserDialog dialog, int selectedColor) {
        ThemeUtil.onColorSelection(this, dialog, selectedColor);
//        EventBus.getDefault().post("",Set_Theme_Color);
        EventBus.getDefault().post("",Set_Theme_Color);
    }

    @Override
    public void onColorChooserDismissed(@NonNull ColorChooserDialog dialog) {

    }

    @OnClick({R.id.Ilike, R.id.myload, R.id.fuli, R.id.share, R.id.talk, R.id.setting, R.id.about, R.id.title})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Ilike:
                Intent intent=new Intent(MainActivity.this,ShouchangActivity.class);
                startActivity(intent);
                break;
            case R.id.myload:
                Toast.makeText(MainActivity.this,"敬请期待",Toast.LENGTH_SHORT).show();
                break;
            case R.id.fuli:
                break;
            case R.id.share:

                break;
            case R.id.talk:
                break;
            case R.id.setting:
                break;
            case R.id.about:
                break;
            case R.id.title:
                break;
        }
    }
}