package com.czy.stronger.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.czy.stronger.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by asus on 2017/11/9.
 */

public class MydemoActivity extends Activity {
    private Button back, change, see;
    private ListView myListView;
    private String[] a = {"方案一"};
    private double shengao;
    private double tizhong;
    private EditText edshengao;
    private EditText edtizhong;
    public static double score;
    private String id1;
    private String id2;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydemo);

        back = (Button) findViewById(R.id.mydemolist_back);
        change = (Button) findViewById(R.id.mydemolist_changhe);
        myListView = (ListView) findViewById(R.id.mydemolist);


        see = (Button) findViewById(R.id.md_see);
        edshengao = (EditText) findViewById(R.id.input_shengao);
        edtizhong = (EditText) findViewById(R.id.input_tizhong);

        see.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MydemoActivity.this, DemoOutActivity.class);
                startActivity(intent);
            }
        });


        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < 1; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("md_item_pic", R.drawable.mine_btn_left);//加图片
            map.put("md_item_name", a[i]);
            map.put("md_item_see", "查看");
            listItem.add(map);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItem, R.layout
                .activity_mydemo_item, new String[]{"md_item_pic", "md_item_name",
                "md_item_see"}, new int[]{
                R.id.md_item_pic, R.id.md_item_name, R.id.md_see
        });
        myListView.setAdapter(simpleAdapter);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jisuan();
                Toast.makeText(MydemoActivity.this,
                        String.valueOf(score),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void jisuan() {
        id1 = edtizhong.getText().toString();
        tizhong = Double.valueOf(id1);
        id2 = edshengao.getText().toString();
        shengao = Double.valueOf(id2);
        score = (tizhong / (shengao * shengao));
    }
}
