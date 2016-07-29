package com.wang.mac.cicadatravels.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wang.mac.cicadatravels.R;
import com.wang.mac.cicadatravels.model.bean.StrategyDetailsBean;
import com.wang.mac.cicadatravels.tools.MyUniversalImageLoaderManager;


import java.util.ArrayList;

/**
 * Created by mac on 16/7/22.
 * 攻略详情界面适配器
 * @author  wangweijian
 */
public class StrategyDetailsAdapter extends BaseAdapter  {
    private ArrayList<StrategyDetailsBean> beanArrayList;
    private Context context;
    private int id;

    public StrategyDetailsAdapter(Context context) {
        this.context = context;
    }

    public void setBeanArrayList(ArrayList<StrategyDetailsBean> beanArrayList) {
        this.beanArrayList = beanArrayList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return beanArrayList!=null&&beanArrayList.size()>0?beanArrayList.size():0;
    }

    @Override
    public Object getItem(int position) {
        return beanArrayList!=null&&beanArrayList.size()>0?beanArrayList.get(position):null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyHolder holder = null;
        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_strategy_details,parent,false);
            holder = new MyHolder(convertView);
            convertView.setTag(holder);
        }else {
          holder= (MyHolder) convertView.getTag();
        }
        //ImageLoader加载图片
        MyUniversalImageLoaderManager.loadImg(beanArrayList.get(position).getImage_url(),holder.strategyDetailsIv);
        //设置中英文名
        holder.englishName.setText(beanArrayList.get(position).getName_en());
        holder.chineseName.setText(beanArrayList.get(position).getName_zh_cn());
        return convertView;
    }



    class MyHolder{
        private ImageView strategyDetailsIv;
        private TextView chineseName,englishName;//中英文名
        public MyHolder(View view) {
         strategyDetailsIv = (ImageView) view.findViewById(R.id.strategy_details_iv);
            chineseName = (TextView) view.findViewById(R.id.strategy_chinese_name);
            englishName = (TextView) view.findViewById(R.id.strategy_english_name);
        }
    }
}
