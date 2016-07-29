package com.wang.mac.cicadatravels.ui.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wang.mac.cicadatravels.R;
import com.wang.mac.cicadatravels.model.bean.AvatarLoveBean;
import com.wang.mac.cicadatravels.model.net.ImgUrls;
import com.wang.mac.cicadatravels.model.net.VolleyInstance;
import com.wang.mac.cicadatravels.model.net.VolleyResult;
import com.wang.mac.cicadatravels.tools.MyUniversalImageLoaderManager;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by mac on 16/7/27.
 */
public class AvatarLoveDetailsActivity extends AbsBaseActivity {
    private ImageView  loveDetailsIv;
    private TextView  loveDetailsTv;
    @Override
    protected int setLayout() {
        return R.layout.activity_details_love_avatar;
    }

    @Override
    protected void innitView() {
        loveDetailsIv = byView(R.id.love_details_iv);
        loveDetailsTv = byView(R.id.love_details_tv);
    }

    @Override
    protected void initData() {
       addLoveDetailsData();
    }

    private void addLoveDetailsData() {
        Intent intent = getIntent();
        int ids =  intent.getIntExtra("loveId",0);
        VolleyInstance.getInstance(this).startRequest(ImgUrls.TRAVELS_AVATAR_LOVE_DETAILS_HEAD_URL + ids + ImgUrls.TRAVELS_AVATAR_LOVE_DETAILS_TAIL_URL, new VolleyResult() {
            @Override
            public void success(String str) {
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<AvatarLoveBean>>(){}.getType();
                ArrayList<AvatarLoveBean > avatarLoveBeanArrayList = gson.fromJson(str,type);
                for (int i = 0; i < avatarLoveBeanArrayList.size(); i++) {
                    loveDetailsTv.setText(avatarLoveBeanArrayList.get(i).getDescription());
                    MyUniversalImageLoaderManager.loadImg(avatarLoveBeanArrayList.get(i).getPhoto_url(),loveDetailsIv);
                    loveDetailsIv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            finish();
                        }
                    });
                }
            }

            @Override
            public void failure() {

            }
        });
    }
}
