package com.wang.mac.cicadatravels.ui.activity;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

import com.wang.mac.cicadatravels.R;
import com.wang.mac.cicadatravels.ui.adapter.SearchAdapter;
import com.wang.mac.cicadatravels.ui.fragment.ForeignFragment;
import com.wang.mac.cicadatravels.ui.fragment.InlandFragment;
import com.wang.mac.cicadatravels.ui.fragment.SeasonsFragment;

import java.util.ArrayList;

/**
 * Created by mac on 16/7/16.
 * 点击搜索进入的界面
 */
public class SearchActivity extends AbsBaseActivity implements View.OnClickListener {
    private ArrayList<Fragment> data;
    private TabLayout searchTabLayout;
    private ViewPager searchViewPager;
    private SearchAdapter searchAdapter;
    private LinearLayout searchReturnLin;//搜索界面的返回建
    @Override
    protected int setLayout() {
        return R.layout.activity_search;
    }

    @Override
    protected void innitView() {
        searchTabLayout = byView(R.id.search_tab_layout);
        searchViewPager = byView(R.id.search_view_pager);
        searchReturnLin = byView(R.id.search_return);
    }

    @Override
    protected void initData() {
        //初始化适配器
        searchAdapter = new SearchAdapter(getSupportFragmentManager());
        addSearchData();
        searchViewPager.setAdapter(searchAdapter);
        //viewPager与tabLayout联动
        searchTabLayout.setupWithViewPager(searchViewPager);
        //给tabLayout加颜色
        searchTabLayout.setSelectedTabIndicatorColor(Color.argb(255,7,157,228));
        searchTabLayout.setTabTextColors(Color.BLACK,Color.argb(255,7,157,228));
        searchReturnLin.setOnClickListener(this);

    }
    //获取搜索界面的各个fragment的数据
    private void addSearchData() {
        data = new ArrayList<>();
        data.add(new ForeignFragment());
        data.add(new InlandFragment());
        data.add(new SeasonsFragment());
        searchAdapter.setData(data);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.search_return:
                goTo(SearchActivity.this,MainActivity.class);
        }
    }
}
