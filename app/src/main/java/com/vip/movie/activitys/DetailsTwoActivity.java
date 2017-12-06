package com.vip.movie.activitys;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.dou361.ijkplayer.widget.IjkVideoView;
import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.vip.movie.R;
import com.vip.movie.adapters.HomeAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsTwoActivity extends AppCompatActivity {

    List<String> mData;
    @BindView(R.id.video_view)
    IjkVideoView videoView;
    @BindView(R.id.iv_trumb)
    ImageView ivTrumb;
    @BindView(R.id.ll_bg)
    LinearLayout llBg;
    @BindView(R.id.app_video_status_text)
    TextView appVideoStatusText;
    @BindView(R.id.app_video_replay_icon)
    ImageView appVideoReplayIcon;
    @BindView(R.id.app_video_replay)
    LinearLayout appVideoReplay;
    @BindView(R.id.app_video_netTie_icon)
    TextView appVideoNetTieIcon;
    @BindView(R.id.app_video_netTie)
    LinearLayout appVideoNetTie;
    @BindView(R.id.app_video_speed)
    TextView appVideoSpeed;
    @BindView(R.id.app_video_loading)
    LinearLayout appVideoLoading;
    @BindView(R.id.app_video_volume_icon)
    ImageView appVideoVolumeIcon;
    @BindView(R.id.app_video_volume)
    TextView appVideoVolume;
    @BindView(R.id.app_video_volume_box)
    LinearLayout appVideoVolumeBox;
    @BindView(R.id.app_video_brightness_icon)
    ImageView appVideoBrightnessIcon;
    @BindView(R.id.app_video_brightness)
    TextView appVideoBrightness;
    @BindView(R.id.app_video_brightness_box)
    LinearLayout appVideoBrightnessBox;
    @BindView(R.id.app_video_fastForward)
    TextView appVideoFastForward;
    @BindView(R.id.app_video_fastForward_target)
    TextView appVideoFastForwardTarget;
    @BindView(R.id.app_video_fastForward_all)
    TextView appVideoFastForwardAll;
    @BindView(R.id.app_video_fastForward_box)
    LinearLayout appVideoFastForwardBox;
    @BindView(R.id.app_video_center_box)
    FrameLayout appVideoCenterBox;
    @BindView(R.id.app_video_finish)
    ImageView appVideoFinish;
    @BindView(R.id.app_video_title)
    TextView appVideoTitle;
    @BindView(R.id.app_video_menu)
    ImageView appVideoMenu;
    @BindView(R.id.app_video_top_box)
    LinearLayout appVideoTopBox;
    @BindView(R.id.app_video_play)
    ImageView appVideoPlay;
    @BindView(R.id.app_video_currentTime_full)
    TextView appVideoCurrentTimeFull;
    @BindView(R.id.app_video_currentTime_left)
    TextView appVideoCurrentTimeLeft;
    @BindView(R.id.app_video_endTime_left)
    TextView appVideoEndTimeLeft;
    @BindView(R.id.app_video_lift)
    LinearLayout appVideoLift;
    @BindView(R.id.app_video_seekBar)
    SeekBar appVideoSeekBar;
    @BindView(R.id.app_video_currentTime)
    TextView appVideoCurrentTime;
    @BindView(R.id.app_video_endTime)
    TextView appVideoEndTime;
    @BindView(R.id.app_video_center)
    LinearLayout appVideoCenter;
    @BindView(R.id.app_video_endTime_full)
    TextView appVideoEndTimeFull;
    @BindView(R.id.app_video_process_panl)
    LinearLayout appVideoProcessPanl;
    @BindView(R.id.app_video_stream)
    TextView appVideoStream;
    @BindView(R.id.ijk_iv_rotation)
    ImageView ijkIvRotation;
    @BindView(R.id.app_video_fullscreen)
    ImageView appVideoFullscreen;
    @BindView(R.id.ll_bottom_bar)
    LinearLayout llBottomBar;
    @BindView(R.id.simple_player_volume_controller)
    SeekBar simplePlayerVolumeController;
    @BindView(R.id.simple_player_volume_controller_container)
    LinearLayout simplePlayerVolumeControllerContainer;
    @BindView(R.id.simple_player_brightness_controller)
    SeekBar simplePlayerBrightnessController;
    @BindView(R.id.simple_player_brightness_controller_container)
    LinearLayout simplePlayerBrightnessControllerContainer;
    @BindView(R.id.simple_player_settings_container)
    LinearLayout simplePlayerSettingsContainer;
    @BindView(R.id.simple_player_select_streams_list)
    ListView simplePlayerSelectStreamsList;
    @BindView(R.id.simple_player_select_stream_container)
    LinearLayout simplePlayerSelectStreamContainer;
    @BindView(R.id.play_icon)
    ImageView playIcon;
    @BindView(R.id.app_video_box)
    RelativeLayout appVideoBox;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.ll_sc_content)
    LinearLayout layout;




    private List<String> mDatas;
    HomeAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailstwo);
        ButterKnife.bind(this);
         /*View rootView = getLayoutInflater().from(this).inflate(R.layout.simple_player_view_player, null);
        setContentView(rootView);*/
        String url = "http://movie.vods2.cnlive.com/3/vod/2017/1011/3_2a484c9357054db5901d4502247ee89d/ff8080815f09fc82015f0a1b9dab0056_1500.m3u8";
        Toast.makeText(DetailsTwoActivity.this, url, Toast.LENGTH_SHORT).show();
        new PlayerView(this)
                .setTitle("什么")
                .setScaleType(PlayStateParams.fitparent)
                .hideMenu(true)
                .forbidTouch(false)
                .setPlaySource(url)
                .startPlay();
        initData(1);
        initView();
    }
    private void initData(int pager) {
        mData = new ArrayList<>();
        for (int i = 1; i < 50; i++) {
            mData.add("pager" + pager + " 第" + i + "个item");
        }
    }

    private void initView() {
        //设置ToolBar
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setTitle("");
//        toolbar.setNavigationIcon(R.drawable.arrow_back);
//        setSupportActionBar(toolbar);//替换系统的actionBar

        //设置TabLayout
//        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        tabLayout.addTab(tabLayout.newTab().setText("简介"));
        tabLayout.addTab(tabLayout.newTab().setText("评论"));
        Log.d("main", "setScrollViewContent: 333333333333333333333333333333333");

        //TabLayout的切换监听
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                initData(tab.getPosition() + 1);
                setScrollViewContent();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        setScrollViewContent();
    }

    private void setScrollViewContent() {
        //NestedScrollView下的LinearLayout

        layout.removeAllViews();
        initData();
        for (int i = 0; i < mData.size(); i++) {
            View view = View.inflate(DetailsTwoActivity.this, R.layout.item_layout, null);
            RecyclerView idRecyclerview=view.findViewById(R.id.id_recyclerview);
            idRecyclerview.setLayoutManager(new LinearLayoutManager(this));
            Log.d("main", "setScrollViewContent: 000000000000000000000000000000000000000000000000000");
            idRecyclerview.setAdapter(mAdapter = new HomeAdapter(DetailsTwoActivity.this, mDatas));


            //动态添加 子View
            layout.addView(view, i);
        }
    }

    protected void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i);
        }
    }
}
