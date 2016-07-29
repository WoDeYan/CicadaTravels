package com.wang.mac.cicadatravels.ui.activity;

import android.view.View;
import android.widget.LinearLayout;

import com.wang.mac.cicadatravels.R;

/**
 * Created by mac on 16/7/16.
 * 设置界面
 * @author wangweijian
 */
public class SettingActivity extends AbsBaseActivity implements View.OnClickListener {
    private LinearLayout settingReturnLin;//设置返回键
    @Override
    protected int setLayout() {
        return R.layout.actiivty_setting;
    }

    @Override
    protected void innitView() {
    settingReturnLin = byView(R.id.setting_return);
    }

    @Override
    protected void initData() {
    settingReturnLin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.setting_return:
                goTo(SettingActivity.this,MainActivity.class);
                break;
        }
    }
}
