package com.vip.movie.found.presenter;

import com.vip.movie.found.bean.CardBean;
import com.vip.movie.found.model.MyFoundmodel;
import com.vip.movie.found.view.Found_view;

/**
 * Created by Administrator on 2017/12/6 0006.
 */

public class MyFoudpresenter implements MyFoundmodel.OnFinishLisenter {
    private Found_view found_view;
    private MyFoundmodel myFoundmodel;

    public MyFoudpresenter(Found_view found_view) {
        this.found_view = found_view;
        this.myFoundmodel = new MyFoundmodel();
    }

    public   void  setcardurl(String url,int pnum){

        myFoundmodel.setOnFinishLisenter(this);
        myFoundmodel.carddata(url,pnum);

    }
    @Override
    public void onFinish(CardBean retbean) {
        found_view.getdata(retbean);

    }
}
