package com.vip.movie.activitys;

import android.os.Bundle;
import android.support.design.widget.TabLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.dou361.ijkplayer.widget.PlayStateParams;
import com.dou361.ijkplayer.widget.PlayerView;
import com.vip.movie.MyApp;
import com.vip.movie.R;
import com.vip.movie.adapters.HomeAdapter;
import com.vip.movie.adapters.PinlunAdapter;
import com.vip.movie.bean.PinlunBean;
import com.vip.movie.details.bean.DetailsBean;
import com.vip.movie.details.fragments.JianFragment;
import com.vip.movie.details.fragments.PinFragment;
import com.vip.movie.details.presenter.MyDeatilspresenter;
import com.vip.movie.details.view.Details_view;
import com.vip.movie.found.bean.EventBusStickMessage;
import com.vip.movie.greendao.User;
import com.vip.movie.greendao.gen.UserDao;
import com.vip.movie.utils.Api;
import com.vip.movie.utils.GreenDaoManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsTwoActivity extends FragmentActivity implements Details_view {


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

    FrameLayout layout;



    private List<DetailsBean> mData;
    List<PinlunBean.RetBean.ListBean> list;
    HomeAdapter mAdapter;
    PinlunAdapter pinlunAdapter;
    String mediaid = "";
    MyDeatilspresenter mypre;
    private String url;
    private String des;
    private String title;

    private String pic;
    private UserDao dao;
    private TextView dtext;
 //   private List<User> users;
    private String video;
    private GreenDaoManager instance;
    FragmentManager manager;
    List<Fragment> frag;
    JianFragment jf;
    PinFragment pf;
    private PlayerView p;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailstwo);
        ButterKnife.bind(this);


        dtext=(TextView) findViewById(R.id.dtext);



        final String url = "http://movie.vods2.cnlive.com/3/vod/2017/1011/3_2a484c9357054db5901d4502247ee89d/ff8080815f09fc82015f0a1b9dab0056_1500.m3u8";
        Toast.makeText(DetailsTwoActivity.this, url, Toast.LENGTH_SHORT).show();
        new PlayerView(this)
                .setTitle("什么")
                .setScaleType(PlayStateParams.fitparent)
                .hideMenu(true)
                .forbidTouch(false)
                .setPlaySource(url)
                .startPlay();




        EventBus.getDefault().register(this);
        mypre = new MyDeatilspresenter(this);
        mypre.setdetails(Api.Card_User, mediaid);
        mData = new ArrayList<>();
        list = new ArrayList<>();
        tabLayout.getBackground().setAlpha(10);

        dao = GreenDaoManager.getInstance().getNewSession().getUserDao();
        instance=GreenDaoManager.getInstance();
      //  users=instance.loadAll(2);

        initView();
        dtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (url==null)
                {
                    Toast.makeText(DetailsTwoActivity.this,"地址为空",Toast.LENGTH_SHORT).show();
                }else{
                    boolean isrepetition = GreenDaoManager.getInstance().isrepetition(mediaid, 1);

        initView();
        jf = new JianFragment(mData);


                    if(!isrepetition)
                    {
                        dao.insert(new User(null, 1, title, pic, mediaid));
                        Toast.makeText(DetailsTwoActivity.this,"已收藏",Toast.LENGTH_SHORT).show();


                    }else {
                        Toast.makeText(DetailsTwoActivity.this,"不能重复收藏",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }



    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void receiveMessage(EventBusStickMessage eventBusStickMessage) {
        mediaid = eventBusStickMessage.Message;
    }
    @Override
    protected void onDestroy() {
        //移除所有黏性事件
        EventBus.getDefault().removeAllStickyEvents();
        //销毁EventBus
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    private void initView() {

    public void addFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.ll_sc_content, fragment);
        transaction.addToBackStack(null);
        // 执行事务
        transaction.commit();
    }



    private void initView() {
        tabLayout.addTab(tabLayout.newTab().setText("简介"));
        tabLayout.addTab(tabLayout.newTab().setText("评论"));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //  这里监听tab在哪个页面
                if (tab.getText().equals("简介")) {
                    mData.clear();
                    mypre.setdetails(Api.Card_User, mediaid);

                } else if (tab.getText().equals("评论")) {

                    Toast.makeText(MyApp.getContext(), mediaid + "评论id", Toast.LENGTH_SHORT).show();
                    mypre.setpinlun(Api.Card_User, mediaid);
                }
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

        layout.removeAllViews();

    }


    @Override
    public void getdata(DetailsBean data) {

        url = data.getRet().getSmoothURL();
        des = data.getRet().getDescription();
        title = data.getRet().getTitle();
         pic = data.getRet().getPic();
        mData.add(data);

        if (url==null)
        {
            Toast.makeText(DetailsTwoActivity.this,"地址为空",Toast.LENGTH_SHORT).show();
        }else{

                dao.insert(new User(null, 2, title, pic, mediaid));
                new PlayerView(this)
                        .setTitle(data.getRet().getTitle())
                        .setScaleType(PlayStateParams.fitparent)
                        .hideMenu(true)
                        .forbidTouch(false)
                        .setPlaySource(url)
                        .startPlay();


        }

        for (int i = 0; i < mData.size(); i++) {
            View view = View.inflate(DetailsTwoActivity.this, R.layout.item_layout, null);
            RecyclerView idRecyclerview=view.findViewById(R.id.id_recyclerview);
            idRecyclerview.setLayoutManager(new LinearLayoutManager(this));
//            Log.d("main", "setScrollViewContent: 000000000000000000000000000000000000000000000000000");
            idRecyclerview.setAdapter(mAdapter = new HomeAdapter(DetailsTwoActivity.this, mData));
            //动态添加 子View
            layout.addView(view, i);
        }

        addFragment(jf);

        p = new PlayerView(this)
                .setTitle(data.getRet().getTitle())
                .setScaleType(PlayStateParams.fitparent)
                .hideMenu(true)
                .forbidTouch(false)
                .setPlaySource(url)
                .startPlay();
    }

    @Override
    public void getpinlun(PinlunBean data) {
        list = data.getRet().getList();
        pf = new PinFragment(list);
        // Toast.makeText(MyApp.getContext(),list+"评论数据", Toast.LENGTH_SHORT).show();
        addFragment(pf);

    }

    @Override
    protected void onPause() {
        super.onPause();
        this.finish();
        p.stopPlay();
    }
}
