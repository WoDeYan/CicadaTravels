package com.wang.mac.cicadatravels.tools;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by mac on 16/7/14.
 * UniversalImageLoader加载图片工具类
 */
public class MyUniversalImageLoaderManager {
    static BitmapFactory.Options optionss = new BitmapFactory.Options();
    {
        optionss.inJustDecodeBounds = true;
        optionss.inSampleSize = 8;
        optionss.inJustDecodeBounds = false;
    }
   static DisplayImageOptions options = new DisplayImageOptions.Builder()
           .cacheOnDisk(true)
           .cacheInMemory(true)
           .bitmapConfig(Bitmap.Config.ARGB_4444)
           .decodingOptions(optionss)
           .build();


    public static void loadImg(String url , ImageView iv){

//        ImageLoader.getInstance().displayImage(url,iv,options);
        ImageLoader.getInstance().displayImage(url,iv);
    }


}
