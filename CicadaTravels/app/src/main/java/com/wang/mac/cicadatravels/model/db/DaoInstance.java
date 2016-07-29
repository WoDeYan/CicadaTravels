package com.wang.mac.cicadatravels.model.db;

import android.database.sqlite.SQLiteDatabase;

import com.wang.mac.cicadatravels.tools.CicadaTravelsApp;

import java.util.List;

import de.greenrobot.dao.query.QueryBuilder;

/**
 * Created by mac on 16/7/25.
 * 数据库的单例类
 */
public class DaoInstance implements DBMethod<CountryBean> {

    private static DaoInstance daoInstance;
    /**
     * 不可修改的静态常量类->数据库的名字
     */
    private static final String DB_NAME = "cicada.db";
    /**
     * 创建数据库的类
     */
    private DaoMaster.DevOpenHelper helper;
    private SQLiteDatabase database;
    private DaoMaster daoMaster;
    /**
     * 操作数据库的类
     */
    private DaoSession daoSession;
    private CountryBeanDao countryBeanDao;
    //数据库条件类
    private QueryBuilder<CountryBean> queryBuilder;
    //对外提供获取单例的方法
    public static DaoInstance getDaoInstance() {
        if (daoInstance==null){
            synchronized (DaoInstance.class){
                if (daoInstance==null){
                    daoInstance = new DaoInstance();
                }
            }
        }
        return daoInstance;
    }
    //私有化构造方法
    private DaoInstance(){
        //创建数据库操作对象
        countryBeanDao = getCountryBeanDao();
        queryBuilder = countryBeanDao.queryBuilder();
    }

    public DaoMaster.DevOpenHelper getHelper() {
        if (helper==null){
            helper = new DaoMaster.DevOpenHelper(CicadaTravelsApp.getContext(),DB_NAME,null);
        }
        return helper;
    }

    public SQLiteDatabase getDatabase() {
        if (database==null){
        database= getHelper().getWritableDatabase();
        }
        return database;
    }

    public DaoMaster getDaoMaster() {
        if (daoMaster==null){
            daoMaster = new DaoMaster(getDatabase());
        }
        return daoMaster;
    }

    public DaoSession getDaoSession() {
        if (daoSession==null){
            daoSession = getDaoMaster().newSession();
        }
        return daoSession;
    }

    public CountryBeanDao getCountryBeanDao() {
        if (countryBeanDao==null){
            countryBeanDao = getDaoSession().getCountryBeanDao();
        }
        return countryBeanDao;
    }

    /**
     * 数据库对外提供的插入单个数据方法
     * @param countryBean
     */
    @Override
    public void insert(CountryBean countryBean) {
        _insert(countryBean);
    }
    //对内提供
    private void _insert(CountryBean countryBean){
        countryBeanDao.insertOrReplace(countryBean);
    }

    /**
     * 对外提供插入集合的方法
     * @param beanList
     */
    @Override
    public void insert(List<CountryBean> beanList) {
      getDaoInstance()._insert(beanList);
    }
    //对内提供的插入集合的方法
    private void _insert(List<CountryBean> beanList){
        countryBeanDao.insertOrReplaceInTx(beanList);
    }

    /**
     * 对外提供的查询country的方法
     * @param country
     */
    @Override
    public List<CountryBean> queryBy(String country) {
     return getDaoInstance()._queryBy(country);
    }
    //对内提供
    private List<CountryBean> _queryBy(String country){
        countryBeanDao.queryBuilder().where(CountryBeanDao.Properties.CountryName.eq(country));
        queryBuilder.limit(20);
        return queryBuilder.list();
    }


}
