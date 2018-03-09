package com.czy.stronger.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.czy.stronger.R;

import static com.czy.stronger.activity.MydemoActivity.score;

/**
 * Created by asus on 2017/12/5.
 */

public class DemoOutActivity extends Activity {
    private TextView out;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydemo_out);

        out = (TextView) findViewById(R.id.md_item_out);

        if (score > 23.9) {
            out.setText("偏胖：1.锻炼方案：跑步：60min\n" +
                    "                  俯卧撑：60个  15个/组\n" +
                    "                  深蹲：40个    20个/组\n" +
                    "      2.饮食方案：少糖、少脂\n" +
                    "                  早餐：豆浆250毫升，花卷50克，煮鸡蛋1个。\n" +
                    "\n" +
                    "　　              午餐：牛肉炒豆腐干（牛肉50克、豆腐干75克），炒小白菜（小白菜150克），米饭80克。\n" +
                    "\n" +
                    "　　              晚餐：肉片香干炒芹菜（瘦肉50克、芹菜100克、豆腐干50克），米饭80克。");
        }
        else if (score < 18.5) {
            out.setText("偏瘦：1.锻炼方案：俯卧撑：60个 10个/组\n" +
                    "                  卧推： 8组\n" +
                    "                  深蹲：50个   10个/组\n" +
                    "      2.饮食方案：早餐：燕麦片1碗，加一小把葡萄干、水煮鸡蛋2个、牛奶250ml（1盒）\n" +
                    "                  午餐：米饭2碗、牛肉1份、生菜1碗\n" +
                    "                  晚餐：米饭2碗、鸡胸肉1份、西兰花1份");
        } else {
            out.setText("正常：1.锻炼方案：跑步： 40min\n" +
                    "                  俯卧撑： 40个  20个/组\n" +
                    "                  引体向上：10个\n" +
                    "      2.饮食方案：早餐： 酸奶或牛奶250ml ，蔬菜水果适量,一杯燕麦粥或三片全麦面包，鸡蛋4                        " +
                    "        个（两全蛋，两蛋白） \n" +
                    "                  午餐：主食150g，红色肉类200g，蔬菜200g,水果适量 \n" +
                    "                  晚餐：主食100g，白色肉类200g，蔬菜200g,水果适量 ");
        }
    }
}
