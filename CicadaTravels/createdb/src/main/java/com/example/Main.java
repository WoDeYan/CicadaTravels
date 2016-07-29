package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class Main {
    public static void main(String[]  args){

       //Schema 引包
        //参数1:数据库版本
        //参数2:生成的类存放的包路径
        Schema schema = new Schema(1,"com.wang.mac.cicadatravels.model.db");
        //创建数据库的表和列
        //entity引包 greendao
        //参数:生成的实体类名字
        Entity entity = schema.addEntity("CountryBean");
        //添加自增长主键id
        //autoincrement 自动增长的意思
        //primaryKey 数据库的主键
        entity.addIdProperty().autoincrement().primaryKey();
        //数据库的列: 国家名称
        entity.addStringProperty("countryName");

        //生成数据库
        //参数1:schema
        //参数2:生成的文件module路径
        //在上方设置了通过这个java的main方法生成类存储的包 , 这里要指明包在哪
        try {
            new DaoGenerator().generateAll(schema,"./app/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
