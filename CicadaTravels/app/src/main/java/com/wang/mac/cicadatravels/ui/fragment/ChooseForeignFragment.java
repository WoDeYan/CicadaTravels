package com.wang.mac.cicadatravels.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wang.mac.cicadatravels.R;
import com.wang.mac.cicadatravels.model.bean.ForeignBean;
import com.wang.mac.cicadatravels.model.bean.ToolBoxDetailsBean;
import com.wang.mac.cicadatravels.model.net.ImgUrls;
import com.wang.mac.cicadatravels.model.net.VolleyInstance;
import com.wang.mac.cicadatravels.model.net.VolleyResult;
import com.wang.mac.cicadatravels.ui.adapter.ChooseOutAndInAdapter;

import org.greenrobot.eventbus.EventBus;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mac on 16/7/20.
 * 选择目的地国外的界面
 *
 * @author wangweijian
 */
public class ChooseForeignFragment extends AbsBaseFragment {
    private ExpandableListView expandableListView;
    private ChooseOutAndInAdapter chooseAdapter;
    private List<ForeignBean.DestinationsBean> dests;
    private ArrayList<ForeignBean> foreignBeanArrayList;

    @Override
    protected int setLayout() {
        return R.layout.fragment_foreign_choose;
    }

    @Override
    protected void initView() {
        expandableListView = byView(R.id.foreign_expandable_list_view);
    }

    @Override
    protected void initData() {
        //加载子父行数据显示
        addData();
    }

    private void addData() {
        //Volley获取网络数据解析
        VolleyInstance.getInstance(context).startRequest(ImgUrls.CHOOSE_PLACE_URL, new VolleyResult() {
            @Override
            public void success(String str) {
                //解析接口数据
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<ForeignBean>>() {
                }.getType();
                foreignBeanArrayList = gson.fromJson(str, type);
                final Map<String, List<ForeignBean.DestinationsBean.ChildrenBean>> maps = new HashMap<>();
                final List<String> groups = new ArrayList<String>(); // 日本,泰国
                for (int i = 0; i < 3; i++) {
                    ForeignBean foreBean = foreignBeanArrayList.get(i);
                    dests = foreBean.getDestinations();
                    Log.d("ChooseForeignFragment", "dests:" + dests);
                    for (int j = 0; j < dests.size(); j++) {
                        Log.d("ChooseForeignFragment", "dests.size():" + dests.size());
                        groups.add(dests.get(j).getName_zh_cn());
                        maps.put(dests.get(j).getName_zh_cn(), dests.get(j).getChildren());
                    }
                }
                chooseAdapter = new ChooseOutAndInAdapter(context, maps, groups);
                expandableListView.setAdapter(chooseAdapter);
                //去掉自带箭头
                expandableListView.setGroupIndicator(null);
                //给子列表设置点击事件
                expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                    @Override
                    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                        Intent intent = new Intent(context.getPackageName()+"TOOLKIT");
                        intent.putExtra("countryName",dests.get(groupPosition).getChildren().get(childPosition).getName_zh_cn());
                        intent.putExtra("id",dests.get(groupPosition).getChildren().get(childPosition).getId());
                        //发送广播
                        context.sendBroadcast(intent);
                        //结束当前界面
                        getActivity().finish();
                        Log.d("ChooseForeignFragment", dests.get(groupPosition).getChildren().get(childPosition).getName_zh_cn());
                        Log.d("ChooseForeignFragment", "dests.get(groupPosition).getChildren().get(childPosition).getId():" + dests.get(groupPosition).getChildren().get(childPosition).getId());
                        return true;
                    }
                });
            }

            @Override
            public void failure() {

            }
        });
    }

}
