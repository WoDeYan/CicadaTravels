package com.wang.mac.cicadatravels.ui.activity;

import android.view.View;
import android.widget.LinearLayout;

import com.wang.mac.cicadatravels.R;

/**
 * Created by mac on 16/7/16.
 * 离线浏览界面
 * @author wangweijian
 */
public class OffLineActivity extends AbsBaseActivity implements View.OnClickListener {
    private LinearLayout offLineReturnLin;//离线浏览返回键
    @Override
    protected int setLayout() {
        return R.layout.activity_line_off;
    }

    @Override
    protected void innitView() {
    offLineReturnLin = byView(R.id.off_line_return);
    }

    @Override
    protected void initData() {
     offLineReturnLin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.off_line_return:
                goTo(OffLineActivity.this,MainActivity.class);
                break;
        }
    }
}
