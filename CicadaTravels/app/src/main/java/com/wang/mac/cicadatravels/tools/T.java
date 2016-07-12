package com.wang.mac.cicadatravels.tools;

import android.widget.Toast;

import com.wang.mac.cicadatravels.ui.activity.MyApp;

/**
 * Created by mac on 16/7/11.
 */
public final class T {

    private T(){}
    private static boolean isDebug = true;

    /**
     * 吐司时间长的
     * @param msg
     */

    public static void longMsg(String msg){
        if (isDebug){
            Toast.makeText(MyApp.getContext(), msg, Toast.LENGTH_LONG).show();
        }
    }
    public static void shortMsg(String msg){
        if (isDebug){
            Toast.makeText(MyApp.getContext(), msg, Toast.LENGTH_SHORT).show();
        }
    }



}
