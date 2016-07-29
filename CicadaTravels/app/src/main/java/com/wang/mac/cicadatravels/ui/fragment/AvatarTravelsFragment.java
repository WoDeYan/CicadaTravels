package com.wang.mac.cicadatravels.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;
import com.wang.mac.cicadatravels.R;
import com.wang.mac.cicadatravels.model.bean.AvatarTravelsBean;
import com.wang.mac.cicadatravels.model.bean.TravelsBean;
import com.wang.mac.cicadatravels.model.net.ImgUrls;
import com.wang.mac.cicadatravels.model.net.VolleyInstance;
import com.wang.mac.cicadatravels.model.net.VolleyResult;
import com.wang.mac.cicadatravels.ui.adapter.AvatarTravelsAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

/**
 * Created by mac on 16/7/27.
 */
public class AvatarTravelsFragment extends AbsBaseFragment {
    private ListView listView;
    private int ids;
    private AvatarTravelsBean avatarTravelsBean;
    private AvatarTravelsAdapter adapter;
    private AvatarLoveFragment avatarLoveFragment;

    @Override
    protected int setLayout() {
        return R.layout.fragment_travels_avatar;
    }

    @Override
    protected void initView() {
      listView = byView(R.id.avatar_list_view);
    }

    @Override
    protected void initData() {
        //获取id
        Bundle bundle = getArguments();
        ids =  bundle.getInt("ids");
        Log.d("xxxx", "----->" + ids);
        //加载头像详情游记界面
        addTravelsAvatarData();
    }

    private void addTravelsAvatarData() {
         //Volley获取网络数据解析
        VolleyInstance.getInstance(context).startRequest(ImgUrls.TRAVELS_AVATAR_DETAILS_HEAD_URL + ids + ImgUrls.TRAVELS_AVATAR_DETAILS_TAIL_URL, new VolleyResult() {
            @Override
            public void success(String str) {
                Gson gson = new Gson();
                avatarTravelsBean = gson.fromJson(str,AvatarTravelsBean.class);
                ArrayList<AvatarTravelsBean.TripsBean> tripsBeanArrayList = (ArrayList<AvatarTravelsBean.TripsBean>) avatarTravelsBean.getTrips();
                adapter = new AvatarTravelsAdapter(context);
                adapter.setTripsBeanArrayList(tripsBeanArrayList);
                listView.setAdapter(adapter);

            }

            @Override
            public void failure() {

            }
        });

    }

}
