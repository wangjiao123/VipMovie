package com.vip.movie.details.presenter;

import com.vip.movie.details.bean.DetailsBean;
import com.vip.movie.details.model.MyDetailsmodel;
import com.vip.movie.details.view.Details_view;

/**
 * Created by Administrator on 2017/12/7 0007.
 */

public class MyDeatilspresenter implements MyDetailsmodel.OnFinishLisenter{
    private Details_view details_view;
    private MyDetailsmodel detailsmodel;

    public MyDeatilspresenter(Details_view details_view) {
        this.details_view = details_view;
        this.detailsmodel = new MyDetailsmodel();
    }
    public   void  setdetails(String url,String mediaId){

        detailsmodel.setOnFinishLisenter(this);
        detailsmodel.detailsdata(url,mediaId);

    }

    @Override
    public void onFinish(DetailsBean retbean) {
        details_view.getdata(retbean);
    }
}
