package com.wang.mac.cicadatravels.ui.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wang.mac.cicadatravels.R;
import com.wang.mac.cicadatravels.model.bean.StrategyDetailsBean;
import com.wang.mac.cicadatravels.model.net.ImgUrls;
import com.wang.mac.cicadatravels.model.net.VolleyInstance;
import com.wang.mac.cicadatravels.model.net.VolleyResult;
import com.wang.mac.cicadatravels.ui.adapter.StrategyDetailsAdapter;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by mac on 16/7/19.
 */
public class StrategyDetailsActivity extends AbsBaseActivity implements View.OnClickListener {
    private ListView listView;
    private ArrayList<StrategyDetailsBean> beanArrayList;
    private StrategyDetailsAdapter adapter;
    private TextView strategyDetailsTitleName;
    private LinearLayout  strategyDetailsReturnLin;//攻略详情界面返回键

    @Override
    protected int setLayout() {
        return R.layout.activity_details_strategy;
    }

    @Override
    protected void innitView() {
        listView = byView(R.id.strategy_details_list_view);
        strategyDetailsTitleName = byView(R.id.strategy_details_title_country_name);
        strategyDetailsReturnLin = byView(R.id.strategy_details_return);
    }

    @Override
    protected void initData() {
        beanArrayList = new ArrayList<>();
        adapter = new StrategyDetailsAdapter(this);
        //加载攻略详情界面数据
        addStrategyData();
        listView.setAdapter(adapter);
        //把中文国家设置到详情界面title上
        setStrategyTitle();
        strategyDetailsReturnLin.setOnClickListener(this);


    }

    private void setStrategyTitle() {
        //接收到国家中文名
        Intent intent =  getIntent();
        String chineseName = intent.getStringExtra("chineseName");
        strategyDetailsTitleName.setText(chineseName+"攻略");

    }

    private void addStrategyData() {
        //接收网址id
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        //Volley获取网络数据解析
        VolleyInstance.getInstance(this).startRequest(ImgUrls.STRATEGY_DETAILS_HEAD_URL + id + ImgUrls.STRATEGY_DETAILS_TAIL_URL, new VolleyResult() {
            @Override
            public void success(String str) {
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<StrategyDetailsBean>>() {
                }.getType();
                ArrayList<StrategyDetailsBean> bean = gson.fromJson(str, type);
                for (int i = 0; i < bean.size(); i++) {
                    beanArrayList.add(bean.get(i));
                    adapter.setBeanArrayList(beanArrayList);

                }
            }

            @Override
            public void failure() {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.strategy_details_return:
                finish();
                break;
        }
    }
}
