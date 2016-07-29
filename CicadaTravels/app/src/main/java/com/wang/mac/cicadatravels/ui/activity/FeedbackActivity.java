package com.wang.mac.cicadatravels.ui.activity;

import android.view.View;
import android.widget.LinearLayout;

import com.wang.mac.cicadatravels.R;

/**
 * Created by mac on 16/7/16.
 * 反馈界面
 * @author wangweijian
 */
public class FeedbackActivity extends AbsBaseActivity implements View.OnClickListener {
    private LinearLayout feedbackReturnLin;
    @Override
    protected int setLayout() {
        return R.layout.activity_feedback;
    }

    @Override
    protected void innitView() {
    feedbackReturnLin = byView(R.id.feedback_return);
    }

    @Override
    protected void initData() {
    feedbackReturnLin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.feedback_return:
                goTo(FeedbackActivity.this,MainActivity.class);
                break;
        }
    }
}
