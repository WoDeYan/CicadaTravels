package com.wang.mac.cicadatravels.ui.fragment;

import android.widget.ExpandableListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wang.mac.cicadatravels.R;
import com.wang.mac.cicadatravels.model.bean.ForeignBean;
import com.wang.mac.cicadatravels.model.net.ImgUrls;
import com.wang.mac.cicadatravels.model.net.VolleyInstance;
import com.wang.mac.cicadatravels.model.net.VolleyResult;
import com.wang.mac.cicadatravels.tools.L;
import com.wang.mac.cicadatravels.ui.adapter.ChooseOutAndInAdapter;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mac on 16/7/20.
 * 选择目的地国内界面
 * @author wangweijian
 */
public class ChooseInlandFragment extends AbsBaseFragment {
    private ExpandableListView expandableListView;
    @Override
    protected int setLayout() {
        return R.layout.fragment_inland_choose;
    }

    @Override
    protected void initView() {
      expandableListView = byView(R.id.inland_expandable_list_view);
    }

    @Override
    protected void initData() {
      //加载国内界面的数据
        addInlandData();
    }

    private void addInlandData() {
        //Volley获取网络数据解析
        VolleyInstance.getInstance(context).startRequest(ImgUrls.CHOOSE_PLACE_URL, new VolleyResult() {
            @Override
            public void success(String str) {
                //解析接口数据
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<ForeignBean>>(){}.getType();
                ArrayList<ForeignBean>  beanArrayList = gson.fromJson(str,type);
                Map<String,List<ForeignBean.DestinationsBean.ChildrenBean>>  maps = new HashMap<>();
                List<String> groups = new ArrayList<String>();//台湾,香港
                for (int i =3 ;i<5 ; i++) {
                    ForeignBean bean = beanArrayList.get(i);//获得亚洲...
                    List<ForeignBean.DestinationsBean> dest = bean.getDestinations();//获取目的地的
                    for (int j = 0; j <dest.size() ; j++) {
                        groups.add(dest.get(j).getName_zh_cn());//台北....
                        maps.put(dest.get(j).getName_zh_cn(),dest.get(j).getChildren());
                        ChooseOutAndInAdapter chooseOutAndInAdapter = new ChooseOutAndInAdapter(context,maps,groups);
                        expandableListView.setAdapter(chooseOutAndInAdapter);
                        expandableListView.setGroupIndicator(null);

                    }
                }
            }

            @Override
            public void failure() {

            }
        });

    }
}
