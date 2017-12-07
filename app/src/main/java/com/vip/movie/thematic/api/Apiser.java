package com.vip.movie.thematic.api;


import com.vip.movie.thematic.bean.Myhome;
import com.vip.movie.thematic.bean.Myxiang;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by 景瑾 on 2017/11/23.
 */

public interface Apiser {
    @GET("homePageApi/homePage.do")
    Observable<Myhome> gethom();
    @POST
    Observable<Myxiang> postpage(@Url String url, @QueryMap Map<String, String> map);
    /*@POST
    Observable<Myping> ping(@Url String url, @QueryMap Map<String, String> map);*/
}
