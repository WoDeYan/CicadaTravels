package com.wang.mac.cicadatravels.model.net;

/**
 * Created by mac on 16/7/12.
 */
public interface VolleyResult {

    //成功返回一个String
    void success(String str);
    //失败
    void failure();
}
