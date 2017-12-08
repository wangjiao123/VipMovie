package com.vip.movie.found.model;

import com.vip.movie.found.bean.CardBean;
import com.vip.movie.utils.Api;
import com.vip.movie.utils.ApiServer;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/12/6 0006.
 */

public class MyFoundmodel implements Found_model {
    private OnFinishLisenter lisenter;
    //定义接口
    public interface OnFinishLisenter{
        void onFinish(CardBean retbean);
    }
    public void setOnFinishLisenter(OnFinishLisenter lisenter){
        this.lisenter = lisenter;
    }
    @Override
    public void carddata(String url,int pnum) {
        Map map=new HashMap<String,String>();
        map.put("pnum",pnum+"");
        map.put("catalogId","402834815584e463015584e539330016");
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.Card_User).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        ApiServer apiser = retrofit.create(ApiServer.class);
        Observable<CardBean> gethom = apiser.getcard("columns/getVideoList.do",map);
        gethom.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CardBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
//                        Log.d("88888888888888","错误了,错误了,错误率");
//                        Toast.makeText(MyApp.getContext(),"111111111",Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(CardBean mysup) {
//                        Log.d("555555555","9999999999999999999");
//
//                        Toast.makeText(MyApp.getContext(),"000000"+mysup,Toast.LENGTH_SHORT).show();
                        lisenter.onFinish(mysup);
                    }
                });
    }
}
