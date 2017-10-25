package com.example.lenovo.jinritoutiao.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.example.lenovo.jinritoutiao.R;

public class Main9Activity extends AppCompatActivity {

    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.actinsousuo);
        initView();

        webview.loadUrl("https://www.gome.com.cn");
    }

    private void initView() {
        webview = (WebView) findViewById(R.id.webview);
    }
}
