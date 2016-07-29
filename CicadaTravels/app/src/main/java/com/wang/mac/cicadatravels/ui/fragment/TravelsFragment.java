package com.wang.mac.cicadatravels.ui.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wang.mac.cicadatravels.R;
import com.wang.mac.cicadatravels.model.bean.BannerBean;
import com.wang.mac.cicadatravels.model.bean.TravelsBean;
import com.wang.mac.cicadatravels.model.net.ImgUrls;
import com.wang.mac.cicadatravels.tools.T;
import com.wang.mac.cicadatravels.model.net.VolleyInstance;
import com.wang.mac.cicadatravels.model.net.VolleyResult;
import com.wang.mac.cicadatravels.ui.activity.BannerDetailsActivity;
import com.wang.mac.cicadatravels.ui.activity.TravelsDetailsActivity;
import com.wang.mac.cicadatravels.ui.adapter.TravelsAdapter;
import com.youth.banner.Banner;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by mac on 16/7/11.
 * 第一个界面游记界面
 * @author wangweijian
 */
public class TravelsFragment extends AbsBaseFragment implements Banner.OnBannerClickListener, AdapterView.OnItemClickListener {
    private ListView travelsListView;
    private ArrayList<TravelsBean> travelsBean;
    private TravelsBean bean;
    private TravelsAdapter travelsAdapter;
    private Banner banner;
    private String[] imgsUrl={"","",""};
    private ArrayList<TravelsBean> data;
    private int ids;

    @Override
    protected int setLayout() {
        return R.layout.fragment_travels;
    }

    @Override
    protected void initView() {
     travelsListView = byView(R.id.travels_list_view);

    }

    @Override
    protected void initData() {
        //初始化数据
         travelsBean = new ArrayList<>();
        //把数据加载到travelsBean上
        addTravelsData();
        //初始化adapter
        travelsAdapter = new TravelsAdapter(context);
        //数据加载到适配器上
        travelsAdapter.setTravelsBean(travelsBean);
        //listView绑定适配器
        travelsListView.setAdapter(travelsAdapter);
        travelsListView.setOnItemClickListener(this);
        jsonBanner();
    }

    //加载listView上的数据的
    public void  addTravelsData(){

        //Volley获取网络数据解析
        VolleyInstance.getInstance(context).startRequest(ImgUrls.TRAVELS_FIRST_URL, new VolleyResult() {


            @Override
            public void success(String str) {
                //解析首页接口数据
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<TravelsBean>>(){}.getType();
                data = gson.fromJson(str,type);
                for (int i = 0; i < data.size(); i++) {
                    bean = new TravelsBean();
                    bean.setName(data.get(i).getName());
                    bean.setDays(data.get(i).getDays());
                    bean.setPhotos_count(data.get(i).getPhotos_count());
                    bean.setStart_date(data.get(i).getStart_date());
                    bean.setFront_cover_photo_url(data.get(i).getFront_cover_photo_url());
                    bean.setUser(data.get(i).getUser());
                    bean.setId(data.get(i).getId());
                    bean.setUser(data.get(i).getUser());
                    ids = data.get(i).getId();
                    travelsBean.add(bean);

                }

            }

            @Override
            public void failure() {
                T.shortMsg("加载失败了");
            }
        });
    }
    //加载轮播图
    public void jsonBanner(){
        //Volley获取网络数据解析
        VolleyInstance.getInstance(context).startRequest(ImgUrls.TRAVELS_BANNER_URL, new VolleyResult() {
            @Override
            public void success(String str) {
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<BannerBean>>(){}.getType();
                ArrayList<BannerBean>  data = gson.fromJson(str,type);
                for (int i = 0; i < data.size(); i++) {
                    imgsUrl[i]=data.get(i).getImage_url();

                }
                initBanner();
            }
            @Override
            public void failure() {

            }
        });

    }
    //设置轮播图
    public void initBanner(){
        View view = LayoutInflater.from(context).inflate(R.layout.travels_banner,null);
        banner = (Banner) view.findViewById(R.id.travels_banner);
        //给banner设置点击事件
        banner.setOnBannerClickListener(this);
        //设置指示器(小圆点)
        banner.setBannerStyle(Banner.CIRCLE_INDICATOR);
        //设置位置
        banner.setIndicatorGravity(Banner.CENTER);
        banner.isAutoPlay(true);
        //将banner添加到listView的头布局
        travelsListView.addHeaderView(view);
        banner.setImages(imgsUrl);
    }


    @Override
    public void OnBannerClick(View view, int position) {
    goTo(context, BannerDetailsActivity.class);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //点击跳转,并把id传到详情界面
        Intent intent = new Intent(context, TravelsDetailsActivity.class);
        intent.putExtra("id",ids);
        getContext().startActivity(intent);
    }
}
