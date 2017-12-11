package com.vip.movie.utils;



import com.vip.movie.bean.PinlunBean;
import com.vip.movie.details.bean.DetailsBean;
import com.vip.movie.found.bean.CardBean;
import com.vip.movie.fuli.Bean.Women;
import com.vip.movie.header.bean.Home;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by fan on 2017/11/8.
 */


public interface ApiServer {

    @GET
    Observable<Women> getWomen(@Url String url);

    //卡片请求
    @POST
    Observable<CardBean> getcard(@Url String url, @QueryMap Map<String, String> map);

    //详情请求
    @POST
    Observable<DetailsBean> getdetails(@Url String url, @QueryMap Map<String, String> map);
    //评论请求
    @POST
    Observable<PinlunBean> getpinlun(@Url String url, @QueryMap Map<String, String> map);
        //主页
        @GET("front/homePageApi/homePage.do")
        Observable<Home> getHome();


}
