package com.wang.mac.cicadatravels.model.db;

import java.util.List;

/**
 * Created by mac on 16/7/25.
 */
public interface DBMethod<T> {

    void insert (T t);

    void insert(List<T> t);

    List<T> queryBy(String country);



}
