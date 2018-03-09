package com.czy.stronger.activity.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.czy.stronger.R;

/**
 * Created by asus on 2017/10/22.
 */

public class VideoFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_video, null);
        //找到按钮前要加view.
        return view;
    }
}
