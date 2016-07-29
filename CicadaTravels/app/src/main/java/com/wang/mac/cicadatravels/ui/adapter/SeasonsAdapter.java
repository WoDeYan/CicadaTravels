package com.wang.mac.cicadatravels.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wang.mac.cicadatravels.R;

import java.util.ArrayList;

/**
 * Created by mac on 16/7/21.
 * 四季的适配器
 * @author wanweijian
 */
public class SeasonsAdapter extends BaseAdapter {
    private ArrayList<String> data;
    private Context context;

    public SeasonsAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
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
        holder.seasonTv.setText(data.get(position));
        return convertView;
    }
    class  ViewHolder{
        private TextView seasonTv;
        public ViewHolder(View view) {
            seasonTv = (TextView) view.findViewById(R.id.foreign_tv);
        }
    }
}
