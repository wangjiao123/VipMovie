package com.vip.movie.thematic;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vip.movie.R;

/**
 * Created by jingzhuang on 2017/12/4.
 */

public class Fragmenttwo extends Fragment {
    @Nullable
    @Override
    //景zz
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.two,null);
        return view;
    }
}

