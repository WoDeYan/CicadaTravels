package com.wang.mac.cicadatravels.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wang.mac.cicadatravels.R;
import com.wang.mac.cicadatravels.model.bean.ForeignBean;
import com.wang.mac.cicadatravels.model.bean.SearchBean;

import java.util.ArrayList;

/**
 * Created by mac on 16/7/21.
 */
public class ForeignAdapter extends BaseAdapter {
    private ArrayList<SearchBean.OtherDestinationsBean> beanArrayList;//创建目的地类
    private Context context;

    public ForeignAdapter(Context context) {
        this.context = context;
    }

    public void setBeanArrayList(ArrayList<SearchBean.OtherDestinationsBean> beanArrayList) {
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
        ViewHolder holder = null;
        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_foreign,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.foreignTv.setText(beanArrayList.get(position).getName());
        return convertView;
    }
    class ViewHolder {
        private TextView foreignTv;
        public ViewHolder(View view) {
            foreignTv = (TextView) view.findViewById(R.id.foreign_tv);
        }
    }
}
