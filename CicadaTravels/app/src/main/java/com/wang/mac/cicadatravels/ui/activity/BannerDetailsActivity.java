package com.wang.mac.cicadatravels.ui.activity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wang.mac.cicadatravels.R;
import com.wang.mac.cicadatravels.model.bean.BannerDetailsBean;
import com.wang.mac.cicadatravels.model.net.ImgUrls;
import com.wang.mac.cicadatravels.model.net.VolleyInstance;
import com.wang.mac.cicadatravels.model.net.VolleyResult;
import com.wang.mac.cicadatravels.tools.MyUniversalImageLoaderManager;
import com.wang.mac.cicadatravels.tools.T;
import com.wang.mac.cicadatravels.ui.adapter.BannerDetailsAdapter;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by mac on 16/7/21.
 * 轮播图详情界面
 *
 * @author wangweijian
 */
public class BannerDetailsActivity extends AbsBaseActivity implements View.OnClickListener {
    private ListView listView;
    private ArrayList<BannerDetailsBean.ArticleSectionsBean> beanArrayList;
    private BannerDetailsAdapter adapter;
    private BannerDetailsBean bean;
    private LinearLayout bannerDetailsReturnLin;

    @Override
    protected int setLayout() {
        return R.layout.activity_details_banner;
    }

    @Override
    protected void innitView() {
        listView = byView(R.id.banner_detail_list_view);
        bannerDetailsReturnLin = byView(R.id.banner_details_return);
    }

    @Override
    protected void initData() {
        //加载轮播图详情数据
        addBannerData();
        //返回键设置监听
        bannerDetailsReturnLin.setOnClickListener(this);

    }


    private void addBannerData() {
        beanArrayList = new ArrayList<>();
        adapter = new BannerDetailsAdapter(this);
        //Volley获取网络数据解析
        VolleyInstance.getInstance(this).startRequest(ImgUrls.BANNER_DETAILS_URL, new VolleyResult() {
            @Override
            public void success(String str) {
                Gson gson = new Gson();
                Type type = new TypeToken<BannerDetailsBean>() {
                }.getType();
                bean = gson.fromJson(str, type);
                for (int i = 0; i < bean.getArticle_sections().size(); i++) {
                    beanArrayList.add(bean.getArticle_sections().get(i));
                    adapter.setBeanArrayList(beanArrayList);
                    listView.setAdapter(adapter);
                }
                //获取头布局
                View view = getLayoutInflater().inflate(R.layout.banner_detail_header, null);
                TextView bannerHeadReleaseTV = (TextView) view.findViewById(R.id.banner_head_release_tv);
                TextView bannerHeadTravelTv = (TextView) view.findViewById(R.id.banner_head_travels_tv);
                ImageView bannerWholeIv = (ImageView) view.findViewById(R.id.banner_whole_iv);
                bannerHeadReleaseTV.setText(bean.getName().toString());
                bannerHeadTravelTv.setText(bean.getTitle().toString());
                //加载图片
                MyUniversalImageLoaderManager.loadImg(bean.getImage_url(), bannerWholeIv);
                listView.addHeaderView(view);
            }


            @Override
            public void failure() {
                T.shortMsg("加载失败了");
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.banner_details_return:
                finish();
                break;
        }
    }
}
