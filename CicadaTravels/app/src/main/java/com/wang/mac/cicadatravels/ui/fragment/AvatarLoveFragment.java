package com.wang.mac.cicadatravels.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wang.mac.cicadatravels.R;
import com.wang.mac.cicadatravels.model.bean.AvatarLoveBean;
import com.wang.mac.cicadatravels.model.net.ImgUrls;
import com.wang.mac.cicadatravels.model.net.VolleyInstance;
import com.wang.mac.cicadatravels.model.net.VolleyResult;
import com.wang.mac.cicadatravels.ui.activity.AvatarLoveDetailsActivity;
import com.wang.mac.cicadatravels.ui.adapter.AvatarLoveAdapter;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by mac on 16/7/27.
 */
public class AvatarLoveFragment extends AbsBaseFragment implements AdapterView.OnItemClickListener {
    private GridView gridView;
    private AvatarLoveAdapter adapter;
    private ArrayList<AvatarLoveBean> beanArrayList;
    private int ids;

    @Override
    protected int setLayout() {
        return R.layout.fragment_love_avatar;
    }

    @Override
    protected void initView() {
       gridView = byView(R.id.avatar_love_grid_view);
    }

    @Override
    protected void initData() {
        //加载喜欢页面数据
      addAvatarLoveData();
        gridView.setOnItemClickListener(this);
    }

    private void addAvatarLoveData() {
        //获取传来的id
        Bundle bundle = getArguments();
        ids = bundle.getInt("ids");

        //Volley获取网络数据解析
        VolleyInstance.getInstance(context).startRequest(ImgUrls.TRAVELS_AVATAR_LOVE_DETAILS_HEAD_URL + ids + ImgUrls.TRAVELS_AVATAR_LOVE_DETAILS_TAIL_URL, new VolleyResult() {
            @Override
            public void success(String str) {
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<AvatarLoveBean>>(){}.getType();
                ArrayList<AvatarLoveBean > avatarLoveBeanArrayList = gson.fromJson(str,type);
                adapter = new AvatarLoveAdapter(context);
                adapter.setAvatarLoveBeanArrayList(avatarLoveBeanArrayList);
                gridView.setAdapter(adapter);
            }

            @Override
            public void failure() {

            }
        });
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(context, AvatarLoveDetailsActivity.class);
        intent.putExtra("loveId",ids);
        context.startActivity(intent);
    }
}
