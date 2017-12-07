package com.vip.movie.thematic.twomodel;

import com.vip.movie.thematic.api.Apip;
import com.vip.movie.thematic.api.Apiser;
import com.vip.movie.thematic.bean.Myhome;
import com.vip.movie.thematic.bean.Myxiang;
import com.vip.movie.utils.Api;

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
 * Created by 景瑾 on 2017/12/6.
 */

public class Twomodel implements Twomo{

    // 定义接口变量
    private OnFinishLisenter lisenter;
    //定义接口
    public interface OnFinishLisenter{
        void onFinish(List<Myhome.RetBean.ListBean> userBean);
        void onFinish2(Myxiang.RetBean  userBean);
    }
    public void setOnFinishLisenter(OnFinishLisenter lisenter){
        this.lisenter = lisenter;
    }
    @Override
    public void login() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Apip.Home).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        Apiser apiser = retrofit.create(Apiser.class);
        Observable<Myhome> gethom = apiser.gethom();
        gethom.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Myhome>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Myhome home) {
                        List<Myhome.RetBean.ListBean> list = home.getRet().getList();
                        lisenter.onFinish(list);
                    }
                });
    }

    @Override
    public void tiao(String id) {
        Map<String,String> map=new HashMap<>();
        map.put("mediaId",id);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Apip.Home).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();

        Apiser apiService = retrofit.create(Apiser.class);

        Observable<Myxiang> postpages = apiService.postpage("videoDetailApi/videoDetail.do",map);

        postpages.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Myxiang>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Myxiang pageBean) {
                Myxiang.RetBean ret = pageBean.getRet();
                lisenter.onFinish2(ret);
            }
        });
    }
}
