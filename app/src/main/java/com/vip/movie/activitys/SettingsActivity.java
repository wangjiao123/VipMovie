package com.vip.movie.activitys;

import android.content.ClipboardManager;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.mikepenz.iconics.IconicsDrawable;
import com.vip.movie.R;
import com.vip.movie.base.BaseActivity;
import com.vip.movie.utils.CacheDataManager;
import com.vip.movie.utils.theme.ColorTextView;
import com.vip.movie.utils.theme.EventUtil;
import com.vip.movie.utils.theme.ThemeUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class SettingsActivity extends BaseActivity {


    @BindView(R.id.rl_back)
    RelativeLayout rlBack;
    @BindView(R.id.rl_recommend)
    RelativeLayout rlRecommend;
    @BindView(R.id.rl_about)
    RelativeLayout rlAbout;
    @BindView(R.id.rl_feedback)
    RelativeLayout rlFeedback;
    @BindView(R.id.tv_cache)
    TextView tvCache;
    @BindView(R.id.title_name)
    ColorTextView titleName;
    private Handler handler = new Handler() {

        public void handleMessage(Message msg) {

            switch (msg.what) {

                case 0:

                    Toast.makeText(SettingsActivity.this, "清理完成", Toast.LENGTH_SHORT).show();

                    try {

                        tvCache.setText(CacheDataManager.getTotalCacheSize(SettingsActivity.this));

                    } catch (Exception e) {

                        e.printStackTrace();

                    }

            }

        };

    };
    @Override
    protected int getLayout() {
        return R.layout.activity_settings;
    }
    @Override
    protected void getIntentData() {
//        tvCache.setText("28KB");
        try {
            tvCache.setText(CacheDataManager.getTotalCacheSize(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.getIntentData();
    }


    @OnClick({R.id.rl_back, R.id.title_name, R.id.rl_recommend, R.id.tv_cache, R.id.rl_about, R.id.rl_feedback})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                break;
            case R.id.title_name:
                break;
            case R.id.rl_recommend:
                new MaterialDialog.Builder(this)
                        .content(R.string.setting_recommend_content)
                        .contentColor(ThemeUtils.getThemeColor(this, R.attr.colorPrimary))
                        .positiveText(R.string.close)
                        .negativeText(R.string.setting_recommend_copy).onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        ClipboardManager cmb = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                        cmb.setText(getResources().getString(R.string.setting_recommend_url));
                        EventUtil.showToast(SettingsActivity.this, "已复制到粘贴板");
                    }
                })
                        .show();
                break;
            case R.id.tv_cache:
                new Thread(new clearCache()).start();
                break;
            case R.id.rl_about:
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
                //.icon(MaterialDesignIconic.Icon.gmi_account)
                break;
            case R.id.rl_feedback:

                break;
        }
    }
    //清除缓存
    class clearCache implements Runnable {

        @Override

        public void run() {

            try {

                CacheDataManager.clearAllCache(SettingsActivity.this);

                Thread.sleep(3000);

                if (CacheDataManager.getTotalCacheSize(SettingsActivity.this).startsWith("0")) {

                    handler.sendEmptyMessage(0);

                }

            } catch (Exception e) {

                return;

            }

        }

    }
}
