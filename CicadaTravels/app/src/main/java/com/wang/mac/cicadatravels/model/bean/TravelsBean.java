package com.wang.mac.cicadatravels.model.bean;

/**
 * Created by mac on 16/7/13.
 * 第一个界面游记的实体类
 * @author wangweijian
 */
public class TravelsBean  {


    /**
     * id : 297445
     * name : 迷雾神话-雨季中的鹿儿岛
     * photos_count : 127
     * start_date : 2015-06-25
     * end_date : 2015-06-28
     * days : 4
     * level : 4
     * views_count : 19418
     * comments_count : 67
     * likes_count : 963
     * source : web
     * front_cover_photo_url : http://p.chanyouji.cn/297445/1435562435414p19ov2pkn71338nh1qm2er61aja1v.jpg
     * featured : true
     * user : {"id":18696,"name":"Zoe孟孟","image":"http://tp2.sinaimg.cn/1820350857/180/22819771153/0"}
     */

    private int id;
    private String name;
    private String photos_count;
    private String start_date;
    private String end_date;
    private String days;
    private int level;
    private int views_count;
    private int comments_count;
    private int likes_count;
    private String source;
    private String front_cover_photo_url;
    private boolean featured;
    /**
     * id : 18696
     * name : Zoe孟孟
     * image : http://tp2.sinaimg.cn/1820350857/180/22819771153/0
     */

    private UserBean user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotos_count() {
        return photos_count;
    }

    public void setPhotos_count(String photos_count) {
        this.photos_count = photos_count;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getViews_count() {
        return views_count;
    }

    public void setViews_count(int views_count) {
        this.views_count = views_count;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(int likes_count) {
        this.likes_count = likes_count;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getFront_cover_photo_url() {
        return front_cover_photo_url;
    }

    public void setFront_cover_photo_url(String front_cover_photo_url) {
        this.front_cover_photo_url = front_cover_photo_url;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class UserBean {
        private int id;
        private String name;
        private String image;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
