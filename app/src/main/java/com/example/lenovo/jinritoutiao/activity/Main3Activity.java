package com.example.lenovo.jinritoutiao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.jinritoutiao.R;
import com.example.lenovo.jinritoutiao.utis.App;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.HashMap;
import java.util.Map;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

public class Main3Activity extends BaseActivity implements View.OnClickListener{

    private ImageView image_back;
    private ImageView imageView2;
    private TextView tv_phoned;
    private TextView t_zc;
    private ImageView t_qq;
    private ImageView t_xlwb;
    private ImageView t_txwb;
    private ImageView t_rr;
    private ImageView view2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activitydenglu);
        initView();
        View view = View.inflate(Main3Activity.this, R.layout.item, null);
        view2 = (ImageView) view.findViewById(R.id.im2);
        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initView() {
        image_back = (ImageView) findViewById(R.id.image_back);

        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView2.setOnClickListener(this);
        tv_phoned = (TextView) findViewById(R.id.tv_phoned);
        tv_phoned.setOnClickListener(this);
        t_zc = (TextView) findViewById(R.id.t_zc);
        t_zc.setOnClickListener(this);
        t_qq = (ImageView) findViewById(R.id.t_qq);
        t_qq.setOnClickListener(this);
        t_xlwb = (ImageView) findViewById(R.id.t_xlwb);
        t_xlwb.setOnClickListener(this);
        t_txwb = (ImageView) findViewById(R.id.t_txwb);
        t_txwb.setOnClickListener(this);
        t_rr = (ImageView) findViewById(R.id.t_rr);
        t_rr.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.tv_phoned:
                //手机登陆
                startActivity(new Intent(Main3Activity.this,Main2Activity.class));
                break;
            case R.id.t_zc:

//打开注册页面
                RegisterPage registerPage = new RegisterPage();
                registerPage.setRegisterCallback(new EventHandler() {
                    public void afterEvent(int event, int result, Object data) {
// 解析注册结果
                        if (result == SMSSDK.RESULT_COMPLETE) {
                            @SuppressWarnings("unchecked")
                            HashMap<String, Object> phoneMap = (HashMap<String, Object>) data;
                            String country = (String) phoneMap.get("country");
                            String phone = (String) phoneMap.get("phone");
                        }
                    }
                });
                registerPage.show(Main3Activity.this);
                break;
            case R.id.t_qq:
                getqq();
                break;
        }
    }

    private void getqq() {
        App app = (App) getApplication();
        UMShareAPI umShareAPI = app.getUmShareAPI();
        if (umShareAPI.isInstall(Main3Activity.this, SHARE_MEDIA.QQ)) {
            // 获取用户资料授权
            umShareAPI.getPlatformInfo(Main3Activity.this, SHARE_MEDIA.QQ, new UMAuthListener() {

                private DisplayImageOptions options;

                @Override
                public void onStart(SHARE_MEDIA share_media) {

                }

                @Override
                public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                    Toast.makeText(Main3Activity.this, "成功了", Toast.LENGTH_LONG).show();
                    Toast.makeText(Main3Activity.this, "QQ登录成功", Toast.LENGTH_LONG).show();

                    String photoUrl = map.get("iconurl");

                    options = new DisplayImageOptions.Builder()
                            .displayer(new RoundedBitmapDisplayer(90))
                            .build();
                    ImageLoader.getInstance().displayImage(photoUrl, view2, options);
                }

                @Override
                public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                    Toast.makeText(Main3Activity.this, "失败：", Toast.LENGTH_LONG).show();
                }

                @Override
                public void onCancel(SHARE_MEDIA share_media, int i) {
                    Toast.makeText(Main3Activity.this, "取消了", Toast.LENGTH_LONG).show();
                }

            });
        } else {
            Toast.makeText(Main3Activity.this, "没有安装QQ", Toast.LENGTH_LONG).show();
        }
    }
}
