package com.wang.mac.cicadatravels.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wang.mac.cicadatravels.R;
import com.wang.mac.cicadatravels.ui.adapter.MainAdapter;
import com.wang.mac.cicadatravels.ui.fragment.StrategyFragment;
import com.wang.mac.cicadatravels.ui.fragment.ToolKitFragment;
import com.wang.mac.cicadatravels.ui.fragment.TravelsFragment;

import java.util.ArrayList;

public class MainActivity extends AbsBaseActivity {
    private TabLayout mainTabLayout;
    private ViewPager mainViewPager;
    private ArrayList<Fragment> data;
    private MainAdapter mainAdapter;


    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void innitView() {
        mainTabLayout=byView(R.id.myTabLayout);
        mainViewPager=byView(R.id.myViewPager);

    }

    @Override
    protected void initData() {
        //初始化adapter
        mainAdapter = new MainAdapter(getSupportFragmentManager());
        //加入数据
        addFragment();
        //ViewPager绑定适配器
        mainViewPager.setAdapter(mainAdapter);
        //ViewPager与TabLayout联动
        mainTabLayout.setupWithViewPager(mainViewPager);











    }
    public void addFragment(){
        //初始化数据
        data = new ArrayList<>();
        data.add(new StrategyFragment());
        data.add(new ToolKitFragment());
        data.add(new TravelsFragment());
        mainAdapter.setData(data);
    }
}
