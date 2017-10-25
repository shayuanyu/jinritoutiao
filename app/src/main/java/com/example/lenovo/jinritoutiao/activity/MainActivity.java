package com.example.lenovo.jinritoutiao.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.andy.library.ChannelActivity;
import com.andy.library.ChannelBean;
import com.example.lenovo.jinritoutiao.R;
import com.example.lenovo.jinritoutiao.adapter.MyMdapter;
import com.example.lenovo.jinritoutiao.bean.bean;
import com.example.lenovo.jinritoutiao.fragment.Fragment1;
import com.example.lenovo.jinritoutiao.utis.App;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//import com.andy.library.ChannelActivity;
//import com.andy.library.ChannelBean;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imagetouxiang;
    private TabLayout tabLayout;
    private ListView listView;
    private DrawerLayout drawerLayout;
    private MyMdapter adapter;
    private List<ChannelBean> list1;
    private String jsonStr;
    private int[] img = new int[]{R.drawable.huo, R.drawable.xinxi, R.drawable.xin, R.drawable.huodong, R.drawable.shangcheng};
    private String[] arr = new String[]{"好友动态", "我的话题", "收藏", "活动", "商城"};
    private final String[] mTitles = new String[]{"推荐","财经","体育", "科技", "军事", "时尚", "娱乐"};
    private final String[] mTitlesContent = new String[]{"tuijian","caijing","tiyu", "keji", "junshi", "shishang", "yule"};
    private com.example.lenovo.jinritoutiao.bean.bean bean;
    private List<com.example.lenovo.jinritoutiao.bean.bean> list;
    private ViewPager v;
    private List<Fragment> fragment;
    private ImageView view2;
    private ImageView image_channel;


    private View item_t;
    private ImageView image_t;
    private TextView item_name;
    private TextView item_x;
    private View view;
    private ImageView butt_sousuo;
    private WebView webview;
    private ImageView i3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        initView();
        view = View.inflate(MainActivity.this, R.layout.item, null);
        ImageView im1 = (ImageView) view.findViewById(R.id.im1);
        view2 = (ImageView) view.findViewById(R.id.im2);
        i3 = (ImageView) view.findViewById(R.id.i3);
        TextView imgfangshi = (TextView) view.findViewById(R.id.tv_gengduofangshi);
        View view1 = View.inflate(MainActivity.this, R.layout.item3, null);
        ImageView image1 = (ImageView) view1.findViewById(R.id.image1);
        ImageView image2 = (ImageView) view1.findViewById(R.id.image2);
        ImageView image3 = (ImageView) view1.findViewById(R.id.image3);

         PDguanli();

        //跳转到更多方式
        imgfangshi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main3Activity.class));
            }
        });
        //离线下载
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main5Activity.class));
            }
        });
        //设置
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Main4Activity.class));
            }
        });
        ////短信验证
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

        //日夜间切换
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
                if (mode == Configuration.UI_MODE_NIGHT_YES) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                } else if (mode == Configuration.UI_MODE_NIGHT_NO) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else { // blah blah }

                }
                recreate();
            }
        });
        //QQ登陆
        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App app = (App) getApplication();
                UMShareAPI umShareAPI = app.getUmShareAPI();
                if (umShareAPI.isInstall(MainActivity.this, SHARE_MEDIA.QQ)) {

                    umShareAPI.getPlatformInfo(MainActivity.this, SHARE_MEDIA.QQ, new UMAuthListener() {
                        @Override
                        public void onStart(SHARE_MEDIA share_media) {

                        }

                        @Override
                        public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                            Toast.makeText(MainActivity.this, "success", Toast.LENGTH_LONG).show();

                            String photoUrl = map.get("iconurl");
                            ImageLoader.getInstance().displayImage(photoUrl, imagetouxiang);
                        }

                        @Override
                        public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                            Toast.makeText(MainActivity.this, "fils：", Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onCancel(SHARE_MEDIA share_media, int i) {
                            Toast.makeText(MainActivity.this, "取消登陆", Toast.LENGTH_LONG).show();
                        }

                    });
                } else {
                    Toast.makeText(MainActivity.this, "请安装QQ", Toast.LENGTH_LONG).show();
                }
            }
        });
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "请安装微博", Toast.LENGTH_SHORT).show();
            }
        });
        listView.addHeaderView(view);
        listView.addFooterView(view1);
        list = new ArrayList<bean>();
        for (int i = 0; i < img.length; i++) {
            bean = new bean();
            bean.setImg(img[i]);
            bean.setName(arr[i]);
            list.add(bean);
        }
        //设置适配器
        adapter = new MyMdapter(MainActivity.this, list);
        listView.setAdapter(adapter);
       //好友动态
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent intent=new Intent(MainActivity.this,Main8Activity.class);
                intent.putExtra("name",arr[position-1]);
                startActivity(intent);



            }
        });
    }
    private void PDguanli() {
        //按钮点击跳转到控制界面
        image_channel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (list1==null){//判断集合中是否已有数据，没有则创建
                    list1=new ArrayList<>();
                    //第一个是显示的条目，第二个参数是否显示
                    list1.add(new ChannelBean("推荐",false));
                    list1.add(new ChannelBean("热点",true));
                    list1.add(new ChannelBean("军事",true));
                    list1.add(new ChannelBean("八卦",false));
                    list1.add(new ChannelBean("游戏",false));
                    list1.add(new ChannelBean("宠物",false));
                    list1.add(new ChannelBean("汽车",false));
                    list1.add(new ChannelBean("热卖",false));
                    list1.add(new ChannelBean("体育",false));
                    list1.add(new ChannelBean("音乐",false));
                    list1.add(new ChannelBean("时尚",false));
                    list1.add(new ChannelBean("娱乐",false));



                    ChannelActivity.startChannelActivity(MainActivity.this,list1);




                }else if (jsonStr!=null){//当判断保存的字符串不为空的时候，直接加载已经有了的字符串
                    ChannelActivity.startChannelActivity(MainActivity.this,jsonStr);
                }

            }
        });
    }

    private void initView() {
        imagetouxiang = (ImageView) findViewById(R.id.imagetouxiang);
        tabLayout = (TabLayout) findViewById(R.id.TabLayout);
        listView = (ListView) findViewById(R.id.listView);
        image_channel = (ImageView) findViewById(R.id.image_channel);
        v = (ViewPager) findViewById(R.id.viewPager);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        imagetouxiang.setOnClickListener(this);
        //将fragment装进列表中
        fragment = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            fragment.add(new Fragment1());
        }
        tabLayout.setTabMode(View.SCREEN_STATE_OFF);
        //TabLayout关联ViewPager
        v.setAdapter(new MyFragmentAdapter(getSupportFragmentManager()));
        //让TabLayout发生关联
        tabLayout.setupWithViewPager(v);
        v.setOffscreenPageLimit(mTitles.length);
        //搜索控件
        butt_sousuo = (ImageView) findViewById(R.id.butt_sousuo);
        butt_sousuo.setOnClickListener(this);

        }

    class MyFragmentAdapter extends FragmentPagerAdapter {

        public MyFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
          return Fragment1.newInstance(mTitlesContent[position]);
//           return list_fragment.get(position);
        }

        @Override
        public int getCount() {
            return mTitles.length;
        }

        //重写该方法，显示标签字体 bug
        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //侧滑开关
            case R.id.imagetouxiang:
                if (drawerLayout.isDrawerOpen(listView)) {
                    drawerLayout.closeDrawer(listView);
                } else {
                    drawerLayout.openDrawer(listView);
                }
                break;
            //点击搜索界面
            case R.id.butt_sousuo:
                Intent intent = new Intent(MainActivity.this, Main7Activity.class);
                startActivity(intent);
                break;

        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
      //如果QQ分享或授权没有回调，没有显示图像，需要检查是否在进行分享操作的Activity中加入以下代码：
        UMShareAPI.get(this).onActivityResult(requestCode,resultCode,data);
        if (requestCode==ChannelActivity.REQUEST_CODE&&resultCode==ChannelActivity.RESULT_CODE) {
         jsonStr = data.getStringExtra(ChannelActivity.RESULT_JSON_KEY);
        } }
}
