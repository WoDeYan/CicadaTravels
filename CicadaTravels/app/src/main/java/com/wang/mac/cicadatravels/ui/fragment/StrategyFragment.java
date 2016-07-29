package com.wang.mac.cicadatravels.ui.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wang.mac.cicadatravels.R;
import com.wang.mac.cicadatravels.model.bean.StrategyBean;
import com.wang.mac.cicadatravels.model.bean.StrategyLRBean;
import com.wang.mac.cicadatravels.model.bean.StrategySimpleItem;
import com.wang.mac.cicadatravels.model.net.ImgUrls;
import com.wang.mac.cicadatravels.model.net.VolleyInstance;
import com.wang.mac.cicadatravels.model.net.VolleyResult;
import com.wang.mac.cicadatravels.tools.L;
import com.wang.mac.cicadatravels.tools.T;
import com.wang.mac.cicadatravels.ui.adapter.StrategyAdapter;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by mac on 16/7/11.
 * 攻略的界面
 * @author wangweijian
 */
public class StrategyFragment extends AbsBaseFragment {
    private ListView listView;
    private StrategyAdapter strategyAdapter;
    private StrategyLRBean strategyLRBean;
    private TextView textView1, textView2, textView3, textView4, textView5, textView6;
    private TextView [] country = new TextView[6];

    public static StrategyFragment getInstance() {
        StrategyFragment strategyFragment = new StrategyFragment();
        return strategyFragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_strategy;
    }

    @Override
    protected void initView() {
     listView = byView(R.id.strategy_list_view);
    }

    @Override
    protected void initData() {
        strategyAdapter = new StrategyAdapter(context);
        listView.setAdapter(strategyAdapter);
        addStrategyData();
        //点击加到头布局上
        addHeadData();


    }

    private void addHeadData() {
        View view = LayoutInflater.from(context).inflate(R.layout.item_stategy_head,null);
        textView1 = (TextView) view.findViewById(R.id.country1);
        textView2 = (TextView) view.findViewById(R.id.country2);
        textView3 = (TextView) view.findViewById(R.id.country3);
        textView4 = (TextView) view.findViewById(R.id.country4);
        textView5 = (TextView) view.findViewById(R.id.country5);
        textView6 = (TextView) view.findViewById(R.id.country6);
        country[0]=textView1;
        country[1]=textView2;
        country[2]=textView3;
        country[3]=textView4;
        country[4]=textView5;
        country[5]=textView6;
        //把view加到头布局
        listView.addHeaderView(view);

    }

    //加载攻略界面数据
    public void addStrategyData(){
        //Volley请求网络数据解析
        VolleyInstance.getInstance(context).startRequest(ImgUrls.STRATEGY_FIRST_URL, new VolleyResult() {

            @Override
            public void success(String str
            ) {
//                解析攻略接口收据
                Gson gson = new Gson();
                Type type = new TypeToken<ArrayList<StrategyBean>>(){}.getType();
                ArrayList<StrategyBean> beanArrayList = gson.fromJson(str,type);
//                左右两边的数据
                ArrayList<StrategyLRBean> strategyLRBeanArrayList = new ArrayList<>();
                for (int i = 0; i < beanArrayList.size(); i++) {
//                    每一次开始的时候对地理位置进行赋值
                    strategyLRBean = new StrategyLRBean();
                    strategyLRBean.setCategory(beanArrayList.get(i).getCategory());
                    for (StrategyBean.DestinationsBean destinationsBean : beanArrayList.get(i).getDestinations()) {
                        if (!strategyLRBean.hasBlank()){
                           //不为空,直接加入数据
                            strategyLRBeanArrayList.add(strategyLRBean);
                            strategyLRBean = new StrategyLRBean();
                            strategyLRBean.addData(destinationsBean);
                        }else {
                            //空的,加入数据
                            strategyLRBean.addData(destinationsBean);
                        }
                    }

                }
//                数据处理完成
                strategyAdapter.setData(strategyLRBeanArrayList);

            }

            @Override
            public void failure() {
                T.shortMsg("成功失败了");
            }
        });
    }


}
