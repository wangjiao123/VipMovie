package com.vip.movie.thematic;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.vip.movie.R;
import com.vip.movie.base.BaseFragment;
import com.vip.movie.thematic.apdate.TwoAdapter;
import com.vip.movie.thematic.bean.Myhome;
import com.vip.movie.thematic.bean.Myxiang;
import com.vip.movie.thematic.twopresenter.Twopresenter;
import com.vip.movie.thematic.twoview.Twoview;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by jingzhuang on 2017/12/4.
 */


public class Fragmenttwo extends BaseFragment  implements Twoview{

    @Override
    protected int getLayout() {
        return R.layout.two;

    }

    Unbinder unbinder;
    @BindView(R.id.lin)
    RelativeLayout lin;

    @BindView(R.id.xre_xrv)
    XRecyclerView xreXrv;
    @Nullable

    private TwoAdapter mAdapter;
    private GridLayoutManager manager;

    //景zz
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.two, null);

        unbinder = ButterKnife.bind(this, view);
        Twopresenter twopresenter = new Twopresenter(this);
        twopresenter.login();

        return view;

    }


    @Override
    public void onLoginSuccess(final List<Myhome.RetBean.ListBean> list) {
        //        GridLayoutManager layoutManager1=new GridLayoutManager(context,3);
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(layoutManager1);
        //List<Myhome.RetBean.ListBean.ChildListBean> childList = list.get(0).getChildList();
        ArrayList<Myhome.RetBean.ListBean> listBeans = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Myhome.RetBean.ListBean listBean = list.get(i);
            List<Myhome.RetBean.ListBean.ChildListBean> childList = list.get(i).getChildList();
            if (list.get(i).getTitle().equals("") || childList.get(0).getPic().equals("") || list.get(i).getTitle().equals("Banner") || list.get(i).getTitle().equals("免费推荐") || childList.get(0).getPic().equals("http://phonemovie.ks3-cn-beijing.ksyun.com/image/2017/11/28/1511855662282067261.jpg") || childList.get(0).getPic().equals("http://phonemovie.ks3-cn-beijing.ksyun.com/image/2017/12/06/1512542491372002306.jpg")) {
                listBeans.add(listBean);
            }
        }
        list.removeAll(listBeans);

        manager = new GridLayoutManager(getActivity(), 2);
        // idRecyclerview.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        xreXrv.setLayoutManager(manager);
        xreXrv.setAdapter(mAdapter = new TwoAdapter(list, getActivity()));

        mAdapter.setOnItemClickLitener(new TwoAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {

                Intent in = new Intent(getActivity(), Zhuantifenlei.class);

                in.putExtra("zhi", position+"");
                startActivity(in);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
        xreXrv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                xreXrv.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                xreXrv.refreshComplete();
            }
        });
    }

    @Override
    public void onLoginSuccess2(Myxiang.RetBean list) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

