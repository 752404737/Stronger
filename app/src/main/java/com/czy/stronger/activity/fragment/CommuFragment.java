package com.czy.stronger.activity.fragment;


import android.app.Fragment;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.amator.simplebanner.listener.OnBannerClickListener;
import com.amator.simplebanner.widget.SimpleBanner;
import com.czy.stronger.R;
import com.czy.stronger.activity.news.news_1;
import com.czy.stronger.activity.news.news_2;
import com.czy.stronger.activity.news.news_3;
import com.czy.stronger.activity.news.news_4;
import com.czy.stronger.activity.news.news_5;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2017/10/22.
 */

public class CommuFragment extends Fragment{

    private SimpleBanner mBanner;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    /**
    private String[] defaultUrl = new String[]{
            "http://g.hiphotos.baidu.com/imgad/pic/item/a8773912b31bb051be533b24317adab44aede043.jpg",
            "http://g.hiphotos.baidu.com/imgad/pic/item/c75c10385343fbf22c362d2fb77eca8065388fa0.jpg",
            "http://liaoning.sinaimg.cn/2014/1111/U10435P1195DT20141111220802.jpg",
            "http://photocdn.sohu.com/20151124/mp43786429_1448294862260_4.jpeg",
            "http://h.hiphotos.baidu.com/image/pic/item/faedab64034f78f0b00507c97e310a55b3191cf9.jpg"};**/

    private int[] imaRes = {R.drawable.ban1, R.drawable.ban2, R.drawable.ban3, R.drawable.ban4, R.drawable.ban5};

    private String[] titleRes = {"深色", "浅色", "动物", "宋智孝", "宋智孝"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_commu, container, false);

        mRecyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);

        mLayoutManager = new LinearLayoutManager(getActivity());

        mRecyclerView.setLayoutManager(mLayoutManager);

        MyAdapter adapter = new MyAdapter(initDate());

        mRecyclerView.setAdapter(adapter);

        mRecyclerView.addItemDecoration(new SpacesItemDecoration(8));





        return view;
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        TextView titleText = (TextView) getView().findViewById(R.id.title_text);
        titleText.setText("Community");
        //加载本地图片

        List<Integer> mImages = new ArrayList<>();
        for (int i = 0; i < imaRes.length; i++) {
            mImages.add(imaRes[i]);
        }

        /*加载网络图片
        final List<String> mImageRes = new ArrayList<>();
        for (int i = 0; i < defaultUrl.length; i++) {
            mImageRes.add(defaultUrl[i]);
        }*/
        List<String> tips = new ArrayList<>();
        for (int i = 0; i < titleRes.length; i++) {
            tips.add(titleRes[i]);
        }

        mBanner = (SimpleBanner)getView().findViewById(R.id.banner_simple);
        mBanner.setImageRes(mImages)
                .start();//调用则表示允许自动循环播放
        mBanner.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void onBannerClick(int i) {
                switch (i){
                    case 0:
                        Intent intent_1 = new Intent(getActivity(), news_1.class);
                        startActivity(intent_1);
                        break;
                    case 1:
                        Intent intent_2 = new Intent(getActivity(), news_2.class);
                        startActivity(intent_2);
                        break;
                    case 2:
                        Intent intent_3 = new Intent(getActivity(), news_3.class);
                        startActivity(intent_3);
                        break;
                    case 3:
                        Intent intent_4 = new Intent(getActivity(), news_4.class);
                        startActivity(intent_4);
                        break;
                    case 4:
                        Intent intent_5 = new Intent(getActivity(), news_5.class);
                        startActivity(intent_5);
                        break;
                }

            }
        });



        final FloatingActionsMenu menuMultipleActions = (FloatingActionsMenu) getView().findViewById(R.id.multiple_actions);


        final FloatingActionButton actionA = (FloatingActionButton) getView().findViewById(R.id.action_a);
        actionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "点击此处查看消息", Toast.LENGTH_SHORT).show();
            }
        });

        final FloatingActionButton actionB = (FloatingActionButton) getView().findViewById(R.id.action_b);
        actionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "点击此处发帖", Toast.LENGTH_SHORT).show();
            }
        });
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onPause() {
        super.onPause();
        //释放资源避免内存泄漏
        mBanner.stop();
    }


    private List<String> initDate(){
        List<String> list = new ArrayList<>();
        for(int i=0;i<50;i++){
            list.add("测试用例：" + i);
        }
        return list;
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
        private List<String> items;

        public MyAdapter(List<String> items){
            this.items = items;
        }

        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_item_commu, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyAdapter.ViewHolder holder, int position){
            holder.mTextView.setText(items.get(position));
        }

        @Override
        public int getItemCount(){
            return items.size();
        }

         public class ViewHolder extends RecyclerView.ViewHolder{
            public TextView mTextView;
            public ViewHolder(View itemView){
                super(itemView);
                mTextView = (TextView)itemView.findViewById(R.id.commu_item_text);
            }
        }


    }

    public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private int space;

        public SpacesItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view,
                                   RecyclerView parent, RecyclerView.State state) {
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;

            // Add top margin only for the first item to avoid double space between items
            if (parent.getChildPosition(view) == 0)
                outRect.top = space;
        }
    }

}