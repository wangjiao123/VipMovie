package com.vip.movie.search.model;

import com.vip.movie.search.sbean.Insert;

/**
 * Created by wangjiao on 2017/12/10.
 */

public interface SearchModel {
    void SearchUrl(String url, Insert insert);
}
