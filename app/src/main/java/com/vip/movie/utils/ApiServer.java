package com.vip.movie.utils;


import com.vip.movie.fuli.Bean.Women;

import retrofit2.http.GET;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by fan on 2017/11/8.
 */
//11
public interface ApiServer {
    @GET
    Observable<Women> getWomen(@Url String url);
}
