package com.wang.mac.cicadatravels.model.bean;

/**
 * Created by mac on 16/7/21.
 */
public class ToolBoxDetailsBean {

    /**
     * temp_min : 23
     * temp_max : 31
     * current_time : 15:18，周四
     * urls_category_0 : false
     * urls_category_1 : false
     * language_code : zh
     * currency_code : CNY
     * currency_display : 元
     * country_name : beijing
     */

    private int temp_min;
    private int temp_max;
    private String current_time;
    private boolean urls_category_0;
    private boolean urls_category_1;
    private String language_code;
    private String currency_code;
    private String currency_display;
    private String country_name;

    public int getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(int temp_min) {
        this.temp_min = temp_min;
    }

    public int getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(int temp_max) {
        this.temp_max = temp_max;
    }

    public String getCurrent_time() {
        return current_time;
    }

    public void setCurrent_time(String current_time) {
        this.current_time = current_time;
    }

    public boolean isUrls_category_0() {
        return urls_category_0;
    }

    public void setUrls_category_0(boolean urls_category_0) {
        this.urls_category_0 = urls_category_0;
    }

    public boolean isUrls_category_1() {
        return urls_category_1;
    }

    public void setUrls_category_1(boolean urls_category_1) {
        this.urls_category_1 = urls_category_1;
    }

    public String getLanguage_code() {
        return language_code;
    }

    public void setLanguage_code(String language_code) {
        this.language_code = language_code;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

    public String getCurrency_display() {
        return currency_display;
    }

    public void setCurrency_display(String currency_display) {
        this.currency_display = currency_display;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }
}
