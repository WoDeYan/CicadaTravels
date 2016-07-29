package com.wang.mac.cicadatravels.tools;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

/**
 * Created by mac on 16/7/11.
 */
public class CicadaTravelsApp extends Application{

    private static Context context;
    private static SharedPreferences sp;

    @Override
    public void onCreate() {
        super.onCreate();
        //onCreate初始化
        context = getApplicationContext();
        sp = context.getSharedPreferences("MyDemo",MODE_PRIVATE);
        //配置UniversalImageLoader的设置选项
//        //1.使用默认选项
//        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(context);
        File cacheDir = StorageUtils.getOwnCacheDirectory(getApplicationContext(), "BAT/Cache");
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
                // dp -> px dp
                // 单位转换
                .memoryCacheExtraOptions(320, 480) // max width, max height，即保存的每个缓存文件的最大长宽
                .threadPoolSize(3) //线程池内线程的数量
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator()) //将保存的时候的URI名称用MD5 加密
                .memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 * 1024))
                .memoryCacheSize(2 * 1024 * 1024) // 内存缓存的最大值
                .diskCacheSize(50 * 1024 * 1024)  // SD卡缓存的最大值
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                // 由原先的discCache -> diskCache
                .diskCache(new UnlimitedDiskCache(cacheDir))//自定义缓存路径
                .imageDownloader(new BaseImageDownloader(getApplicationContext(), 5 * 1000, 30 * 1000)) // connectTimeout (5 s), readTimeout (30 s)超时时间
                .writeDebugLogs() // Remove for release app
                .build();
        //将内容设置给ImageLoader
        ImageLoader.getInstance().init(config);

    }
    //对外提供get方法

    public static Context getContext(){
        return context;
    }



}
