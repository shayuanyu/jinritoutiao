package com.example.lenovo.jinritoutiao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.example.lenovo.jinritoutiao.R;

public class Main1Activity extends BaseActivity {
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            startActivity(new Intent(Main1Activity.this, MainActivity.class));


        }
    };
    private TextView tv_xianqing;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_1main);
        initView();
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    sleep(3000);
                    handler.sendEmptyMessage(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        tv_xianqing.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main1Activity.this, MainActivity.class));
            }
        });


    }

    private void initView() {
        tv_xianqing = (TextView) findViewById(R.id.tv_xianqing);
    }
}