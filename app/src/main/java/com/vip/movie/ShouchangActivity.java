package com.vip.movie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.vip.movie.Adapter.ShoucangAdapter;
import com.vip.movie.greendao.User;
import com.vip.movie.greendao.gen.UserDao;
import com.vip.movie.utils.GreenDaoManager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShouchangActivity extends AppCompatActivity {
    UserDao userDao;
    @BindView(R.id.shoucang)
    RecyclerView shoucang;
    @BindView(R.id.sc_clear)
    Button scClear;
    private List<User> users;
    private ShoucangAdapter sa;
    private GreenDaoManager instance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shouchang);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        ButterKnife.bind(this);
        shoucang.setLayoutManager(new GridLayoutManager(this,2));
      //  userDao = MyApp.getInstance().getDaoSession().getUserDao();
      //  users = userDao.loadAll();
        instance = GreenDaoManager.getInstance();
        users = instance.loadAll(1);
        sa = new ShoucangAdapter(this, users);
        shoucang.setAdapter(sa);
    }

    @OnClick(R.id.sc_clear)
    public void onViewClicked() {
        userDao.deleteAll();
        users.clear();
        sa.notifyDataSetChanged();
    }
}
