package com.vip.movie.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
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

public class CollectionActivitry extends AppCompatActivity {

    @BindView(R.id.c_img)
    ImageView cImg;
    @BindView(R.id.qing)
    TextView qing;
    @BindView(R.id.coll_recy)
    RecyclerView collRecy;
    private GreenDaoManager instance;
    private List<User> users;
    private HistoAdpater histoAdpater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection_activitry);
        ButterKnife.bind(this);
        instance = GreenDaoManager.getInstance();
        users = instance.loadAll(1);
        collRecy.setLayoutManager(new GridLayoutManager(CollectionActivitry.this, 3));
        histoAdpater = new HistoAdpater(CollectionActivitry.this, this.users);
        collRecy.setAdapter(histoAdpater);
    }

    @OnClick({R.id.c_img, R.id.qing})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.c_img:
                finish();
                break;
            case R.id.qing:
                instance.deleteAll(1);
                users.clear();
                histoAdpater.notifyDataSetChanged();
                // ToastUtil.showShort(CollectionActivity.this,"已清除");
                Toast.makeText(CollectionActivitry.this,"已清除",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
