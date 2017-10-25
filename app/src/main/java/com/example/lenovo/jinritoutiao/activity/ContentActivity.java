package com.example.lenovo.jinritoutiao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import com.example.lenovo.jinritoutiao.R;

public class ContentActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        getSupportActionBar().hide();
        WebView wb = (WebView) findViewById(R.id.wb);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        wb.loadUrl(url);
    }
}
