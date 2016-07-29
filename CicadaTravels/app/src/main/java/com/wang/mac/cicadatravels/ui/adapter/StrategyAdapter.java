package com.wang.mac.cicadatravels.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wang.mac.cicadatravels.R;

import com.wang.mac.cicadatravels.model.bean.StrategyLRBean;
import com.wang.mac.cicadatravels.model.db.CountryBean;
import com.wang.mac.cicadatravels.model.db.DBMethod;
import com.wang.mac.cicadatravels.model.db.DaoInstance;
import com.wang.mac.cicadatravels.tools.MyUniversalImageLoaderManager;
import com.wang.mac.cicadatravels.ui.activity.StrategyDetailsActivity;

import java.util.ArrayList;

/**
 * Created by mac on 16/7/15.
 * 第二个界面攻略的适配器
 *
 * @author wangweijian
 */
public class StrategyAdapter extends BaseAdapter {
    private ArrayList<StrategyLRBean> data;
    private Context context;

    public StrategyAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<StrategyLRBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data != null && data.size() > 0 ? data.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return data != null && data.size() > 0 ? data.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_strategy, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //左右两边的数据
        final StrategyLRBean bean = data.get(position);
        if (bean.getCategory() != null) {
            //不为空则设置显示
            holder.strategyCategoryTv.setText(bean.getCategory());
            holder.strategyCategoryTv.setVisibility(View.VISIBLE);
        } else {
            //为空消失
            holder.strategyCategoryTv.setVisibility(View.GONE);
        }
        // 设置到左边

        holder.strategyLeftPoiCountTv.setText(bean.getLeftItem().getPoi_count() + "旅行地");
        holder.strategyLeftNameEnTv.setText(bean.getLeftItem().getName_en());
        holder.strategyLeftNameZhCnTv.setText(bean.getLeftItem().getName_zh_cn());
        //调用加载图片工具类
//            MyUniversalImageLoaderManager.loadImg(bean.getLeftItem().getImage_url(), holder.strategyLeftIv);
        holder.load(holder.strategyLeftIv, bean.getLeftItem().getImage_url());
//            //点击左边图片跳转并把国家名传到头布局
        holder.strategyLeftIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, StrategyDetailsActivity.class);
                intent.putExtra("chineseName", bean.getLeftItem().getName_zh_cn());
                intent.putExtra("id", bean.getLeftItem().getId());
                context.startActivity(intent);
                CountryBean countryBean =  new CountryBean();
                countryBean.setCountryName(bean.getLeftItem().getName_zh_cn());
                DaoInstance.getDaoInstance().insert(countryBean);
            }
        });

        // 设置到右边
        holder.strategyCategoryTv.setText(bean.getCategory());
        holder.strategyRightPoiCountTv.setText(bean.getRightItem().getPoi_count() + "旅行地");
        holder.strategyRightNameEnTv.setText(bean.getRightItem().getName_en());
        holder.strategyRightNameZhCnTv.setText(bean.getRightItem().getName_zh_cn());
        //同上
//            MyUniversalImageLoaderManager.loadImg(bean.getRightItem().getImage_url(), holder.strategyRightIv);
        holder.load(holder.strategyRightIv, bean.getRightItem().getImage_url());
        //点击右边图片
        holder.strategyRightIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, StrategyDetailsActivity.class);
                intent.putExtra("chineseName", bean.getRightItem().getName_zh_cn());//中文名
                intent.putExtra("id", bean.getRightItem().getId());

                CountryBean countryBean = new CountryBean();
                countryBean.setCountryName(bean.getRightItem().getName_zh_cn());
                Log.d("----->1", "countryBean:" + countryBean.getCountryName());
                DaoInstance.getDaoInstance().insert(countryBean);
                DaoInstance.getDaoInstance().queryBy(countryBean.getCountryName());
            }
        });


        return convertView;
    }

    class ViewHolder {
        private ImageView strategyLeftIv, strategyRightIv;
        private TextView strategyLeftNameZhCnTv, strategyRightNameZhCnTv, strategyLeftNameEnTv, strategyRightNameEnTv, strategyLeftPoiCountTv, strategyRightPoiCountTv, strategyCategoryTv;

        public ViewHolder(View view) {
            strategyLeftIv = (ImageView) view.findViewById(R.id.strategy_left_iv);
            strategyRightIv = (ImageView) view.findViewById(R.id.strategy_right_iv);
            strategyLeftNameZhCnTv = (TextView) view.findViewById(R.id.strategy_left_name_zh_cn_tv);
            strategyRightNameZhCnTv = (TextView) view.findViewById(R.id.strategy_right_zh_cn_tv);
            strategyLeftNameEnTv = (TextView) view.findViewById(R.id.strategy_left_name_en_tv);
            strategyRightNameEnTv = (TextView) view.findViewById(R.id.strategy_right_name_en_tv);
            strategyLeftPoiCountTv = (TextView) view.findViewById(R.id.strategy_left_pio_count_tv);
            strategyRightPoiCountTv = (TextView) view.findViewById(R.id.strategy_right_pio_count_tv);
            strategyCategoryTv = (TextView) view.findViewById(R.id.strategy_category_tv);
        }

        public void load(ImageView iv, String url) {
            MyUniversalImageLoaderManager.loadImg(url, iv);
        }
    }
}
