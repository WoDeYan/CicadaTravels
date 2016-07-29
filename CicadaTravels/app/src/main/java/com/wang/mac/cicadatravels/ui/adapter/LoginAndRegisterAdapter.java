package com.wang.mac.cicadatravels.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by mac on 16/7/16.
 * 登陆与注册的适配器
 * @author wangweijian
 */
public class LoginAndRegisterAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> data;
    private String titles[] = {"登陆","注册"};

    public void setData(ArrayList<Fragment> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public LoginAndRegisterAdapter(FragmentManager fm) {
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
