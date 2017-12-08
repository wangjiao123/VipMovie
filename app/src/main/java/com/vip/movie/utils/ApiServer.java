package com.vip.movie.utils;


import com.vip.movie.details.bean.DetailsBean;
import com.vip.movie.found.bean.CardBean;

import java.util.Map;

import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import com.vip.movie.header.bean.Home;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by fan on 2017/11/8.
 */


public interface ApiServer {
    //卡片请求
    @POST
    Observable<CardBean> getcard(@Url String url, @QueryMap Map<String,String> map);
    //详情请求
    @POST
    Observable<DetailsBean> getdetails(@Url String url, @QueryMap Map<String,String> map);

public interface ApiServer {

    //主页
    @GET("front/homePageApi/homePage.do")
    Observable<Home> getHome();

}
