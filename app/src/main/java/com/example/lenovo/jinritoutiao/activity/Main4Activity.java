package com.example.lenovo.jinritoutiao.activity;


import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.city_picker.CityListActivity;
import com.example.lenovo.jinritoutiao.R;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

import java.io.File;
import java.math.BigDecimal;

import androidkun.com.versionupdatelibrary.entity.VersionUpdateConfig;


public class Main4Activity extends BaseActivity implements View.OnClickListener {

    private ImageView img_return;

    private TextView zitikongzhi;
    private TextView nwifi;
    private AlertDialog alertDialog;
    private AlertDialog alertDialog1;
    private TextView wifitongzhi;
    private TextView ziti;
    private TextView huaKB;
    private File filesDir;
    private LinearLayout bianjiziliao;
    private LinearLayout bangdingshezhi;
    private LinearLayout heimingdan;
    private LinearLayout toutiaoshangcheng;
    private LinearLayout liebiaoxianshi;
    private Switch tuisongkaiguan;
    private TextView ly_genxin;
    private TextView banbenhao;
    String TAG = "MainActivity";
    int REQUEST_CODE = 1;
    private LinearLayout tuisong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity4shezhi);
        //获取摄像头权限
        getCameraPermission();
        //ZXingLibrary初始化
        ZXingLibrary.initDisplayOpinion(this);
        initView();
        img_return.setOnClickListener(this);

        nwifi.setOnClickListener(this);
        zitikongzhi.setOnClickListener(this);
        huaKB = (TextView) findViewById(R.id.huaKB);
        //计算当前缓存
        try {
            String size = getTotalCacheSize();
            huaKB.setText("当前缓存 " + size);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void initView() {
        img_return = (ImageView) findViewById(R.id.img_return);


        zitikongzhi = (TextView) findViewById(R.id.zitikongzhi);


        nwifi = (TextView) findViewById(R.id.nwifi);
        // tuisong = (TextView) findViewById(R.id.tuisong);
        wifitongzhi = (TextView) findViewById(R.id.wifitongzhi);

        ziti = (TextView) findViewById(R.id.ziti);


        bianjiziliao = (LinearLayout) findViewById(R.id.bianjiziliao);
        bianjiziliao.setOnClickListener(this);
        bangdingshezhi = (LinearLayout) findViewById(R.id.bangdingshezhi);
        bangdingshezhi.setOnClickListener(this);
        heimingdan = (LinearLayout) findViewById(R.id.heimingdan);
        heimingdan.setOnClickListener(this);
        toutiaoshangcheng = (LinearLayout) findViewById(R.id.toutiaoshangcheng);
        toutiaoshangcheng.setOnClickListener(this);
        liebiaoxianshi = (LinearLayout) findViewById(R.id.liebiaoxianshi);
        liebiaoxianshi.setOnClickListener(this);
        tuisongkaiguan = (Switch) findViewById(R.id.tuisongkaiguan);
        tuisongkaiguan.setOnClickListener(this);
        ly_genxin = (TextView) findViewById(R.id.ly_genxin);
        ly_genxin.setOnClickListener(this);

        tuisong = (LinearLayout) findViewById(R.id.tuisong);
        tuisong.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ly_genxin:
                AlertDialog.Builder builder = new AlertDialog.Builder(Main4Activity.this);
                builder.setMessage("发现新版本，是否更新");
                builder.setNegativeButton("取消更新", null);
                builder.setPositiveButton("马上更新", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        VersionUpdateConfig.getInstance()//获取配置实例
                                .setContext(Main4Activity.this)//设置上下文
                                .setDownLoadURL("http://gdown.baidu.com/data/wisegame/65f486476dcc3567/jinritoutiao_634.apk")//设置文件下载链接

                                .setNotificationIconRes(R.mipmap.ic_launcher)//设置通知图标
                                .setNotificationSmallIconRes(R.mipmap.ic_launcher)//设置通知小图标
                                .setNotificationTitle("版本升级Demo")//设置通知标题
                                .startDownLoad();//开始下载
                    }
                });
                builder.create().show();


                break;
            case R.id.img_return:

                finish();
                break;
            //城市列表
            case R.id.heimingdan:
                CityListActivity.startCityActivityForResult(this);
                break;
            case R.id.tuisong:
                //推送
                   gettuisong();
                break;

            case R.id.zitikongzhi:
                //设置字体大小
                getzitidaxiao();
                break;
            case R.id.nwifi:
                //设置网络流量
                getwifi();
                break;
            //扫一扫
            case R.id.bianjiziliao:
                Intent intent = new Intent(Main4Activity.this, CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
                break;
            //生成二维码
            case R.id.bangdingshezhi:
                Intent intener = new Intent(Main4Activity.this, Mainsaoyisao.class);
                startActivity(intener);
                break;
            case R.id.toutiaoshangcheng:
                Intent intenerr = new Intent(Main4Activity.this, Main9Activity.class);
                startActivity(intenerr);
                break;
        }
    }

    public void qingchuhuanchu(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Main4Activity.this);
        builder.setMessage("是否清除");
        builder.setNegativeButton("取消", null);
        builder.setPositiveButton("清除", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                clearAllCache(Main4Activity.this);
                String size = null;
                try {
                    size = getTotalCacheSize();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                huaKB.setText("当前缓存:" + size);

            }
        });
        builder.create().show();
    }


    private void getwifi() {

        final String[] titlle = new String[]{"最佳效果（下载大图）", "较省流量（智能下图）", "极省流量（不下载图）"};

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("非WIFI网络流量")
                .setSingleChoiceItems(titlle, 0, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        wifitongzhi.setText(titlle[which]);
                        if (which == 0) {
                            getSharedPreferences("WIFI1", MODE_PRIVATE).edit().putInt("WIFI", 0).commit();

                            dialog.dismiss();
                        } else if (which == 1) {
                            dialog.dismiss();
                            getSharedPreferences("WIFI1", MODE_PRIVATE).edit().putInt("WIFI", 1).commit();
                        }
                        if (which == 2) {
                            dialog.dismiss();
                            getSharedPreferences("WIFI1", MODE_PRIVATE).edit().putInt("WIFI", 3).commit();

                        }

                    }
                });

        builder.setPositiveButton("取消", null);

        alertDialog = builder.create();
        alertDialog.setCanceledOnTouchOutside(true);
        alertDialog.show();

    }

    private void getzitidaxiao() {

         // 创建数据
        final String[] titlle2 = new String[]{"小", "中", "大", "特大"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("字体大小")
                .setSingleChoiceItems(titlle2, 0, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub

                        if (which == 0) {
                            ziti.setText(titlle2[which]);
                            alertDialog1.dismiss();

                            getSharedPreferences("ALER", MODE_PRIVATE).edit().putInt("font", 0).commit();
                            alertDialog1.dismiss();
                        } else if (which == 1) {
                            ziti.setText(titlle2[which]);
                            getSharedPreferences("ALER", MODE_PRIVATE).edit().putInt("font", 1).commit();
                            alertDialog1.dismiss();
                        } else if (which == 2) {
                            ziti.setText(titlle2[which]);
                            getSharedPreferences("ALER", MODE_PRIVATE).edit().putInt("font", 2).commit();
                            alertDialog1.dismiss();
                        }
                        if (which == 3) {
                            ziti.setText(titlle2[which]);
                            getSharedPreferences("ALER", MODE_PRIVATE).edit().putInt("font", 3).commit();
                            alertDialog1.dismiss();
                        }

                    }

                });

        builder.setPositiveButton("取消", null);

        alertDialog1 = builder.create();
        alertDialog1.setCanceledOnTouchOutside(true);
        alertDialog1.show();
    }

    /**
     * 计算app的缓存大小其实计算的是 getCacheDir()这个file和getExternalCacheDir()这个file大小的和
     */
    public String getTotalCacheSize() throws Exception {
        long cacheSize = getFolderSize(this.getCacheDir());
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            cacheSize += getFolderSize(this.getExternalCacheDir());
        }
        return getFormatSize(cacheSize);
    }
    /**
     * 计算文件夹的大小
     */
    public static long getFolderSize(File file) throws Exception {
        long size = 0;
        try {
            File[] fileList = file.listFiles();
            for (int i = 0; i < fileList.length; i++) {
                // 如果下面还有文件
                if (fileList[i].isDirectory()) {
                    size = size + getFolderSize(fileList[i]);
                } else {
                    size = size + fileList[i].length();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return size;
    }
    /**
     * 清理app的缓存 其实是清除的getCacheDir 和getExternalCacheDir这两个文件
     *
     * @param context
     */
    public static void clearAllCache(Context context) {
        deleteDir(context.getCacheDir());
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            deleteDir(context.getExternalCacheDir());
        }
    }

    /**
     * 格式化得到的总大小 默认是byte,  然后根据传入的大小,自动转化成合适的大小单位
     *
     * @param size
     * @return
     */
    public static String getFormatSize(double size) {
        double kiloByte = size / 1024;
        if (kiloByte < 1) {
//            return size + "Byte";
            return "0K";
        }

        double megaByte = kiloByte / 1024;
        if (megaByte < 1) {
            BigDecimal result1 = new BigDecimal(Double.toString(kiloByte));
            return result1.setScale(2, BigDecimal.ROUND_HALF_UP)
                    .toPlainString() + "KB";
        }

        double gigaByte = megaByte / 1024;
        if (gigaByte < 1) {
            BigDecimal result2 = new BigDecimal(Double.toString(megaByte));
            return result2.setScale(2, BigDecimal.ROUND_HALF_UP)
                    .toPlainString() + "MB";
        }

        double teraBytes = gigaByte / 1024;
        if (teraBytes < 1) {
            BigDecimal result3 = new BigDecimal(Double.toString(gigaByte));
            return result3.setScale(2, BigDecimal.ROUND_HALF_UP)
                    .toPlainString() + "GB";
        }
        BigDecimal result4 = new BigDecimal(teraBytes);
        return result4.setScale(2, BigDecimal.ROUND_HALF_UP).toPlainString()
                + "TB";
    }

    /**
     * 删除一个文件夹
     *
     * @param dir
     * @return
     */
    private static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(this, "解析结果:" + result, Toast.LENGTH_LONG).show();
                    //  Log.e(TAG,"解析结果:" + result);
                    // textView.setText(result);//解析结果显示在TextView
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(Main4Activity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    public void getCameraPermission() {
        if (Build.VERSION.SDK_INT > 22) {
            if (ContextCompat.checkSelfPermission(Main4Activity.this,
                    Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                //先判断有没有权限 ，没有就在这里进行权限的申请
                ActivityCompat.requestPermissions(Main4Activity.this,
                        new String[]{Manifest.permission.CAMERA}, 2);
            } else {
                //说明已经获取到摄像头权限了 想干嘛干嘛
            }
        } else {
            //这个说明系统版本在6.0之下，不需要动态获取权限。
        }
    }

    public void gettuisong() {


    }

}