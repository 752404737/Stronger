package com.czy.stronger.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.czy.stronger.R;
import com.czy.stronger.activity.fragment.CommuFragment;
import com.czy.stronger.activity.fragment.MeFragment;
import com.czy.stronger.activity.fragment.MineFragment;
import com.czy.stronger.activity.fragment.VideoFragment;

/**
 * Created by asus on 2017/10/21.
 */

public class MainActivity extends Activity implements View.OnClickListener{
    private ImageView ig_btn1, ig_btn2, ig_btn3,ig_btn4;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ig_btn1 = (ImageView) findViewById(R.id.ig_btn1);
        ig_btn2 = (ImageView) findViewById(R.id.ig_btn2);
        ig_btn3 = (ImageView) findViewById(R.id.ig_btn3);
        ig_btn4 = (ImageView) findViewById(R.id.ig_btn4);
        ig_btn1.setOnClickListener(this);
        ig_btn2.setOnClickListener(this);
        ig_btn3.setOnClickListener(this);
        ig_btn4.setOnClickListener(this);
        /**
         * 第一步：拿到管理者
         * 第二步：开启事务
         * 第三步：替换
         * 第四步：提交
         */
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.replace(R.id.ll_layout, new CommuFragment());
        ig_btn1.setImageResource(R.drawable.main_btn1_red);
        beginTransaction.commit();
    }
    public void onClick(View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        switch (view.getId()) {
            case R.id.ig_btn1: //点击的是主页
                beginTransaction.replace(R.id.ll_layout, new CommuFragment());
                ig_btn1.setImageResource(R.drawable.main_btn1_red);
                ig_btn2.setImageResource(R.drawable.main_btn2);
                ig_btn3.setImageResource(R.drawable.main_btn3);
                ig_btn4.setImageResource(R.drawable.main_btn4);
                break;
            case R.id.ig_btn2: //点击的是收藏
                beginTransaction.replace(R.id.ll_layout, new MineFragment());
                ig_btn1.setImageResource(R.drawable.main_btn1);
                ig_btn2.setImageResource(R.drawable.main_btn2_red);
                ig_btn3.setImageResource(R.drawable.main_btn3);
                ig_btn4.setImageResource(R.drawable.main_btn4);
                break;
            case R.id.ig_btn3: //点击的是我的
                beginTransaction.replace(R.id.ll_layout, new VideoFragment());
                ig_btn1.setImageResource(R.drawable.main_btn1);
                ig_btn2.setImageResource(R.drawable.main_btn2);
                ig_btn3.setImageResource(R.drawable.main_btn3_red);
                ig_btn4.setImageResource(R.drawable.main_btn4);
                break;
            case R.id.ig_btn4: //点击的是收藏——点击的是个人
                beginTransaction.replace(R.id.ll_layout, new MeFragment());
                ig_btn1.setImageResource(R.drawable.main_btn1);
                ig_btn2.setImageResource(R.drawable.main_btn2);
                ig_btn3.setImageResource(R.drawable.main_btn3);
                ig_btn4.setImageResource(R.drawable.main_btn4_red);
                break;
        }
        beginTransaction.commit();
    }
}
