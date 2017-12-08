package com.vip.movie.header.presenter;

import com.vip.movie.header.bean.Home;
import com.vip.movie.header.model.HomeModel;
import com.vip.movie.header.view.HView;

import java.util.List;

/**
 * Created by TA on 2017/12/6.
 */

public class HomePresenter implements HomeModel.OnFinish{
    private final HView hView ;
    private final HomeModel homeModel ;

    public HomePresenter(HView hView) {
        this.hView = hView;
        this.homeModel = new HomeModel() ;
    }

    public void getHome(String url){
        homeModel.setOnFinish(this);
        homeModel.getHome(url);
    }
    @Override
    public void OnFinishListener(Home.RetBean list) {
        hView.getHome(list);
    }
}
