package com.example.lenovo.jinritoutiao.utis;

import android.app.Application;

import com.example.lenovo.jinritoutiao.R;
import com.mob.MobSDK;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import org.xutils.x;

/**
 * Created by Lenovo on 2017/9/1.
 */

public class App extends Application{
    private static boolean f;
    private UMShareAPI umShareAPI;
    private boolean commit;

    {
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
    }
    @Override
    public void onCreate() {
        super.onCreate();

        x.Ext.init(this);
        x.Ext.setDebug(true);
        MobSDK.init(this, "1ff436dce2b00", "a95fd735f3142840ee845599b9f3d572");
        umShareAPI = UMShareAPI.get(this);
       // Config.DEBUG = true;

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .threadPoolSize(3)
                .threadPriority(100)
                .memoryCacheExtraOptions(480,800)
                .memoryCacheSize(2 * 1024 * 1024)
                .diskCacheSize(50 * 1024 * 1024)

                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .build();

        ImageLoader.getInstance().init(config);
    }

    public UMShareAPI getUmShareAPI() {
        return umShareAPI;
    }
    public static DisplayImageOptions getImageOptions(){


        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .showImageForEmptyUri(R.mipmap.ic_empty)
                .showImageOnFail(R.mipmap.ic_error)
                .showImageOnLoading(R.mipmap.loading)
                .build();

        return options;
    }
    public static String getflag(boolean ff){
           f = ff;
        return null;
    }
}
