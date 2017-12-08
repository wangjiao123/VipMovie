package com.vip.movie.details.model;

import com.vip.movie.details.bean.DetailsBean;
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
 * Created by Administrator on 2017/12/7 0007.
 */

public class MyDetailsmodel implements Details_model {
    private MyDetailsmodel.OnFinishLisenter lisenter;
    //定义接口
    public interface OnFinishLisenter{
        void onFinish(DetailsBean retbean);
    }
    public void setOnFinishLisenter(MyDetailsmodel.OnFinishLisenter lisenter){
        this.lisenter = lisenter;
    }
    @Override
    public void detailsdata(String url, String mediaId) {
        Map map=new HashMap<String,String>();
        map.put("mediaId",mediaId);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.Card_User).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        ApiServer apiser = retrofit.create(ApiServer.class);
        Observable<DetailsBean> gethom = apiser.getdetails("videoDetailApi/videoDetail.do",map);
        gethom.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DetailsBean>() {
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
                    public void onNext(DetailsBean mysup) {
//                        Log.d("555555555","9999999999999999999");
//
//                        Toast.makeText(MyApp.getContext(),"000000"+mysup,Toast.LENGTH_SHORT).show();
                        lisenter.onFinish(mysup);
                    }
                });
    }
}
