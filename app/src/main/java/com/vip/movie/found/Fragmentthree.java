package com.vip.movie.found;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.vip.movie.MyApp;
import com.vip.movie.R;
import com.vip.movie.found.bean.CardBean;
import com.vip.movie.found.bean.CardConfig;
import com.vip.movie.found.bean.CardItemTouchHelperCallBack;
import com.vip.movie.found.bean.CardLayoutManager;
import com.vip.movie.found.bean.OnSwipeListener;
import com.vip.movie.found.presenter.MyFoudpresenter;
import com.vip.movie.found.view.Found_view;
import com.vip.movie.utils.Api;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by wangjiao on 2017/12/4.
 */

public class Fragmentthree extends Fragment implements Found_view {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    Unbinder unbinder;
    MyFoudpresenter mypre;
    @BindView(R.id.huan_btn)
    Button huanBtn;
    private static List<CardBean.RetBean.ListBean> list = new ArrayList<>();
    CardBean.RetBean.ListBean loadurl;
    private static int range = 100;
    private static int[] result;
    String dataId="";
    String pos="";
    MyAdapter myAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.three, null);
        unbinder = ButterKnife.bind(this, view);
        initView();
        mypre = new MyFoudpresenter(this);
        mypre.setcardurl(Api.Card_User, 1);

        return view;
    }

    public static int[] getNumber(int total) {
        int[] NumberBox = new int[total];           //容器A
        int[] rtnNumber = new int[total];           //容器B

        for (int i = 0; i < total; i++) {
            NumberBox[i] = i;     //先把N个数放入容器A中
        }
        int end = total - 1;

        for (int j = 0; j < total; j++) {
            int num = new Random().nextInt(end + 1);  //取随机数
            rtnNumber[j] = NumberBox[num];            //把随机数放入容器B
            NumberBox[num] = NumberBox[end];          //把容器A中最后一个数覆盖所取的随机数
            end--;                                    //缩小随机数所取范围
        }
        return rtnNumber;                           //返回int型数组
    }

    private void initView() {

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new MyAdapter(list,MyApp.getContext()));

        CardItemTouchHelperCallBack cardCallback = new CardItemTouchHelperCallBack(recyclerView.getAdapter(), list);

        cardCallback.setOnSwipedListener(new OnSwipeListener<CardBean.RetBean.ListBean>() {
            @Override
            public void onSwiping(RecyclerView.ViewHolder viewHolder, float ratio, int direction) {
                MyAdapter.MyViewHolder myHolder = (MyAdapter.MyViewHolder) viewHolder;
                viewHolder.itemView.setAlpha(1 - Math.abs(ratio) * 0.2f);
                if (direction == CardConfig.SWIPING_LEFT) {
                    myHolder.dislikeImageView.setAlpha(Math.abs(ratio));
                } else if (direction == CardConfig.SWIPING_RIGHT) {
                    myHolder.likeImageView.setAlpha(Math.abs(ratio));
                } else {
                    myHolder.dislikeImageView.setAlpha(0f);
                    myHolder.likeImageView.setAlpha(0f);
                }
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, CardBean.RetBean.ListBean o, int direction) {
                MyAdapter.MyViewHolder myHolder = (MyAdapter.MyViewHolder) viewHolder;
                viewHolder.itemView.setAlpha(1f);
                myHolder.dislikeImageView.setAlpha(0f);
                myHolder.likeImageView.setAlpha(0f);
//                Toast.makeText(getActivity(), direction == CardConfig.SWIPED_LEFT ? "swiped left" : "swiped right", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSwipedClear() {
                Toast.makeText(getActivity(), "data clear", Toast.LENGTH_SHORT).show();
                recyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mypre.setcardurl(Api.Card_User, 2);
                        recyclerView.getAdapter().notifyDataSetChanged();
                    }
                }, 3000L);
            }

        });
        final ItemTouchHelper touchHelper = new ItemTouchHelper(cardCallback);
        final CardLayoutManager cardLayoutManager = new CardLayoutManager(recyclerView, touchHelper);
        recyclerView.setLayoutManager(cardLayoutManager);
        touchHelper.attachToRecyclerView(recyclerView);
    }

    @Override
    public void getdata(CardBean data) {

//        Toast.makeText(MyApp.getContext(), data + "", Toast.LENGTH_SHORT).show();
        for (CardBean.RetBean.ListBean listBean : data.getRet().getList()) {
            list.add(listBean);
            loadurl = listBean;
            dataId=listBean.getDataId();

        }
        list.add(loadurl);

//        recyclerView.setAdapter(new MyAdapter(list,MyApp.getContext()));
        recyclerView.getAdapter().notifyDataSetChanged();


    }

    @OnClick(R.id.huan_btn)
    public void onViewClicked() {
//        Toast.makeText(MyApp.getContext(),loadurl,Toast.LENGTH_SHORT).show();
        list.clear();
        result = getNumber(range);
        for (int i = 0; i < range; i++) {
            mypre.setcardurl(Api.Card_User, result[i]);
        }

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
