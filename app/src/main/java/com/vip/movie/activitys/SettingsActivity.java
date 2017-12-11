package com.vip.movie.activitys;

import android.content.ClipboardManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.baidu.speech.EventListener;
import com.baidu.speech.EventManager;
import com.baidu.speech.EventManagerFactory;
import com.baidu.speech.asr.SpeechConstant;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.material_design_iconic_typeface_library.MaterialDesignIconic;
import com.vip.movie.R;
import com.vip.movie.base.BaseActivity;
import com.vip.movie.utils.theme.ColorTextView;
import com.vip.movie.utils.theme.EventUtil;
import com.vip.movie.utils.theme.ThemeUtils;

import org.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class SettingsActivity extends BaseActivity implements EventListener  {


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
    EditText et_input;
    private boolean enableOffline = true;
    private boolean logTime = true;
    private EventManager asr;

    @Override
    protected int getLayout() {
        return R.layout.activity_settings;
    }

    @Override
    protected void init() {
        super.init();
        asr = EventManagerFactory.create(SettingsActivity.this, "asr");
        asr.registerListener(this); //  EventListener 中 onEvent方法
    }


    @OnClick({R.id.rl_back, R.id.title_name, R.id.rl_recommend, R.id.tv_cache, R.id.rl_about, R.id.rl_feedback})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_back:
                finish();
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
                break;
            case R.id.rl_about:
                new MaterialDialog.Builder(this)
                        .title(R.string.about)
                        .titleColor(ThemeUtils.getThemeColor(this, R.attr.colorPrimary))
                        .icon(new IconicsDrawable(this)
                                .color(ThemeUtils.getThemeColor(this, R.attr.colorPrimary))
                                .icon(MaterialDesignIconic.Icon.gmi_account)
                                .sizeDp(20))
                        .content(R.string.about_me)
                        .contentColor(ThemeUtils.getThemeColor(this, R.attr.colorPrimary))
                        .positiveText(R.string.close)
                        .show();

                break;
            case R.id.rl_feedback:

                View view2 = LayoutInflater.from(this).inflate(R.layout.dialog_layout11,null);

                Button bt= view2.findViewById(R.id.qd);
                Button qx=view2.findViewById(R.id.qx);
                Button ly=view2.findViewById(R.id.luyin);
                Button lystop=view2.findViewById(R.id.luyin_stop);
                et_input=view2.findViewById(R.id.fankuitext);
                ly.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                      start();

                    }

                });

                lystop.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       stop();
                    }
                });

                final AlertDialog dialog = new AlertDialog.Builder(this).setView(view2).create();
                Window window = dialog.getWindow();
                window.setGravity(Gravity.CENTER);  //此处可以设置dialog显示的位置
                dialog.show();
                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(SettingsActivity.this, "确定", Toast.LENGTH_SHORT).show();
                        //如果有接口，可以做文件发送
                        dialog.dismiss();
                    }


                });
                qx.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

               /* if (enableOffline) {
                    loadOfflineEngine(); //测试离线命令词请开启, 测试 ASR_OFFLINE_ENGINE_GRAMMER_FILE_PATH 参数时开启
                }*/
                break;
        }
    }

    private void start() {
        et_input.setText("");
        Map<String, Object> params = new LinkedHashMap<String, Object>();
        String event = null;
        event = SpeechConstant.ASR_START; // 替换成测试的event

        params.put(SpeechConstant.ACCEPT_AUDIO_VOLUME, false);
        params.put(SpeechConstant.VAD,SpeechConstant.VAD_DNN);
        if (enableOffline){
            params.put(SpeechConstant.DECODER, 2);
        }
        //  params.put(SpeechConstant.NLU, "enable");
        // params.put(SpeechConstant.VAD_ENDPOINT_TIMEOUT, 800);
        // params.put(SpeechConstant.VAD, SpeechConstant.VAD_DNN);
        //  params.put(SpeechConstant.PROP ,20000);
        String json = null; //可以替换成自己的json
        json = new JSONObject(params).toString(); // 这里可以替换成你需要测试的json
        asr.send(event, json, null, 0, 0);
        printLog("输入参数：" + json);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        asr.send(SpeechConstant.ASR_CANCEL, "{}", null, 0, 0);
        if (enableOffline) {
            unloadOfflineEngine(); //测试离线命令词请开启, 测试 ASR_OFFLINE_ENGINE_GRAMMER_FILE_PATH 参数时开启
        }
    }

    @Override
    public void onEvent(String name, String params, byte[] data, int offset, int length) {
        String logTxt = "name: " + name;


        if (params != null && !params.isEmpty()) {
            logTxt += " ;params :" + params;
        }
        if (name.equals(SpeechConstant.CALLBACK_EVENT_ASR_PARTIAL)) {
            if (params.contains("\"nlu_result\"")) {
                if (length > 0 && data.length > 0) {
                    logTxt += ", 语义解析结果：" + new String(data, offset, length);
                }
            }
        } else if (data != null) {
            logTxt += " ;data length=" + data.length;
        }
        printLog(logTxt);
    }

    private void printLog(String text) {
        if (logTime) {
            text += "  ;time=" + System.currentTimeMillis();
        }
        text += "\n";
        Log.i(getClass().getName(), text);
        et_input.append(text + "\n");
    }


    private void stop() {
        asr.send(SpeechConstant.ASR_STOP, null, null, 0, 0); //
    }

    private void loadOfflineEngine() {
        Map<String, Object> params = new LinkedHashMap<String, Object>();
        params.put(SpeechConstant.DECODER, 2);
        params.put(SpeechConstant.ASR_OFFLINE_ENGINE_GRAMMER_FILE_PATH, "assets://baidu_speech_grammar.bsg");
        asr.send(SpeechConstant.ASR_KWS_LOAD_ENGINE, new JSONObject(params).toString(), null, 0, 0);
    }

    private void unloadOfflineEngine() {
        asr.send(SpeechConstant.ASR_KWS_UNLOAD_ENGINE, null, null, 0, 0); //
    }



}
