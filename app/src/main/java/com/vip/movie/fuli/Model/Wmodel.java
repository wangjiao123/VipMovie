package com.vip.movie.fuli.Model;

import android.util.Log;

import com.vip.movie.fuli.Bean.Women;
import com.vip.movie.utils.ApiServer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 闫鑫 on 2017/12/7.
 */

public class Wmodel implements FuliImodel {
    private OnWomen onWomen;
    public interface OnWomen{
        void setonWomenListener(List<Women.NewslistBean> newslist);
    }
    public void setOnWomenListener(OnWomen onWomen)
    {
        this.onWomen=onWomen;
    }
    @Override
    public void getjson(String url) {
        Map<String, String> map = new HashMap<>();
        Retrofit build = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        ApiServer apiServer = build.create(ApiServer.class);
        Observable<Women> women = apiServer.getWomen("meinv/?key=10858b1c16838d0b07ec806a3698523c&num=50");
        women.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Women>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("222222222",e.getMessage());
                    }

                    @Override
                    public void onNext(Women women) {
                        List<Women.NewslistBean> newslist = women.getNewslist();
                        onWomen.setonWomenListener(newslist);
                    }
                });
    }
}
