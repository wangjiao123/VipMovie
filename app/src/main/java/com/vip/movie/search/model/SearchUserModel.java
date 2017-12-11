package com.vip.movie.search.model;

import android.util.Log;

import com.vip.movie.search.sbean.Insert;
import com.vip.movie.search.sbean.SearchBean;
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
 * Created by wangjiao on 2017/12/10.
 */

public class SearchUserModel implements SearchModel {

    List<SearchBean.RetBean.ListBean> list;

    private OnInsert onInsert ;
    public interface  OnInsert{
        void OnInsertListener(List<SearchBean.RetBean.ListBean> list);
    }
    public void setOnInsert (OnInsert onInsert ){
        this.onInsert = onInsert;
    }

    @Override
    public void SearchUrl(String url, Insert insert) {

        Map map = new HashMap<>() ;
        map.put("keyword" , insert.getKeyword());
        map.put("pnum" , insert.getPnum());
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(url).addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        ApiServer apiServer = retrofit.create(ApiServer.class);
        Observable<SearchBean> insertorder = apiServer.getSearch("front/searchKeyWordApi/getVideoListByKeyWord.do", map);
        insertorder.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SearchBean>() {
                    @Override
                    public void onCompleted() {

                        Log.d("123" , "onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("123" , e+"onError");
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(SearchBean searchBean) {
                        Log.d("123" , "onNext");
                        list = (List<SearchBean.RetBean.ListBean>) searchBean.getRet().getList();
                        onInsert.OnInsertListener(list);
                    }
                });

    }
}