package com.wang.mac.cicadatravels.model.bean;

import java.util.List;

/**
 * Created by mac on 16/7/21.
 * 轮播图点击进去详情界面
 * @author wangweijian
 */
public class BannerDetailsBean {

    /**
     * id : 625
     * name : 氢气球旅行App
     * image_url : http://m.chanyouji.cn/articles/625/ca9e50f74e273041e3a399bf5528f7b5.jpg
     * title : 新·蝉游记正式发布
     * comments_count : 0
     * destination_id : null
     * commentable : false
     * current_user_favorite : false
     * updated_at : 1450783658
     * article_sections : [{"title":"","image_url":"","image_width":0,"image_height":0,"description_user_ids":{},"description":"2015年末，蝉游记原班人马发布创新之作：氢气球旅行App。在蝉小队心目中，它是旅行产品的进化形态。\nApp下载地址：：http://t.cn/RUF88ua"},{"title":"全球旅行榜单","image_url":"","image_width":0,"image_height":0,"description_user_ids":{},"description":"氢气球为你精选吃喝玩乐榜单，一眼看完目的地最好玩的100件事，做攻略这件麻烦的事情从此变得轻松愉快。"},{"title":"","image_url":"http://m.chanyouji.cn/article_sections/14336/acd82e777b55aa9c0b63c9f919819aeb.jpg","image_width":640,"image_height":960,"description_user_ids":{},"description":""},{"title":"行程规划黑科技","image_url":"","image_width":0,"image_height":0,"description_user_ids":{},"description":"将旅行榜单收藏为心愿单，随后发动黑科技，一键生成行程，自带地图导航。这可能是史上最强的行程规划工具。"},{"title":"","image_url":"http://m.chanyouji.cn/article_sections/14337/7c74bf8cfa19f5640f8f57ae7ad96ad1.jpg","image_width":640,"image_height":960,"description_user_ids":{},"description":""},{"title":"轻而美的游记","image_url":"","image_width":0,"image_height":0,"description_user_ids":{},"description":"作为蝉游记的进化产品，氢气球主打\u201c一事一记\u201d的轻游记风格，不仅发游记相当轻松，看游记也更有乐趣。同时保留了蝉游记的经典长游记模式。"},{"title":"","image_url":"http://m.chanyouji.cn/article_sections/14338/4369b5d65ed6ee22a35d97f0e194d274.jpg","image_width":640,"image_height":960,"description_user_ids":{},"description":""},{"title":"写游记，拿红包","image_url":"","image_width":0,"image_height":0,"description_user_ids":{},"description":"在氢气球App里，可以将蝉游记一键转为氢游记，每篇蝉游记平均转为10篇氢游记，1篇氢游记有可能拿到20-50元红包！"},{"title":"","image_url":"http://m.chanyouji.cn/article_sections/14340/f2e3a943cbe3f7ecaac472d0e8188f7c.jpg","image_width":640,"image_height":960,"description_user_ids":{},"description":""},{"title":"下载氢气球旅行","image_url":"","image_width":0,"image_height":0,"description_user_ids":{},"description":"猛戳下载地址：http://t.cn/RUF88ua\n接下来，蝉游记仍将继续运营，但蝉小队的注意力将转向氢气球，这也算是蝉的蜕变吧: )"}]
     */

    private int id;
    private String name;
    private String image_url;
    private String title;
    private int comments_count;
    private Object destination_id;
    private boolean commentable;
    private boolean current_user_favorite;
    private int updated_at;
    /**
     * title :
     * image_url :
     * image_width : 0
     * image_height : 0
     * description_user_ids : {}
     * description : 2015年末，蝉游记原班人马发布创新之作：氢气球旅行App。在蝉小队心目中，它是旅行产品的进化形态。
     App下载地址：：http://t.cn/RUF88ua
     */

    private List<ArticleSectionsBean> article_sections;

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

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public Object getDestination_id() {
        return destination_id;
    }

    public void setDestination_id(Object destination_id) {
        this.destination_id = destination_id;
    }

    public boolean isCommentable() {
        return commentable;
    }

    public void setCommentable(boolean commentable) {
        this.commentable = commentable;
    }

    public boolean isCurrent_user_favorite() {
        return current_user_favorite;
    }

    public void setCurrent_user_favorite(boolean current_user_favorite) {
        this.current_user_favorite = current_user_favorite;
    }

    public int getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(int updated_at) {
        this.updated_at = updated_at;
    }

    public List<ArticleSectionsBean> getArticle_sections() {
        return article_sections;
    }

    public void setArticle_sections(List<ArticleSectionsBean> article_sections) {
        this.article_sections = article_sections;
    }

    public static class ArticleSectionsBean {
        private String title;
        private String image_url;
        private int image_width;
        private int image_height;
        private DescriptionUserIdsBean description_user_ids;
        private String description;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public int getImage_width() {
            return image_width;
        }

        public void setImage_width(int image_width) {
            this.image_width = image_width;
        }

        public int getImage_height() {
            return image_height;
        }

        public void setImage_height(int image_height) {
            this.image_height = image_height;
        }

        public DescriptionUserIdsBean getDescription_user_ids() {
            return description_user_ids;
        }

        public void setDescription_user_ids(DescriptionUserIdsBean description_user_ids) {
            this.description_user_ids = description_user_ids;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public static class DescriptionUserIdsBean {
        }
    }
}
