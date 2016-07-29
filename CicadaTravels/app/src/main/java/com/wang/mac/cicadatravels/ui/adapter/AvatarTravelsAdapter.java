package com.wang.mac.cicadatravels.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wang.mac.cicadatravels.R;
import com.wang.mac.cicadatravels.model.bean.AvatarTravelsBean;
import com.wang.mac.cicadatravels.tools.MyUniversalImageLoaderManager;
import com.wang.mac.cicadatravels.tools.T;

import java.util.ArrayList;

/**
 * Created by mac on 16/7/27.
 */
public class AvatarTravelsAdapter extends BaseAdapter{
    private ArrayList<AvatarTravelsBean.TripsBean> tripsBeanArrayList;
    private Context context;

    public AvatarTravelsAdapter(Context context) {
        this.context = context;
    }

    public void setTripsBeanArrayList(ArrayList<AvatarTravelsBean.TripsBean> tripsBeanArrayList) {
        this.tripsBeanArrayList = tripsBeanArrayList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return tripsBeanArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return tripsBeanArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AvatarHolder holder = null;
        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_avatar,parent,false);
            holder = new AvatarHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (AvatarHolder) convertView.getTag();
        }
        holder.avatarNameTv.setText(tripsBeanArrayList.get(position).getName());
        holder.avatarDateTv.setText(tripsBeanArrayList.get(position).getStart_date()+"/");
        holder.avatarDaysTv.setText(tripsBeanArrayList.get(position).getDays()+"天,");
        holder.avatarCountTv.setText(tripsBeanArrayList.get(position).getPhotos_count()+"图");
        MyUniversalImageLoaderManager.loadImg(tripsBeanArrayList.get(position).getFront_cover_photo_url(),holder.avatarWholeIv);
        return convertView;
    }
    class  AvatarHolder{
        private ImageView avatarWholeIv;
        private TextView  avatarNameTv , avatarDateTv , avatarDaysTv,avatarCountTv;
        public AvatarHolder(View view) {
            avatarWholeIv = (ImageView) view.findViewById(R.id.avatar_whole_iv);
            avatarNameTv = (TextView) view.findViewById(R.id.avatar_name_tv);
            avatarDateTv = (TextView) view.findViewById(R.id.avatar_date_tv);
            avatarDaysTv = (TextView) view.findViewById(R.id.avatar_days_tv);
            avatarCountTv = (TextView) view.findViewById(R.id.avatar_count_tv);
        }
    }
}
