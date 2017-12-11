package com.vip.movie.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vip.movie.Adapter.MyBase;
import com.vip.movie.R;
import com.vip.movie.greendao.User;
import com.vip.movie.greendao.gen.UserDao;
import com.vip.movie.search.SearchAdapter;
import com.vip.movie.search.presenter.SearchPresenter;
import com.vip.movie.search.sbean.Insert;
import com.vip.movie.search.sbean.SearchBean;
import com.vip.movie.search.view.SearchView;
import com.vip.movie.utils.Api;
import com.vip.movie.utils.GreenDaoManager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends Activity implements SearchView {
    //relativeLayout   tuijian  search_ll  yingcheng
    SearchAdapter searchAdapter;
    @BindView(R.id.recycleview)
    RecyclerView recycleview;
    @BindView(R.id.relativeLayout)
    RelativeLayout relativeLayout;
    @BindView(R.id.tuijian)
    RelativeLayout tuijian;
    @BindView(R.id.search_ll)
    LinearLayout searchLl;
    @BindView(R.id.yingcheng)
    LinearLayout yingcheng;
    @BindView(R.id.tv_search)
    TextView tvSearch;
    @BindView(R.id.et_search)
    EditText etSearch;
    SearchPresenter searchPresenter;
    UserDao userDao;
    @BindView(R.id.gridview)
    GridView gridview;
    @BindView(R.id.clear)
    ImageView clear;
    GreenDaoManager greenDaoManager;
    private List<User> users;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ButterKnife.bind(this);
        userDao = GreenDaoManager.getInstance().getNewSession().getUserDao();
        greenDaoManager= GreenDaoManager.getInstance();
        searchPresenter = new SearchPresenter(this);
        //查询数据库
        users = greenDaoManager.loadAll(3);
     //   Log.d("555555",users.get(0).getName());
        final MyBase myBase = new MyBase(users, SearchActivity.this);
        gridview.setAdapter(myBase);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SearchActivity.this,"清空", Toast.LENGTH_SHORT).show();
                greenDaoManager.deleteAll(3);
                users.clear();
                myBase.notifyDataSetChanged();
            }
        });

        tvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayout.setVisibility(View.GONE);
                tuijian.setVisibility(View.GONE);
                searchLl.setVisibility(View.GONE);
                yingcheng.setVisibility(View.GONE);
                String s = etSearch.getText().toString();
                Insert insert1 = new Insert(s, "1");
                searchPresenter.insertt(Api.SEACHURL, insert1);
                Log.d("1111", s + "1111123456789");
                //searchPresenter.insert(s,insert);
                //数据库类型
                userDao.insert(new User(null, 3, s, null, null));

            }
        });


    }
    @Override
    public void getSearchView(List<SearchBean.RetBean.ListBean> list) {

        recycleview.setLayoutManager(new GridLayoutManager(SearchActivity.this, 3));
        searchAdapter = new SearchAdapter(list, SearchActivity.this);
        recycleview.setAdapter(searchAdapter);

    }

}
