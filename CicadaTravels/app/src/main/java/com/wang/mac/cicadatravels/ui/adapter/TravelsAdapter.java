package com.wang.mac.cicadatravels.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wang.mac.cicadatravels.R;
import com.wang.mac.cicadatravels.model.bean.TravelsBean;
import com.wang.mac.cicadatravels.tools.MyUniversalImageLoaderManager;

import java.util.ArrayList;

/**
 * Created by mac on 16/7/13.
 */
public class TravelsAdapter extends BaseAdapter {
    private ArrayList<TravelsBean> travelsBean;
    private Context context;
    private final int TYPE_COMMON = 0, TYPE_INSERT = 1, TYPE_COUNT = 2;
    private MyUniversalImageLoaderManager myUniversalImageLoaderManager;


    public TravelsAdapter(Context context) {
        this.context = context;
    }

    public void setTravelsBean(ArrayList<TravelsBean> travelsBean) {
        this.travelsBean = travelsBean;
        notifyDataSetChanged();
    }

    @Override
    public int getViewTypeCount() {
        return TYPE_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 3) {
            return TYPE_INSERT;
        } else {
            return TYPE_COMMON;
        }

    }

    @Override
    public int getCount() {
        return travelsBean != null && travelsBean.size() > 0 ? travelsBean.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return travelsBean != null && travelsBean.size() > 0 ? travelsBean.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        InsertHolder insertHolder = null;
        int type = getItemViewType(position);
        if (convertView == null) {
            switch (type) {
                case TYPE_COMMON:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_travels_, parent, false);
                    holder = new ViewHolder(convertView);
                    convertView.setTag(holder);
                    break;
                case TYPE_INSERT:
                    convertView = LayoutInflater.from(context).inflate(R.layout.item_travels_insert, parent, false);
                    insertHolder = new InsertHolder(convertView);
                    convertView.setTag(insertHolder);
                    break;
            }
        } else {
            switch (type) {
                case TYPE_COMMON:
                    holder = (ViewHolder) convertView.getTag();
                    break;
                case TYPE_INSERT:
                    insertHolder = (InsertHolder) convertView.getTag();
                    break;
            }


        }
        TravelsBean bean = travelsBean.get(position);
        switch (type) {
            case TYPE_COMMON:
                myUniversalImageLoaderManager = new MyUniversalImageLoaderManager();
                holder.travelsNameTv.setText(bean.getName());
                holder.travelsStartDateTv.setText(bean.getStart_date() + "/");
                holder.travelsDaysTv.setText(bean.getDays() + "天");
                holder.travelsPhotosCountTv.setText(bean.getPhotos_count() + "张");
                MyUniversalImageLoaderManager.loadImg(bean.getFront_cover_photo_url(), holder.travelsWholeIv);
                MyUniversalImageLoaderManager.loadImg(bean.getUser().getImage(), holder.travelsPartIv);
                break;
            case TYPE_INSERT:
                insertHolder.oneMinuteTravels.setImageResource(R.mipmap.one);
                insertHolder.threeMinuteStrategy.setImageResource(R.mipmap.three);
                break;


        }

        return convertView;
    }

    /**
     * 缓存类
     */
    class ViewHolder {
        private TextView travelsNameTv, travelsStartDateTv, travelsDaysTv, travelsPhotosCountTv;
        private ImageView travelsWholeIv, travelsPartIv;

        public ViewHolder(View view) {
            travelsNameTv = (TextView) view.findViewById(R.id.travels_name_tv);
            travelsStartDateTv = (TextView) view.findViewById(R.id.travels_start_date_tv);
            travelsDaysTv = (TextView) view.findViewById(R.id.travels_days_tv);
            travelsPhotosCountTv = (TextView) view.findViewById(R.id.travels_photos_count_tv);
            travelsWholeIv = (ImageView) view.findViewById(R.id.travels_whole_iv);
            travelsPartIv = (ImageView) view.findViewById(R.id.travels_part_iv);

        }
    }

    class InsertHolder {
        private ImageView oneMinuteTravels, threeMinuteStrategy;

        public InsertHolder(View view) {
            oneMinuteTravels = (ImageView) view.findViewById(R.id.one_minute_travels);
            threeMinuteStrategy = (ImageView) view.findViewById(R.id.three_minute_strategy);
        }
    }
}
