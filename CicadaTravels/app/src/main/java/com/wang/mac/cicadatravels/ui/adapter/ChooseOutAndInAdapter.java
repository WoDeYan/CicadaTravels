package com.wang.mac.cicadatravels.ui.adapter;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wang.mac.cicadatravels.R;
import com.wang.mac.cicadatravels.model.bean.ForeignBean;
import com.wang.mac.cicadatravels.tools.L;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by mac on 16/7/20.
 * 国外和国内界面的Adapter
 * @author wangweijian
 */
public class ChooseOutAndInAdapter extends BaseExpandableListAdapter{
    private Context context;
    private Map<String, List<ForeignBean.DestinationsBean.ChildrenBean>> maps;//国家中一些地名
    private List<String> groups;//国家名

    public ChooseOutAndInAdapter(Context context, Map<String, List<ForeignBean.DestinationsBean.ChildrenBean>> maps, List<String> groups) {
        this.context = context;
        this.maps = maps;
        this.groups = groups;
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return maps.get(groups.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return maps.get(groups.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return maps.get(groups.get(groupPosition)).get(childPosition).getId();
    }

    /**
     * 根据item判断ID
     * @return
     */
    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        FartherHolder fartherHolder= null;
        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_place_father,parent,false);
            fartherHolder = new FartherHolder(convertView);
            convertView.setTag(fartherHolder);
        }else {
            fartherHolder = (FartherHolder) convertView.getTag();
        }
        fartherHolder.fatherTv.setText(groups.get(groupPosition));
        if (isExpanded){
            fartherHolder.expandParentIv.setImageResource(R.mipmap.expand_down);
        }else {
            fartherHolder.expandParentIv.setImageResource(R.mipmap.expand_up);
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        SonHolder sonHolder = null;
        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_place_son,parent,false);
            sonHolder = new SonHolder(convertView);
            convertView.setTag(sonHolder);
        }else {
            sonHolder= (SonHolder) convertView.getTag();
        }
        sonHolder.sonTv.setText(maps.get(groups.get(groupPosition)).get(childPosition).getName_zh_cn());

        return convertView;
    }

    /**
     *判断子列表是否可以点击
     * true为可以点击
     * @param groupPosition
     * @param childPosition
     * @return
     */
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
    class  FartherHolder {
        private TextView fatherTv;
        private ImageView expandParentIv;
        public FartherHolder(View view) {
            fatherTv = (TextView) view.findViewById(R.id.father_tv);
            expandParentIv = (ImageView) view.findViewById(R.id.expand_parent_iv);
        }
    }
    class SonHolder{
        private TextView sonTv;
        private ImageView expandSonIv;
        public SonHolder(View view) {
            sonTv = (TextView) view.findViewById(R.id.son_tv);
            expandSonIv = (ImageView) view.findViewById(R.id.expand_son_iv);
        }
    }
}
