package com.vip.movie.utils;

import com.vip.movie.header.bean.Home;


import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by fan on 2017/11/8.
 */
public interface ApiServer {

    //主页
    @GET("front/homePageApi/homePage.do")
    Observable<Home> getHome();

}
