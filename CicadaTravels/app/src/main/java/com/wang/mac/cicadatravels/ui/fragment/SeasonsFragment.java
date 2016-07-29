package com.wang.mac.cicadatravels.ui.fragment;

import android.widget.GridView;

import com.wang.mac.cicadatravels.R;
import com.wang.mac.cicadatravels.ui.adapter.SeasonsAdapter;

import java.util.ArrayList;

/**
 * Created by mac on 16/7/16.
 * 四季界面
 * @author wangweijian
 */
public class SeasonsFragment extends AbsBaseFragment{
    private ArrayList<String> data;
    private SeasonsAdapter adapter;
    private GridView gridView;
    @Override
    protected int setLayout() {
        return R.layout.fragment_seasons;
    }

    @Override
    protected void initView() {
       gridView = byView(R.id.seasons_grid_view);
    }

    @Override
    protected void initData() {
      addSeasonData();
    }

    private void addSeasonData() {
        data = new ArrayList<>();
        for (int i = 1; i <13 ; i++) {
            data.add(i+"月");
        }
        adapter = new SeasonsAdapter(context);
        adapter.setData(data);
        gridView.setAdapter(adapter);
    }
}
