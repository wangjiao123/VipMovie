package com.vip.movie;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by TA on 2017/12/5.
 */

public class MyApp extends Application {
    private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        //必须初始化Fresco,不然加载不出来图片
        Fresco.initialize(this);
    }

}
