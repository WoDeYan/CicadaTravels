package com.wang.mac.cicadatravels.tools;

import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by mac on 16/7/14.
 * UniversalImageLoader加载图片工具类
 */
public class MyUniversalImageLoaderManager {
   static DisplayImageOptions options = new DisplayImageOptions.Builder().cacheOnDisk(true).cacheInMemory(true).build();


    public static void loadImg(String url , ImageView iv){

        ImageLoader.getInstance().displayImage(url,iv,options);
    }


}
