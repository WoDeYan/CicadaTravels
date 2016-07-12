package com.wang.mac.cicadatravels.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by mac on 16/7/11.
 * 抽象的Activity基类
 * 在此类中规定了整个应用的业务流程及界面效果
 */
public abstract class AbsBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在setContentView上方去掉信息栏
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //加入一些进入退出的动画
        //overridePendingTransition();

        //绑定布局
        setContentView(setLayout());
        //定制流程
        //1.初始化组件
        innitView();
        //2.初始化数据
        initData();



    }

    /**
     * 设置xml布局文件
     * (protected修饰:被子类和同包可访问)
     * (返回值是int:因为xml文件中R.layout是int类型)
     * @return layout布局文件  eg.R.layout.activity_main
     */
     protected abstract int setLayout();
    /**
     * 初始化组件
     */
    protected abstract void innitView();
    /**
     * 初始化数据
     */
    protected abstract void initData();
    /**
     * 简化findViewById
     * T泛型:泛指一系列类型 T指的是View子类
     */
    protected <T extends View>T byView(int resId){
            T t = (T) findViewById(resId);
            return t;
    }
    /**
     * 简化intent跳转
     * from intent里的xx.this
     * to   intent里的xx.class
     *      这里限制的条件是:要是我们写的基类的子类
     */
    protected void goTo(Context from , Class<? extends AbsBaseActivity> to){
        Intent intent = new Intent(from,to);
        startActivity(intent);
    }
    /**
     * 隐式intent
     */
    protected void goTo(String action,String uri){
        Intent intent = new Intent(action);
        intent.setData(Uri.parse(uri));
        startActivity(intent);
    }

    /**
     * 带值的跳转
     * @param from
     * @param to
     * @param values  Bundle类型的值
     *                Bundle是一个轻量级存储数据的类,存储形式key-value
     */
    protected void goTo(Context from , Class<? extends AbsBaseActivity> to,Bundle values){
        Intent intent = new Intent(from,to);
        intent.putExtras(values);
        startActivity(intent);
    }





}
