package com.wang.mac.cicadatravels.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by mac on 16/7/16.
 * 搜索界面的适配器
 * @author wangweijian
 */
public class SearchAdapter extends FragmentPagerAdapter{
    private ArrayList<Fragment> data;
    private String titles[] = {"国外","国内","四季"};

    public void setData(ArrayList<Fragment> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public SearchAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return data!=null&&data.size()>0?data.get(position):null;
    }

    @Override
    public int getCount() {
        return data!=null&&data.size()>0?data.size():0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
