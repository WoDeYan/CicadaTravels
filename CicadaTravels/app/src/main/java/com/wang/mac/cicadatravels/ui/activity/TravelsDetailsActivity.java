package com.wang.mac.cicadatravels.ui.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.wang.mac.cicadatravels.R;
import com.wang.mac.cicadatravels.model.bean.TravelsDetailsBean;
import com.wang.mac.cicadatravels.model.net.ImgUrls;
import com.wang.mac.cicadatravels.model.net.VolleyInstance;
import com.wang.mac.cicadatravels.model.net.VolleyResult;
//import com.wang.mac.cicadatravels.ui.adapter.TravelsDetailsAdapter;

import java.util.ArrayList;

/**
 * Created by mac on 16/7/21.
 * 游记详情界面
 *
 * @author wangweijian
 */
public class TravelsDetailsActivity extends AbsBaseActivity {
    private RecyclerView recyclerView;
    private TravelsDetailsBean travelsDetailsBean;
//    private TravelsDetailsAdapter adapter;

    @Override
    protected int setLayout() {
        return R.layout.activity_details_travels;
    }

    @Override
    protected void innitView() {
        recyclerView = byView(R.id.travels_recycler_view);
    }

    @Override
    protected void initData() {

//        adapter = new TravelsDetailsAdapter(this);
        //加载游记详情界面数据
        addTravelsDetailsData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void addTravelsDetailsData() {
        //获取游记界面的id
        Intent intent = getIntent();
        int ids = intent.getIntExtra("id", 0);
        Log.d("wang", ids + "");
        //Volley获取网络数据解析
        VolleyInstance.getInstance(this).startRequest(ImgUrls.TRAVELS_DETAILS_HEAD_URL + ids + ImgUrls.TRAVELS_DETAILS_TAIL_URL, new VolleyResult() {
            @Override
            public void success(String str) {
                Gson gson = new Gson();
//                travelsDetailsBean =  gson.fromJson(str,TravelsDetailsBean.class);
                travelsDetailsBean = JSON.parseObject(str, TravelsDetailsBean.class);
                Log.d("wangweijian", "----------->" + travelsDetailsBean.getTrip_days().get(1).getTrip_date());
//                adapter.setTravelsDetailsBean(travelsDetailsBean);
//                recyclerView.setAdapter(adapter);

            }

            @Override
            public void failure() {

            }
        });


    }
}
