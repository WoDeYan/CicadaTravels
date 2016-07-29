package com.wang.mac.cicadatravels.ui.fragment;

import android.util.Log;
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

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by mac on 16/7/16.
 * 国外的界面
 * @author wangweijian
 */
public class ForeignFragment extends AbsBaseFragment {
    private GridView gridView;
    private ArrayList<SearchBean.OtherDestinationsBean> destinationsBean;
    private ForeignAdapter foreignAdapter;
    @Override
    protected int setLayout() {
        return R.layout.fragment_foreign;
    }

    @Override
    protected void initView() {
    gridView = byView(R.id.foreign_grid_view);
    }

    @Override
    protected void initData() {
      //加载数据
        addForeignData();
    }

    private void addForeignData() {
        destinationsBean = new ArrayList<>();
        //Volley获取数据解析
        VolleyInstance.getInstance(context).startRequest(ImgUrls.SEARCH_FOREIGN_URL, new VolleyResult() {
            @Override
            public void success(String str) {
                Gson gson = new Gson();
                Type type = new TypeToken<SearchBean>(){}.getType();
                SearchBean bean = gson.fromJson(str, type);
                for (int i = 0; i < bean.getOther_destinations().size(); i++) {
                    destinationsBean.add(bean.getOther_destinations().get(i));

                }
                    foreignAdapter = new ForeignAdapter(context);
                    foreignAdapter.setBeanArrayList(destinationsBean);
                    gridView.setAdapter(foreignAdapter);
                }


            @Override
            public void failure() {

            }
        });

    }
}
