package com.wang.mac.cicadatravels.model.bean;

/**
 * Created by mac on 16/7/19.
 * 左右两边的数据
 */
public class StrategyLRBean {
    private StrategySimpleItem leftItem , rightItem;
    private String category;//各个的大洲
    private int leftId , rightId;

    public StrategySimpleItem getLeftItem() {
        return leftItem;
    }

    public void setLeftItem(StrategySimpleItem leftItem) {
        this.leftItem = leftItem;
    }

    public StrategySimpleItem getRightItem() {
        return rightItem;
    }

    public void setRightItem(StrategySimpleItem rightItem) {
        this.rightItem = rightItem;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String ca) {
        switch (ca){
            case "1":
                category = " 国外 · 亚洲 ";
                break;
            case "2":
                category = "国外 · 欧洲";
                break;
            case "3":
                category = "美洲 丶 大洋洲 丶 非洲与南极洲";
                break;
            case "99":
                category = "国内 · 港澳台";
                break;
            case "999":
                category = "国内 · 大陆";
                break;
        }
    }

    public int getLeftId() {
        return leftId;
    }

    public void setLeftId(int leftId) {
        this.leftId = leftId;
    }

    public int getRightId() {
        return rightId;
    }

    public void setRightId(int rightId) {
        this.rightId = rightId;
    }
    //左右是否有空的
    public boolean hasBlank(){
        if (leftItem==null || rightItem==null){
            return true;
        }
        return false;
    }
    //是否可以继续添加数据
    public boolean addData(StrategyBean.DestinationsBean data){
        if (leftItem==null){
            leftItem = new StrategySimpleItem(data);
            return true;
        }else {
            rightItem = new StrategySimpleItem(data);
            return false;
        }
    }
}
