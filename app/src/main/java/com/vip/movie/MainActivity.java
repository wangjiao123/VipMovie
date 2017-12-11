package com.vip.movie;



import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.color.ColorChooserDialog;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mikepenz.iconics.IconicsDrawable;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMWeb;
import com.vip.movie.activitys.SettingsActivity;
import com.vip.movie.base.BaseActivity;
import com.vip.movie.found.Fragmentthree;
import com.vip.movie.fuli.View.fuliActivity;
import com.vip.movie.header.Fragmentone;
import com.vip.movie.me.Framgmentfour;
import com.vip.movie.thematic.Fragmenttwo;
import com.vip.movie.utils.theme.ThemeUtil;
import com.vip.movie.utils.theme.ThemeUtils;

import org.simple.eventbus.EventBus;
import org.simple.eventbus.Subscriber;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements View.OnClickListener, ColorChooserDialog.ColorCallback {


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
    @BindView(R.id.qqhead)
    SimpleDraweeView sdv;
    @BindView(R.id.layout1)
    RelativeLayout layout1;
    private Fragmentone one;
    private Fragmenttwo two;
    private Fragmentthree three;
    private Framgmentfour four;
    private UMAuthListener umAuthListener;
    String iconurl;
FragmentManager fm;
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

        fm.beginTransaction().replace(R.id.fl, one).commit();
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
        if (Build.VERSION.SDK_INT >= 23) {
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CALL_PHONE, Manifest.permission.READ_LOGS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.SET_DEBUG_APP, Manifest.permission.SYSTEM_ALERT_WINDOW, Manifest.permission.GET_ACCOUNTS, Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this, mPermissionList, 123);
        }
        //                ToastUtil.showLong(LoginActivity.this , "登录成功"+map.get("name"));
        /*//设置QQ头像
        ImageLoader.getInstance().displayImage(map.get("iconurl"),micon);
        //设置QQ名字
        mname.setText(map.get("name"));*/
        umAuthListener = new UMAuthListener() {
            @Override
            public void onStart(SHARE_MEDIA share_media) {

            }

            @Override
            public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                System.out.println("uid========" + map.get("uid"));
                System.out.println("name========" + map.get("name"));
                System.out.println("iconurl========" + map.get("iconurl"));
//                ToastUtil.showLong(LoginActivity.this , "登录成功"+map.get("name"));
            /*//设置QQ头像

            ImageLoader.getInstance().displayImage(map.get("iconurl"),micon);
            //设置QQ名字
            mname.setText(map.get("name"));*/
                iconurl = map.get("iconurl");
            }

            @Override
            public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

            }

            @Override
            public void onCancel(SHARE_MEDIA share_media, int i) {

            }
        };

    }

    @Subscriber(tag = Framgmentfour.SET_THEME)
    public void setTheme(String content) {
        fm=getSupportFragmentManager();
        new ColorChooserDialog.Builder(this, R.string.theme)
                .customColors(R.array.colors, null)
                .doneButton(R.string.done)
                .cancelButton(R.string.cancel)
                .allowUserColorInput(false)
                .allowUserColorInputAlpha(false)
                .show(fm);
    }

    UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(MainActivity.this, "成功了", Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(MainActivity.this, "失败" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(MainActivity.this, "取消了", Toast.LENGTH_LONG).show();

        }
    };

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
                fm.beginTransaction().replace(R.id.fl, two).commit();
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
            case R.id.qqhead:
                Toast.makeText(MainActivity.this, "登录", Toast.LENGTH_SHORT);
                break;
        }
    }

    @SuppressLint("ResourceType")
    @Override
    public void onColorSelection(@NonNull ColorChooserDialog dialog, int selectedColor) {
        ThemeUtil.onColorSelection(this, dialog, selectedColor);
//        EventBus.getDefault().post("",Set_Theme_Color);
//        EventBus.getDefault().post("",Set_Theme_Color);
        layout1.setBackgroundColor(selectedColor);
    }

    @Override
    public void onColorChooserDismissed(@NonNull ColorChooserDialog dialog) {

    }

    @OnClick({R.id.Ilike, R.id.myload, R.id.fuli, R.id.share, R.id.talk, R.id.setting, R.id.about, R.id.title, R.id.qqhead})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Ilike:
                Intent intent = new Intent(MainActivity.this, ShouchangActivity.class);
                startActivity(intent);
                break;
            case R.id.myload:
                Toast.makeText(MainActivity.this, "敬请期待", Toast.LENGTH_SHORT).show();
                break;
            case R.id.fuli:
                Intent intent1 = new Intent(MainActivity.this, fuliActivity.class);
                startActivity(intent1);
                break;
            case R.id.share:
                UMWeb web = new UMWeb("http://blog.csdn.net/Little_xiaobai/article/details/78613674");
                web.setTitle("This is music title");//标题
                web.setDescription("my description");//描述
                new ShareAction(MainActivity.this)
                        .withMedia(web)
//                        .withText("http://blog.csdn.net/Little_xiaobai/article/details/78613674")
                        .setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN)
                        .setCallback(shareListener)
                        .open();
                break;
            case R.id.talk:
                break;
            case R.id.setting:
                Intent i=new Intent(MainActivity.this,SettingsActivity.class);
                startActivity(i);
                break;
            case R.id.about:
                new MaterialDialog.Builder(this)
                        .title(R.string.about)
                        .titleColor(ThemeUtils.getThemeColor(this, R.attr.colorPrimary))
                        .icon(new IconicsDrawable(this)
                                .color(ThemeUtils.getThemeColor(this, R.attr.colorPrimary))

                                .sizeDp(20))
                        .content(R.string.about_me)
                        .contentColor(ThemeUtils.getThemeColor(this, R.attr.colorPrimary))
                        .positiveText(R.string.close)
                        .show();
                break;
            case R.id.title:

                setTheme();

                Toast.makeText(MainActivity.this, "主题", Toast.LENGTH_LONG).show();
                EventBus.getDefault().post("", Framgmentfour.SET_THEME);

                break;
            case R.id.qqhead:
                Toast.makeText(MainActivity.this, "登录", Toast.LENGTH_LONG).show();
                AbstractDraweeController build = Fresco.newDraweeControllerBuilder().setUri(iconurl).build();
                sdv.setController(build);
                UMShareAPI.get(MainActivity.this).getPlatformInfo(MainActivity.this, SHARE_MEDIA.QQ, umAuthListener);
                break;
        }
    }

    public void setTheme() {
        new ColorChooserDialog.Builder(this, R.string.my_them)
                .customColors(R.array.colors, null)
                .doneButton(R.string.done)
                .cancelButton(R.string.cancel)
                .allowUserColorInput(false)
                .allowUserColorInputAlpha(false)
               .show(fm);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}