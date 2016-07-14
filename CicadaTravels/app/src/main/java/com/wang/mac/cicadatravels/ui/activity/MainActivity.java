package com.wang.mac.cicadatravels.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.PopupWindow;

import com.wang.mac.cicadatravels.R;
import com.wang.mac.cicadatravels.ui.adapter.MainAdapter;
import com.wang.mac.cicadatravels.ui.fragment.StrategyFragment;
import com.wang.mac.cicadatravels.ui.fragment.ToolKitFragment;
import com.wang.mac.cicadatravels.ui.fragment.TravelsFragment;

import java.util.ArrayList;

public class MainActivity extends AbsBaseActivity implements View.OnClickListener {
    private TabLayout mainTabLayout;
    private ViewPager mainViewPager;
    private ArrayList<Fragment> data;
    private MainAdapter mainAdapter;
    private PopupWindow popupWindow;//下拉列表
    private Button searchBtn , loginAndRegisterBtn , assistBtn;


    @Override
    protected int setLayout() {
        //自定义标题
       // requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        return R.layout.activity_main;
        //设置标题为某个layout
      //  getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.title_bar);
    }

    @Override
    protected void innitView() {
        mainTabLayout=byView(R.id.main_tab_layout);
        mainViewPager=byView(R.id.main_view_pager);
        searchBtn = byView(R.id.title_search_btn);
        loginAndRegisterBtn = byView(R.id.title_login_and_register_btn);
        assistBtn = byView(R.id.title_assist_btn);

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
        //搜索的监听事件
        searchBtn.setOnClickListener(this);
        //登陆和注册的监听事件
        loginAndRegisterBtn.setOnClickListener(this);
        //辅助工具的监听事件
        assistBtn.setOnClickListener(this);











    }
    //加载fragment数据
    public void addFragment(){
        //初始化数据
        data = new ArrayList<>();
        data.add(new TravelsFragment());
        data.add(new StrategyFragment());
        data.add(new ToolKitFragment());
        mainAdapter.setData(data);
    }
    //设置popupWindow
    public void initPopup(){
        popupWindow = new PopupWindow(this);
        //设置宽高
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        //获取下拉列表布局
        View view = getLayoutInflater().inflate(R.layout.item_assist_popup,null);
        //把布局加载到popupWindow上
        popupWindow.setContentView(view);
        //点击外边可取消
        popupWindow.setOutsideTouchable(true);
        //设置焦点
        popupWindow.setFocusable(true);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_search_btn:
                break;
            case R.id.title_login_and_register_btn:
                break;
            case R.id.title_assist_btn:
                initPopup();
                //设置成下拉
                popupWindow.showAsDropDown(assistBtn);
                break;
        }
    }
}
