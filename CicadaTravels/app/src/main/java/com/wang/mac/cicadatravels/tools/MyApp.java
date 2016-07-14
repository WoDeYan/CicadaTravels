package com.wang.mac.cicadatravels.tools;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by mac on 16/7/11.
 */
public class MyApp extends Application{

    private static Context context;


    @Override
    public void onCreate() {
        super.onCreate();
        //onCreate初始化
        context = getApplicationContext();
        //配置UniversalImageLoader的设置选项
        //1.使用默认选项
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(context);
        //将内容设置给ImageLoader
        ImageLoader.getInstance().init(configuration);

    }
    //对外提供get方法

    public static Context getContext(){
        return context;
    }



}
