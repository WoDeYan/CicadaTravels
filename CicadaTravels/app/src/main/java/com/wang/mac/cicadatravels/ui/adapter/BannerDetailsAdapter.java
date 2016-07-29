package com.wang.mac.cicadatravels.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wang.mac.cicadatravels.R;
import com.wang.mac.cicadatravels.model.bean.BannerDetailsBean;
import com.wang.mac.cicadatravels.tools.L;
import com.wang.mac.cicadatravels.tools.MyUniversalImageLoaderManager;

import java.util.ArrayList;

/**
 * Created by mac on 16/7/22.
 * 轮播图详情界面适配器
 */
public class BannerDetailsAdapter extends BaseAdapter {
    private ArrayList<BannerDetailsBean.ArticleSectionsBean>  beanArrayList;
    private Context context;

    public BannerDetailsAdapter(Context context) {
        this.context = context;
    }

    public void setBeanArrayList(ArrayList<BannerDetailsBean.ArticleSectionsBean> beanArrayList) {
        this.beanArrayList = beanArrayList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return beanArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return beanArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyHolder holder = null;
        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_banner,parent,false);
            holder = new MyHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (MyHolder) convertView.getTag();
        }
        //利用ImageLoader解析图片
        MyUniversalImageLoaderManager.loadImg(beanArrayList.get(position).getImage_url(),holder.bannerIv);
        holder.bannerTitleTv.setText(beanArrayList.get(position).getTitle());
        holder.bannerDesTv.setText(beanArrayList.get(position).getDescription());
        return convertView;
    }

    class MyHolder{
        private TextView bannerTitleTv,bannerDesTv ,bannerHeadTravelTv,bannerHeadReleaseTV;;
        private ImageView bannerIv ,bannerWholeIv;
        public MyHolder(View view) {
            bannerTitleTv = (TextView) view.findViewById(R.id.banner_title_tv);
            bannerDesTv = (TextView) view.findViewById(R.id.banner_description_tv);
            bannerIv = (ImageView) view.findViewById(R.id.banner_iv);
            bannerHeadReleaseTV = (TextView) view.findViewById(R.id.banner_head_release_tv);
            bannerHeadTravelTv = (TextView) view.findViewById(R.id.banner_head_travels_tv);
            bannerWholeIv = (ImageView) view.findViewById(R.id.banner_whole_iv);
        }
    }

}
