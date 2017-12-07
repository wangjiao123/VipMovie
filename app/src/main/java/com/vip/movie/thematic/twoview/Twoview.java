package com.vip.movie.thematic.twoview;

import com.vip.movie.thematic.bean.Myhome;
import com.vip.movie.thematic.bean.Myxiang;

import java.util.List;

/**
 * Created by 景瑾 on 2017/12/6.
 */

public interface Twoview {
    void onLoginSuccess(List<Myhome.RetBean.ListBean> list);
    void onLoginSuccess2(Myxiang.RetBean list);
}
