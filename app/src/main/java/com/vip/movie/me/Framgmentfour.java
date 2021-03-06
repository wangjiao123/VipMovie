package com.vip.movie.me;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mikepenz.material_design_iconic_typeface_library.MaterialDesignIconic;
import com.vip.movie.R;
import com.vip.movie.activitys.CollectionActivitry;
import com.vip.movie.activitys.HistoryActivtiy;
import com.vip.movie.activitys.SettingsActivity;
import com.vip.movie.adapters.HistoAdpater;
import com.vip.movie.base.BaseFragment;

import com.vip.movie.utils.StringUtils;
import com.vip.movie.greendao.User;
import com.vip.movie.utils.GreenDaoManager;

import com.vip.movie.utils.theme.ColorTextView;

import org.simple.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by wangjiao on 2017/12/4.
 */

public class Framgmentfour extends BaseFragment {

    public static final String SET_THEME = "SET_THEME";

    @BindView(R.id.rl_them)
    RelativeLayout rlThem;
    @BindView(R.id.title_name)
    ColorTextView titleName;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.img_setting)
    ImageView imgSetting;
    @BindView(R.id.tv_history)
    TextView tvHistory;
    @BindView(R.id.tv_collection)
    TextView tvCollection;
    @BindView(R.id.tv_them)
    TextView tvThem;
    @BindView(R.id.tv_down)
    TextView tvDown;
    @BindView(R.id.lishi_recyclerview)
    RecyclerView fuliRecyclerview;
    @BindView(R.id.rl_down)
    RelativeLayout rlDown;
    private HistoAdpater histoAdpater;
    @Override
    protected int getLayout() {
        return R.layout.four;
    }

    @Override
    protected void initView(LayoutInflater inflater) {
        EventBus.getDefault().register(this);
        ((AppCompatActivity) getContext()).setSupportActionBar(toolbar);
        toolbar.setTitle("");
        titleName.setText(getResources().getString(R.string.mine_title));
        StringUtils.setIconDrawable(mContext, tvHistory, MaterialDesignIconic.Icon.gmi_account_calendar, 16, 15);
        StringUtils.setIconDrawable(mContext, tvDown, MaterialDesignIconic.Icon.gmi_time_countdown, 16, 15);
        StringUtils.setIconDrawable(mContext, tvCollection, MaterialDesignIconic.Icon.gmi_collection_bookmark, 16, 15);

        StringUtils.setIconDrawable(mContext, tvThem, MaterialDesignIconic.Icon.gmi_palette, 16, 15);

    }

    @OnClick(R.id.rl_them)
    public void onViewClicked() {
        Toast.makeText(getActivity(), "主题", Toast.LENGTH_LONG).show();


        EventBus.getDefault().post("", Framgmentfour.SET_THEME);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        final List<User> greenDaoBeans = GreenDaoManager.getInstance().loadAll(2);
        fuliRecyclerview.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        final ArrayList<User> arrayList = new ArrayList<>();
        int size = greenDaoBeans.size();
        if (size >= 3) {
            arrayList.add(greenDaoBeans.get(size - 1));
            arrayList.add(greenDaoBeans.get(size - 2));
            arrayList.add(greenDaoBeans.get(size - 3));
        } else {
            arrayList.addAll(greenDaoBeans);
        }

        histoAdpater = new HistoAdpater( getActivity(),arrayList);
        fuliRecyclerview.setAdapter(histoAdpater);
        //5   arrayList.clear();
        histoAdpater.notifyDataSetChanged();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @OnClick({R.id.img_setting, R.id.tv_history, R.id.tv_collection, R.id.tv_them, R.id.tv_down})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_setting:
                Intent intent = new Intent(getActivity(), SettingsActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_history:
                Intent intent1 = new Intent(getActivity(), HistoryActivtiy.class);
                startActivity(intent1);
                break;
            case R.id.tv_collection:
                Intent intent2 = new Intent(getActivity(), CollectionActivitry.class);
                startActivity(intent2);
                break;
            case R.id.tv_them:
                break;
            case R.id.tv_down:
                Toast.makeText(getActivity(),"敬请期待",Toast.LENGTH_SHORT).show();
                break;
        }
    }


}

