package com.wang.mac.cicadatravels.tools;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by mac on 16/7/12.
 * 封装Volley的单例类->提供Volley框架的一些使用方法
 * 将请求队列单例,只存在一个请求队列
 */
public class VolleyInstance {

    //定义一个请求队列
    private RequestQueue queue;

    //定义一个当前类的静态对象
    private static VolleyInstance instance;

    //私有化构造方法
    private VolleyInstance(Context context){
        queue = Volley.newRequestQueue(context);
    }

    //对外提供获得对象的方法
    public static VolleyInstance getInstance(Context context){
        if (instance==null){
            synchronized (VolleyInstance.class){
                if (instance==null){
                    instance=new VolleyInstance(context);
                }
            }
        }
        return instance;
    }
    //上方是单例请求队列
    /****************************************************/
    //下方是提供Volley的使用方法

    //1.StringRequest请求简单易懂的方式

    public void startRequest(String url , Response.Listener<String> listener,Response.ErrorListener errorListener) {
        //开始请求
        StringRequest sr = new StringRequest(url,listener,errorListener);
        //加入队列
        queue.add(sr);
    }
    //2.利用接口,将成功和失败封装起来
    //将请求接口利用接口回调响应到调用端


    public void startRequest(String url , final VolleyResult result){
        StringRequest sr = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
               //触发成功接口的方法,将值传递出去
                result.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //触发失败接口方法
                result.failure();
            }
        });
        queue.add(sr);
    }


}
