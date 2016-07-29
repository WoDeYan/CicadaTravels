package com.wang.mac.cicadatravels.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.wang.mac.cicadatravels.R;
import com.wang.mac.cicadatravels.model.bean.AvatarTravelsBean;
import com.wang.mac.cicadatravels.model.net.ImgUrls;
import com.wang.mac.cicadatravels.model.net.VolleyInstance;
import com.wang.mac.cicadatravels.model.net.VolleyResult;
import com.wang.mac.cicadatravels.tools.MyUniversalImageLoaderManager;
import com.wang.mac.cicadatravels.ui.adapter.AvatarAdapter;
import com.wang.mac.cicadatravels.ui.fragment.AvatarLoveFragment;
import com.wang.mac.cicadatravels.ui.fragment.AvatarTravelsFragment;

import java.util.ArrayList;

/**
 * Created by mac on 16/7/27.
 */
public class TravelsAvatarActivity extends AbsBaseActivity implements View.OnClickListener {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<Fragment> data;
    private AvatarAdapter adapter;
    private int ids;
    private AvatarTravelsFragment avatarTravelsFragment;
    private ImageView avatarIv;
    private TextView avatarNameTv, avatarTravelsCountTv;
    private AvatarLoveFragment avatarLoveFragment;
    private LinearLayout avatarReturnLin;

    @Override
    protected int setLayout() {
        return R.layout.activity_avatar_travels;
    }

    @Override
    protected void innitView() {
        tabLayout = byView(R.id.avatar_tab_layout);
        viewPager = byView(R.id.avatar_view_pager);
        avatarIv = byView(R.id.avatar_iv);
        avatarNameTv = byView(R.id.avatar_name_tv);
        avatarTravelsCountTv = byView(R.id.avatar_travels_count_tv);
        avatarReturnLin = byView(R.id.avatar_return_lin);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        //获取游记第一几个界面传来的id
        ids = intent.getIntExtra("ids", 0);
        avatarTravelsFragment = new AvatarTravelsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("ids", ids);
        avatarTravelsFragment.setArguments(bundle);

        avatarLoveFragment = new AvatarLoveFragment();
        avatarLoveFragment.setArguments(bundle);
        //加载Fragment数据
        addAvatarFragments();
        viewPager.setAdapter(adapter);
        //联动
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorColor(Color.argb(255, 7, 157, 228));
        tabLayout.setTabTextColors(Color.BLACK, Color.argb(255, 7, 157, 228));
        //加载布局中头部的数据
        addHeadData();
        avatarReturnLin.setOnClickListener(this);
    }

    private void addHeadData() {
        VolleyInstance.getInstance(this).startRequest(ImgUrls.TRAVELS_AVATAR_DETAILS_HEAD_URL + ids + ImgUrls.TRAVELS_AVATAR_DETAILS_TAIL_URL, new VolleyResult() {
            @Override
            public void success(String str) {
                Gson gson = new Gson();
                AvatarTravelsBean avatarTravelsBean = gson.fromJson(str, AvatarTravelsBean.class);
                String name = avatarTravelsBean.getName();
                String image = avatarTravelsBean.getImage();
                int count = avatarTravelsBean.getTrips_count();
                MyUniversalImageLoaderManager.loadImg(image, avatarIv);
                avatarNameTv.setText(name);
                avatarTravelsCountTv.setText(count + "篇游记");
            }

            @Override
            public void failure() {

            }
        });
    }

    private void addAvatarFragments() {
        data = new ArrayList<>();
        adapter = new AvatarAdapter(getSupportFragmentManager());
        data.add(avatarTravelsFragment);
        data.add(avatarLoveFragment);
        adapter.setData(data);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.avatar_return_lin:
                finish();
                break;
        }
    }
}
