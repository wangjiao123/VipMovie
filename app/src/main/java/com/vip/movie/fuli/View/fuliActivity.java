package com.vip.movie.fuli.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.vip.movie.Adapter.fuliAdapter;
import com.vip.movie.R;
import com.vip.movie.fuli.Bean.Women;
import com.vip.movie.fuli.Prestenter.Wpresenter;
import com.vip.movie.utils.Api;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class fuliActivity extends AppCompatActivity implements WIview {

    @BindView(R.id.fuli_recyclerview)
    RecyclerView fuliRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuli);
        ButterKnife.bind(this);
        fuliRecyclerview.setLayoutManager(new GridLayoutManager(this,2));
        Wpresenter w = new Wpresenter(this);
        w.seturl(Api.WOMEN_URL);
    }

    @Override
    public void getWomeninfo(List<Women.NewslistBean> newslis) {
        String title = newslis.get(0).getPicUrl();
        Toast.makeText(fuliActivity.this,title,Toast.LENGTH_SHORT).show();
        fuliAdapter fa=new fuliAdapter(newslis,fuliActivity.this);
        fuliRecyclerview.setAdapter(fa);
    }
}
