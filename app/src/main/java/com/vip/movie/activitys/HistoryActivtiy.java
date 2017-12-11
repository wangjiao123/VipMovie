package com.vip.movie.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.vip.movie.R;
import com.vip.movie.adapters.HistoAdpater;
import com.vip.movie.greendao.User;
import com.vip.movie.utils.GreenDaoManager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HistoryActivtiy extends AppCompatActivity {

    @BindView(R.id.h_img)
    ImageView hImg;
    @BindView(R.id.qingl)
    TextView qing;
    @BindView(R.id.his_recy)
    RecyclerView hisRecy;
    private GreenDaoManager instance;
    private List<User> users;
    private HistoAdpater histoAdpater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_activtiy);
        ButterKnife.bind(this);
        instance=GreenDaoManager.getInstance();
        users=instance.loadAll(2);
      //  List<User> users = instance.getUserDao().loadAll();
        Log.e("HistoryActivtiy", users.toString());
        hisRecy.setLayoutManager(new GridLayoutManager(HistoryActivtiy.this, 3));
        histoAdpater = new HistoAdpater( HistoryActivtiy.this, this.users);
        hisRecy.setAdapter(histoAdpater);
    }

    @OnClick({R.id.h_img, R.id.qingl, R.id.his_recy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.h_img:
                finish();
                break;
            case R.id.qingl:
                instance.deleteAll(2);
                users.clear();
                histoAdpater.notifyDataSetChanged();
                Toast.makeText(HistoryActivtiy.this,"已清除",Toast.LENGTH_SHORT).show();
                break;
            case R.id.his_recy:
                break;
        }
    }
}
