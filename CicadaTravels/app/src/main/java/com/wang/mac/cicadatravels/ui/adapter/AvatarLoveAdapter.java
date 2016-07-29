package com.wang.mac.cicadatravels.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.wang.mac.cicadatravels.R;
import com.wang.mac.cicadatravels.model.bean.AvatarLoveBean;
import com.wang.mac.cicadatravels.tools.MyUniversalImageLoaderManager;
import com.wang.mac.cicadatravels.ui.activity.AvatarLoveDetailsActivity;

import java.util.ArrayList;

/**
 * Created by mac on 16/7/27.
 */
public class AvatarLoveAdapter extends BaseAdapter {
    private ArrayList<AvatarLoveBean> avatarLoveBeanArrayList;
    private Context context;


    public AvatarLoveAdapter(Context context) {
        this.context = context;
    }

    public void setAvatarLoveBeanArrayList(ArrayList<AvatarLoveBean> avatarLoveBeanArrayList) {
        this.avatarLoveBeanArrayList = avatarLoveBeanArrayList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return avatarLoveBeanArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return avatarLoveBeanArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LoveHolder holder = null;
        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_avatar_love,parent,false);
            holder = new LoveHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (LoveHolder) convertView.getTag();
        }
        MyUniversalImageLoaderManager.loadImg(avatarLoveBeanArrayList.get(position).getPhoto_url(),holder.avatarLoveIv);
        return convertView;
    }
    class LoveHolder{
        private ImageView avatarLoveIv;
        public LoveHolder(View view) {
            avatarLoveIv = (ImageView) view.findViewById(R.id.avatar_love_iv);
        }
    }
}
