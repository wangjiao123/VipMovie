package com.vip.movie.search.view;

import com.vip.movie.search.sbean.SearchBean;

import java.util.List;

/**
 * Created by wangjiao on 2017/12/10.
 */

public interface SearchView {
    void getSearchView(List<SearchBean.RetBean.ListBean> list);
}
