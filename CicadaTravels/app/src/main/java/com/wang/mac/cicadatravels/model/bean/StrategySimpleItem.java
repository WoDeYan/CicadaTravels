package com.wang.mac.cicadatravels.model.bean;

/**
 * Created by mac on 16/7/19.
 * 每一张图片上的数据
 * @author wangweijian
 */
public class StrategySimpleItem {
    private int id;
    private String name_zh_cn;
    private String name_en;
    private String poi_count;
    private String image_url;

    public StrategySimpleItem(StrategyBean.DestinationsBean data) {
        id = data.getId();
        name_zh_cn = data.getName_zh_cn();
        name_en = data.getName_en();
        poi_count = data.getPoi_count();
        image_url = data.getImage_url();


    }

    public int getId() {
        return id;
    }

    public String getName_zh_cn() {
        return name_zh_cn;
    }

    public String getName_en() {
        return name_en;
    }

    public String getPoi_count() {
        return poi_count;
    }

    public String getImage_url() {
        return image_url;
    }
}
