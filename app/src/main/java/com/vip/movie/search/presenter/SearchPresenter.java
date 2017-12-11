package com.vip.movie.search.presenter;

import com.vip.movie.search.model.SearchUserModel;
import com.vip.movie.search.sbean.Insert;
import com.vip.movie.search.sbean.SearchBean;
import com.vip.movie.search.view.SearchView;

import java.util.List;

/**
 * Created by wangjiao on 2017/12/10.
 */

public class SearchPresenter implements SearchUserModel.OnInsert {
    private final SearchView searchView;
    private final SearchUserModel searchUserModel ;


    public SearchPresenter(SearchView searchView) {
        this.searchView = searchView;
        this.searchUserModel = new SearchUserModel() ;
    }
    public void insertt(String url , Insert insert){
        searchUserModel.setOnInsert(this);
        searchUserModel.SearchUrl(url, insert);
    }


    @Override
    public void OnInsertListener(List<SearchBean.RetBean.ListBean> list) {
        searchView.getSearchView(list);
    }
}
