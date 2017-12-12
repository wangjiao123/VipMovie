package com.vip.movie.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ListView;

import com.vip.movie.Adapter.AdapterVideoList;
import com.vip.movie.Adapter.VideoConstant;
import com.vip.movie.R;

import cn.jzvd.JZVideoPlayer;

public class VideoActivity extends AppCompatActivity {

//    @BindView(R.id.listviews)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
//        ButterKnife.bind(this);
        listView = findViewById(R.id.listviews);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(false);
        getSupportActionBar().setTitle("NormalListViewTinyWindow");

        listView = findViewById(R.id.listviews);

        listView.setAdapter(new AdapterVideoList(this,
                VideoConstant.videoUrls[0],
                VideoConstant.videoTitles[0],
                VideoConstant.videoThumbs[0]));

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                JZVideoPlayer.onScrollAutoTiny(view, firstVisibleItem, visibleItemCount, totalItemCount);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
