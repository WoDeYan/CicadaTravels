package com.wang.mac.cicadatravels.ui.activity;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.wang.mac.cicadatravels.R;
import com.wang.mac.cicadatravels.ui.adapter.MainAdapter;
import com.wang.mac.cicadatravels.ui.fragment.SeasonsFragment;
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
    private ImageView searchIv , loginAndRegisterIv , assistIv;//搜索,登录与注册,菜单栏
    private TextView offLineTv,feedbackTv,settingTv;//离线浏览,反馈,设置

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
        searchIv = byView(R.id.main_title_bar_search);
        loginAndRegisterIv = byView(R.id.main_title_bar_person);
        assistIv = byView(R.id.main_title_bar_menu);


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
        searchIv.setOnClickListener(this);
        //登陆和注册的监听事件
        loginAndRegisterIv.setOnClickListener(this);
        //辅助工具的监听事件
        assistIv.setOnClickListener(this);
        //给tabLayout加颜色
        mainTabLayout.setSelectedTabIndicatorColor(Color.argb(255,7,157,228));
        mainTabLayout.setTabTextColors(Color.BLACK,Color.argb(255,7,157,228));
    }
    //加载fragment数据
    public void addFragment(){
        //初始化数据
        data = new ArrayList<>();
        data.add(new TravelsFragment());

        data.add(StrategyFragment.getInstance());
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
        offLineTv = (TextView) view.findViewById(R.id.assist_off_line_tv);
        feedbackTv = (TextView) view.findViewById(R.id.assist_feedback_tv);
        settingTv = (TextView) view.findViewById(R.id.assist_setting_tv);
        offLineTv.setOnClickListener(this);
        feedbackTv.setOnClickListener(this);
        settingTv.setOnClickListener(this);
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
            case R.id.main_title_bar_search:
                goTo(MainActivity.this,SearchActivity.class);
                break;
            case R.id.main_title_bar_person:
                goTo(MainActivity.this,LoginAndRegisterActivity.class);
                break;
            case R.id.main_title_bar_menu:
                initPopup();
                //设置成下拉
                popupWindow.showAsDropDown(assistIv);
                break;
            case R.id.assist_off_line_tv:
                goTo(MainActivity.this,OffLineActivity.class);
                break;
            case R.id.assist_feedback_tv:
                goTo(MainActivity.this,FeedbackActivity.class);
                break;
            case R.id.assist_setting_tv:
                goTo(MainActivity.this,SettingActivity.class);
                break;

        }
    }
}
