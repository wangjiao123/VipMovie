package com.vip.movie;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatDelegate;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by TA on 2017/12/5.
 */

public class MyApp extends Application {
    private static Context context;
    public static Context getContext() {
        return context;
    }


    private static MyApp instance;
    private Set<Activity> allActivities;
    public static MyApp getInstance() {
        return instance;
    }
    static {
        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_NO);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        instance=this;
        //必须初始化Fresco,不然加载不出来图片
        Fresco.initialize(this);
    }
    public void registerActivity(Activity act) {
        if (allActivities == null) {
            allActivities = new HashSet<Activity>();
        }
        allActivities.add(act);
    }

    public void unregisterActivity(Activity act) {
        if (allActivities != null) {
            allActivities.remove(act);
        }
    }

    public void exitApp() {
        if (allActivities != null) {
            synchronized (allActivities) {
                for (Activity act : allActivities) {
                    if (act != null && !act.isFinishing())
                        act.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }



}
