package com.vip.movie;

import android.app.Application;
import android.content.Context;

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
    }
}
