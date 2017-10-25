package com.example.lenovo.jinritoutiao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.jinritoutiao.R;

public class Main8Activity extends AppCompatActivity implements View.OnClickListener{

    private TextView huati;
    private ImageView img_retun;
    private TextView tv_tittle;
    private ImageView jiahaoo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main8);
        initView();
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        tv_tittle.setText(name);
        huati.setText("暂无" + name);
        huati.setTextSize(20);
    }

    private void initView() {
        huati = (TextView) findViewById(R.id.huati);
        img_retun = (ImageView) findViewById(R.id.img_retun);
        img_retun.setOnClickListener(this);
        tv_tittle = (TextView) findViewById(R.id.tv_tittle);
        jiahaoo = (ImageView) findViewById(R.id.jiahaoo);
        jiahaoo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
           switch (v.getId()){
               case R.id.img_retun:
                   finish();
                   break;
               case R.id.jiahaoo:
                    //   "请检查您的网络状态"
                   Toast.makeText(this, "请检查您的网络状态", Toast.LENGTH_SHORT).show();
                   break;



           }
    }
}
