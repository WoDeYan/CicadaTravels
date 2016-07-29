package com.wang.mac.cicadatravels.ui.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.wang.mac.cicadatravels.R;
import com.wang.mac.cicadatravels.model.bean.ToolBoxDetailsBean;
import com.wang.mac.cicadatravels.model.net.ImgUrls;
import com.wang.mac.cicadatravels.model.net.VolleyInstance;
import com.wang.mac.cicadatravels.model.net.VolleyResult;
import com.wang.mac.cicadatravels.ui.activity.ChoosePlaceActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by mac on 16/7/11.
 * 工具箱详情界面
 * @author wangweijian
 */
public class ToolKitFragment extends AbsBaseFragment implements View.OnClickListener {
    private Button openTKBtn;
    private RelativeLayout originalToolKitLin;//开始工具的界面
    private LinearLayout showToolKitLin;//点击之后的界面
    private TextView countryTv,minTempTv,maxTempTv,localTimeTv;
    private SharedPreferences sharedPreferences;
    private String countryName;
    private MyBroadcast broadcast;
    @Override
    protected int setLayout() {
        //注册广播
        broadcast = new MyBroadcast();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(context.getPackageName()+"TOOLKIT");
        context.registerReceiver(broadcast,intentFilter);
        //查找isFirst 如果为true,执行;为false,不执行
          sharedPreferences = context.getSharedPreferences("tool",Context.MODE_PRIVATE);
        if (sharedPreferences.getBoolean("isFirst",false)){
            Intent intent = new Intent(context.getPackageName()+"TOOLKIT");
            context.sendBroadcast(intent);
        }
        return R.layout.fragment_kit_tool;
    }

    @Override
    protected void initView() {
        openTKBtn = byView(R.id.open_tool_kit_btn);
        originalToolKitLin = byView(R.id.original_tool_kit);
        showToolKitLin = byView(R.id.show_tool_kit);
        countryTv = byView(R.id.tool_kit_country_name);
        minTempTv = byView(R.id.min_temp);
        maxTempTv = byView(R.id.max_temp);
        localTimeTv = byView(R.id.local_time);
    }


    @Override
    protected void initData() {
     openTKBtn.setOnClickListener(this);
        countryTv.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.open_tool_kit_btn:
        goTo(context, ChoosePlaceActivity.class);
                break;
            case R.id.tool_kit_country_name:
                goTo(context,ChoosePlaceActivity.class);

        }
    }



    class MyBroadcast extends BroadcastReceiver{
       //接收广播
        @Override
        public void onReceive(Context context, Intent intent) {
            int id = intent.getIntExtra("id",131);
            countryName = intent.getStringExtra("countryName");
            originalToolKitLin.setVisibility(View.GONE);
            showToolKitLin.setVisibility(View.VISIBLE);

            VolleyInstance.getInstance(context).startRequest(ImgUrls.TOOL_KIT_HEAD_URL + id + ImgUrls.TOOL_KIT_TAIL_URL, new VolleyResult() {
                @Override
                public void success(String str) {
                    Gson gson = new Gson();
                    ToolBoxDetailsBean toolBoxDetailsBean = gson.fromJson(str,ToolBoxDetailsBean.class);
                    Log.d("MyBroadcast", "toolBoxDetailsBean.getTemp_min():" + toolBoxDetailsBean.getTemp_min());
                    if (countryName==null){
                        countryName = "国家";
                    }else {
                    countryTv.setText(countryName);

                    }
                    minTempTv.setText(toolBoxDetailsBean.getTemp_min()+"");
                    maxTempTv.setText(toolBoxDetailsBean.getTemp_max()+"");
                    localTimeTv.setText("当地时间:"+toolBoxDetailsBean.getCurrent_time());
                }

                @Override
                public void failure() {

                }
            });
            //利用sp把数据储存
            //每次接收到广播后,将isFirst存储为true
            sharedPreferences = context.getSharedPreferences("tool",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("isFirst",true);
            editor.commit();
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        //取消注册广播
        context.unregisterReceiver(broadcast);
    }

}
