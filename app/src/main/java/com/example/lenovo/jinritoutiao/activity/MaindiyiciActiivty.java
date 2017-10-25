package com.example.lenovo.jinritoutiao.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.example.lenovo.jinritoutiao.R;
import com.example.lenovo.jinritoutiao.adapter.Mydiyici;

import java.util.ArrayList;
import java.util.List;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by Administrator on 2017/9/18.
 */

public class MaindiyiciActiivty extends BaseActivity {

    private ViewPager viewpager;
    private SharedPreferences sp;
   private View view4;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.actiondiyi1);
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
        initView();

            sp = getSharedPreferences("key", MODE_PRIVATE);
            boolean insert = sp.getBoolean("insert", false);
            if (insert) {
                Intent intent = new Intent(MaindiyiciActiivty.this, Main1Activity.class);
                startActivity(intent);
            } else {

                sp.edit().putBoolean("insert",true).commit();
                getnewData();
                button1 = (Button) view4.findViewById(R.id.button1);
                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MaindiyiciActiivty.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
            }


    }




    public void getnewData() {
        List<View> list=new ArrayList<View>();
        View view1 = View.inflate(this, R.layout.page1, null);
        View view2 = View.inflate(this, R.layout.page2, null);
       // View view3 = View.inflate(this, R.layout.page3, null);
       view4 = View.inflate(this, R.layout.page4, null);
        list.add(view1);
        list.add(view2);
     //   list.add(view3);
       list.add(view4);
        Mydiyici adapter=new Mydiyici(list,this);
        viewpager.setAdapter(adapter);

    }


    private void initView() {
        viewpager = (ViewPager) findViewById(R.id.viewpager);

    }
}
