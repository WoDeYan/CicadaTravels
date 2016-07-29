package com.wang.mac.cicadatravels.ui.activity;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

import com.wang.mac.cicadatravels.R;
import com.wang.mac.cicadatravels.ui.adapter.LoginAndRegisterAdapter;
import com.wang.mac.cicadatravels.ui.fragment.LoginFragment;
import com.wang.mac.cicadatravels.ui.fragment.RegisterFragment;

import java.util.ArrayList;

/**
 * Created by mac on 16/7/16.
 * 登陆与注册界面的主界面
 * @author wangweijian
 */
public class LoginAndRegisterActivity extends AbsBaseActivity implements View.OnClickListener {
    private ArrayList<Fragment> data;
    private ViewPager lARViewPager;
    private TabLayout lARTabLayout;
    private LoginAndRegisterAdapter lARAdapter;
    private LinearLayout lARReturnLin;//登陆与注册界面的返回键
    @Override
    protected int setLayout() {
        return R.layout.activity_register_and_login;
    }

    @Override
    protected void innitView() {
        lARTabLayout = byView(R.id.login_and_register_tab_layout);
        lARViewPager = byView(R.id.login_and_register_view_pager);
        lARReturnLin = byView(R.id.login_and_register_return);
    }

    @Override
    protected void initData() {
        lARAdapter = new LoginAndRegisterAdapter(getSupportFragmentManager());
        addLARData();
        //viewPager绑定适配器
        lARViewPager.setAdapter(lARAdapter);
        //TabLayout与ViewPager联动
        lARTabLayout.setupWithViewPager(lARViewPager);
        //设置tabLayout的颜色
        lARTabLayout.setSelectedTabIndicatorColor(Color.argb(255,7,157,228));
        lARTabLayout.setTabTextColors(Color.BLACK,Color.argb(255,7,157,228));
        lARReturnLin.setOnClickListener(this);
    }
    //加入登陆与注册的fragment的数据
    private void addLARData() {
        data = new ArrayList<>();
        data.add(new LoginFragment());
        data.add(new RegisterFragment());
        lARAdapter.setData(data);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login_and_register_return:
                goTo(LoginAndRegisterActivity.this,MainActivity.class);
                break;
        }
    }
}
