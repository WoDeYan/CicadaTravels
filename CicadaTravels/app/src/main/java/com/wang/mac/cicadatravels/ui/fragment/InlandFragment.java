package com.wang.mac.cicadatravels.ui.fragment;

import android.widget.GridView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wang.mac.cicadatravels.R;
import com.wang.mac.cicadatravels.model.bean.ForeignBean;
import com.wang.mac.cicadatravels.model.bean.SearchBean;
import com.wang.mac.cicadatravels.model.net.ImgUrls;
import com.wang.mac.cicadatravels.model.net.VolleyInstance;
import com.wang.mac.cicadatravels.model.net.VolleyResult;
import com.wang.mac.cicadatravels.ui.adapter.ForeignAdapter;
import com.wang.mac.cicadatravels.ui.adapter.InlandAdapter;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by mac on 16/7/16.
 * 国内的界面
 * @author wangweijian
 */
public class InlandFragment extends AbsBaseFragment{
    private GridView gridView;
    private ArrayList<SearchBean.ChinaDestinationsBean> beanArrayList;
    private InlandAdapter adapter;
    @Override
    protected int setLayout() {
        return R.layout.fragment_inland;
    }

    @Override
    protected void initView() {
     gridView = byView(R.id.inland_grid_view);
    }

    @Override
    protected void initData() {
      //加载数据
        addInlandData();
    }

    private void addInlandData() {
        VolleyInstance.getInstance(context).startRequest(ImgUrls.SEARCH_FOREIGN_URL, new VolleyResult() {
            @Override
            public void success(String str) {
                beanArrayList = new ArrayList<SearchBean.ChinaDestinationsBean>();
                Gson gson =  new Gson();
                Type type = new TypeToken<SearchBean>(){}.getType();
                SearchBean bean = gson.fromJson(str,type);
                for (int i = 0; i < bean.getChina_destinations().size(); i++) {
                    beanArrayList.add(bean.getChina_destinations().get(i));
                }
                adapter = new InlandAdapter(context);
                adapter.setBeanArrayList(beanArrayList);
                gridView.setAdapter(adapter);
            }

            @Override
            public void failure() {

            }
        });
    }
}
