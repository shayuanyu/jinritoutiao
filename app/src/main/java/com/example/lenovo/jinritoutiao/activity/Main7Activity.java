package com.example.lenovo.jinritoutiao.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.lenovo.jinritoutiao.R;

public class Main7Activity extends BaseActivity {

    private EditText edit_sousuo;
    private ImageView imag_sousuo;
    private WebView webview;
    private ImageView image_return;
    private LinearLayout linera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main7);
        initView();
        findViewById(R.id.linera).setVisibility(View.INVISIBLE);
        webview.loadUrl("http://www.baidu.com");
        image_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    private void initView() {


        edit_sousuo = (EditText) findViewById(R.id.edit_sousuo);
        imag_sousuo = (ImageView) findViewById(R.id.imag_sousuo);
        webview = (WebView) findViewById(R.id.webview);
        image_return = (ImageView) findViewById(R.id.image_return);

        linera = (LinearLayout) findViewById(R.id.linera);

    }

    private void submit() {
        // validate
        String sousuo = edit_sousuo.getText().toString().trim();
        if (TextUtils.isEmpty(sousuo)) {
            Toast.makeText(this, "搜索感兴趣的内容", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}

