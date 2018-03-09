package com.czy.stronger.activity.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.czy.stronger.R;
import com.czy.stronger.activity.MydemoActivity;
import com.czy.stronger.activity.YuyueActivity;

/**
 * Created by asus on 2017/10/22.
 */

public class MineFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_mine, null);
        view.findViewById(R.id.btn_left).setOnClickListener(this);
        view.findViewById(R.id.btn_right).setOnClickListener(this);
        view.findViewById(R.id.mine_wodefangan).setOnClickListener(this);
        //找到按钮前要加view.
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_left:
                getActivity().startActivity(new Intent(getActivity(), YuyueActivity.class));
                break;
            case R.id.mine_wodefangan:
                getActivity().startActivity(new Intent(getActivity(), MydemoActivity.class));
                break;
            default:
                break;
        }
    }
}
