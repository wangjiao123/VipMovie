package com.vip.movie;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;

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

    @Override
    public void onColorSelection(@NonNull ColorChooserDialog dialog, int selectedColor) {
        ThemeUtil.onColorSelection(this, dialog, selectedColor);
        EventBus.getDefault().post("", Set_Theme_Color);
    }

    @Override
    public void onColorChooserDismissed(@NonNull ColorChooserDialog dialog) {

    }



}