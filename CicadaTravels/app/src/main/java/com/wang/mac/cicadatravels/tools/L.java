package com.wang.mac.cicadatravels.tools;

import android.util.Log;

/**
 * Created by mac on 16/7/11.
 */
public final class L {

    //被final修饰不能被继承
    //私有构造方法,外部不能创建对象
    //私有构造方法
    private L(){}

    //调试模式 目前定义为true
    private static boolean isDebug = true;
    //log日志的标签,定义的是应用名
    private static String TAG = "CicadaTravels";


    /**
     * 使用默认TAG标签
     * @param msg
     */

    public static void e(String msg){
        if (isDebug){
            Log.e(TAG,msg);
        }
    }
    public static void d(String msg){
        if (isDebug){
            Log.e(TAG,msg);
        }
    }
    public static void i(String msg){
        if (isDebug){
            Log.e(TAG,msg);
        }
    }
    public static void v(String msg){
        if (isDebug){
            Log.e(TAG,msg);
        }
    }
    public static void w(String msg){
        if (isDebug){
            Log.e(TAG,msg);
        }
    }
    /**
     * 使用自定义TAG标签
     * @param tag
     * @param msg
     */

    public static void e(String tag , String msg){
        if (isDebug){
            Log.e(tag,msg);
        }
    }
    public static void d(String tag , String msg){
        if (isDebug){
            Log.e(tag,msg);
        }
    }
    public static void i(String tag , String msg){
        if (isDebug){
            Log.e(tag,msg);
        }
    }
    public static void v(String tag , String msg){
        if (isDebug){
            Log.e(tag,msg);
        }
    }
    public static void w(String tag , String msg){
        if (isDebug){
            Log.e(tag,msg);
        }
    }
















}
