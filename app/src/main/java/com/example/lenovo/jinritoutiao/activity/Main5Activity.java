package com.example.lenovo.jinritoutiao.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.jinritoutiao.R;

public class Main5Activity extends BaseActivity implements View.OnClickListener {


    private ImageView img_retunc;

    private CheckBox tuijianj;
    private CheckBox redian11;
    private CheckBox redianr;
    private CheckBox tiyut;
    private CheckBox kejij;
    private CheckBox junshijj;
    private CheckBox shishang1;
    private CheckBox yulel;
    private ImageView image_rett;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity5lixian);
        initView();
        image_rett = (ImageView) findViewById(R.id.imag_rett);
        image_rett.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public void onClick(View v) {
        TextView txt = (TextView)v;
        switch (txt.getId()) {

            case R.id.tuijianj:
                if(tuijianj.isChecked())
                {
                    showToast("你选中的是：推荐");
                }else
                {
                    showToast("你取消的是：推荐");
                }
                break;
            case R.id.redianr:
                if(redianr.isChecked())
                {
                    showToast("你选中的是：财经");
                }else
                {
                    showToast("你取消的是：财经");
                }
                break;
            case R.id.tiyut:
                if(tiyut.isChecked())
                {
                    showToast("你选中的是：体育"+txt.getText().toString());
                }else
                {
                    showToast("你取消的是：体育"+txt.getText().toString());
                }
                break;
            case R.id.kejij:
                if(kejij.isChecked())
                {
                    showToast("你选中的是：科技"+txt.getText().toString());
                }else
                {
                    showToast("你取消的是：科技"+txt.getText().toString());
                }
                break;

            case R.id.junshijj:
                if(junshijj.isChecked())
                {
                    showToast("你选中的是：军事"+txt.getText().toString());
                }else
                {
                    showToast("你取消的是：军事"+txt.getText().toString());
                }
                break;
            case R.id.shishang1:
                if(shishang1.isChecked())
                {
                    showToast("你选中的是：时尚"+txt.getText().toString());
                }else
                {
                    showToast("你取消的是：时尚"+txt.getText().toString());
                }
                break;
            case R.id.yulel:
                if(yulel.isChecked())
                {
                    showToast("你选中的是：娱乐"+txt.getText().toString());
                }else
                {
                    showToast("你取消的是：娱乐"+txt.getText().toString());
                }
                break;
            case R.id.redian11:
                if(redian11.isChecked())
                {
                    showToast("你选中的是：热点"+txt.getText().toString());
                }else
                {
                    showToast("你取消的是：热点"+txt.getText().toString());
                }
                break;
            default:
                break;
        }



    }

    private void initView() {


        tuijianj = (CheckBox) findViewById(R.id.tuijianj);
        tuijianj.setOnClickListener(this);
        redianr = (CheckBox) findViewById(R.id.redianr);
        redianr.setOnClickListener(this);
        tiyut = (CheckBox) findViewById(R.id.tiyut);
        tiyut.setOnClickListener(this);
        kejij = (CheckBox) findViewById(R.id.kejij);
        kejij.setOnClickListener(this);
        junshijj = (CheckBox) findViewById(R.id.junshijj);
        junshijj.setOnClickListener(this);
        shishang1 = (CheckBox) findViewById(R.id.shishang1);
        shishang1.setOnClickListener(this);
        yulel = (CheckBox) findViewById(R.id.yulel);
        yulel.setOnClickListener(this);
        redianr = (CheckBox) findViewById(R.id.redianr);
        redianr.setOnClickListener(this);
        redian11 = (CheckBox) findViewById(R.id.redian11);
        redian11.setOnClickListener(this);
    }
    /**
     * toast
     * @param str
     */
    private void showToast(String str) {
        // TODO Auto-generated method stub
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
    }
}
