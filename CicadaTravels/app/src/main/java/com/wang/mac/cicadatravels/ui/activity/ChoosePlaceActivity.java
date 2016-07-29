package com.wang.mac.cicadatravels.ui.activity;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.wang.mac.cicadatravels.R;
import com.wang.mac.cicadatravels.ui.adapter.ChoosePlaceAdapter;
import com.wang.mac.cicadatravels.ui.fragment.ChooseForeignFragment;
import com.wang.mac.cicadatravels.ui.fragment.ChooseInlandFragment;

import java.util.ArrayList;


/**
 * Created by mac on 16/7/19.
 */
public class ChoosePlaceActivity extends AbsBaseActivity implements View.OnClickListener {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ChoosePlaceAdapter choosePlaceAdapter;
    private ArrayList<Fragment> data;
    private LinearLayout choosePlaceReturnLin;
    @Override
    protected int setLayout() {
        return R.layout.activity_place_choose;
    }

    @Override
    protected void innitView() {
        tabLayout = byView(R.id.choose_place_tab_layout);
        viewPager = byView(R.id.choose_place_view_pager);
        choosePlaceReturnLin = byView(R.id.choose_place_return);
    }

    @Override
    protected void initData() {
       //加载fragment上数据
        addFragments();
        //加载完毕 绑定适配器
        viewPager.setAdapter(choosePlaceAdapter);
        //联动
        tabLayout.setupWithViewPager(viewPager);
        //设置颜色
        tabLayout.setSelectedTabIndicatorColor(Color.argb(255,7,157,228));
        tabLayout.setTabTextColors(Color.BLACK,Color.argb(255,7,157,228));
        //返回键
        choosePlaceReturnLin.setOnClickListener(this);
    }

    private void addFragments() {
        data = new ArrayList<>();
        data.add(new ChooseForeignFragment());
        data.add(new ChooseInlandFragment());
        choosePlaceAdapter = new ChoosePlaceAdapter(getSupportFragmentManager());
        choosePlaceAdapter.setData(data);

    }

    @Override
    public void onClick(View v) {
           finish();
    }
}
