package com.vip.movie.header.model;

import android.util.Log;

import com.vip.movie.header.bean.Home;
import com.vip.movie.utils.ApiServer;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by TA on 2017/12/6.
 */

public class HomeModel implements Hmodel {
    private OnFinish onFinish ;
    public interface  OnFinish{
        void OnFinishListener(Home.RetBean list);
    }
    public void setOnFinish(OnFinish onFinish ){
        this.onFinish = onFinish;
    }

    @Override
    public void getHome(String url) {

        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(url).addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        ApiServer apiServer = retrofit.create(ApiServer.class);
        Observable<Home> home = apiServer.getHome();
        home.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Home>() {
                    @Override
                    public void onCompleted() {

                        Log.d("One" , "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("One" , "onError");
                    }

                    @Override
                    public void onNext(Home home) {
                        Log.d("One" , "onNext");
                        Home.RetBean ret = home.getRet();
                        onFinish.OnFinishListener(ret);
                    }
                });
    }
}
