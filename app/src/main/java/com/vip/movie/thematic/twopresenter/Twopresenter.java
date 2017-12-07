package com.vip.movie.thematic.twopresenter;

import com.vip.movie.thematic.bean.Myhome;
import com.vip.movie.thematic.bean.Myxiang;
import com.vip.movie.thematic.twomodel.Twomodel;
import com.vip.movie.thematic.twoview.Twoview;

import java.util.List;

/**
 * Created by 景瑾 on 2017/12/6.
 */

public class Twopresenter implements Twomodel.OnFinishLisenter{

    private final Twoview userView;
    private final Twomodel userMode;

    public Twopresenter(Twoview userView) {
        this.userView = userView;
        this.userMode =new Twomodel();
    }
    public void login(){
        userMode.setOnFinishLisenter(this);
        userMode.login();


    }
    public void tiao(String id){
        userMode.setOnFinishLisenter(this);
        userMode.tiao(id);


    }
    @Override
    public void onFinish(List<Myhome.RetBean.ListBean> userBean) {
        userView.onLoginSuccess(userBean);

    }

    @Override
    public void onFinish2(Myxiang.RetBean userBean) {
        userView.onLoginSuccess2(userBean);
    }
}
