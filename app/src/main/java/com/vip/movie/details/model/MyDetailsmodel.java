package com.vip.movie.details.model;

import com.vip.movie.bean.PinlunBean;
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



    private MyDetailsmodel.OnPinLunLisenter pinLunLisenter;
    //定义接口
    public interface OnPinLunLisenter{
        void Onpinlun(PinlunBean retbean);
    }
    public void setOnPinLunLisenter(MyDetailsmodel.OnPinLunLisenter pinLunLisenter){
        this.pinLunLisenter = pinLunLisenter;
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
//                        Log.d("1111111111111111111", "onNext: 3333333333333333333333333333333333");
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(DetailsBean mysup) {


                        lisenter.onFinish(mysup);
                    }
                });
    }

    @Override
    public void detailsdatapinlun(String url, String mediaId) {
        Map map=new HashMap<String,String>();
        map.put("mediaId",mediaId);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.Card_User).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        ApiServer apiser = retrofit.create(ApiServer.class);
        Observable<PinlunBean> gethom = apiser.getpinlun("Commentary/getCommentList.do",map);
        //Log.d("pinlun",Api.Card_User+"Commentary/getCommentList.do");

        gethom.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PinlunBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                        e.printStackTrace();

                    }

                    @Override
                    public void onNext(PinlunBean mysup) {

                       // Toast.makeText(MyApp.getContext(),mysup+"评论model", Toast.LENGTH_SHORT).show();
                        pinLunLisenter.Onpinlun(mysup);
                    }
                });
    }
}
