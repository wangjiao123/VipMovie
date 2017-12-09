package com.vip.movie.fuli.Prestenter;

import com.vip.movie.fuli.Bean.Women;
import com.vip.movie.fuli.Model.Wmodel;
import com.vip.movie.fuli.View.WIview;

import java.util.List;

/**
 * Created by 闫鑫 on 2017/12/7.
 */

public class Wpresenter implements Wmodel.OnWomen{
    private Wmodel wmodel;
    private WIview wIview;
    public Wpresenter(WIview wIview) {
        this.wIview = wIview;
        this.wmodel =new Wmodel();
    }
    public void seturl(String url)
    {
        wmodel.getjson(url);
        wmodel.setOnWomenListener(this);
    }
    @Override
    public void setonWomenListener(List<Women.NewslistBean> newslist) {
        wIview.getWomeninfo(newslist);
    }
}
