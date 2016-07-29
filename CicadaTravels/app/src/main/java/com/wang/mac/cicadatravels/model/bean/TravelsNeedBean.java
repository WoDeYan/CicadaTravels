package com.wang.mac.cicadatravels.model.bean;

/**
 * Created by mac on 16/7/26.
 * 游记详情item  one  的数据
 */
public class TravelsNeedBean {
    private String tripData;//旅行日期
    private String days;//第几天
    private String comment;//评论
    private String title;//标题
    private String loveCount;//点赞的数量
    private String commentCount;//评论数量
    private String imgUrls;//图片网址
    private String description;//描述

    public TravelsNeedBean(TravelsDetailsBean.TripDaysBean tripBean, TravelsDetailsBean.TripDaysBean.NodesBean nodesBean, TravelsDetailsBean.TripDaysBean.NodesBean.NotesBean notesBean, TravelsDetailsBean.NotesLikesCommentsBean commentsBean, TravelsDetailsBean.TripDaysBean.NodesBean.NotesBean.PhotoBean photoBean){
        tripData = tripBean.getTrip_date();
        days = tripBean.getDay();
        comment = notesBean.getDescription();
        title = (String) nodesBean.getEntry_name();
        loveCount =commentsBean.getLikes_count();
        commentCount = commentsBean.getComments_count();
        imgUrls = photoBean.getUrl();
        description = notesBean.getDescription();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTripData() {
        return tripData;
    }

    public void setTripData(String tripData) {
        this.tripData = tripData;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLoveCount() {
        return loveCount;
    }

    public void setLoveCount(String loveCount) {
        this.loveCount = loveCount;
    }

    public String getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }

    public String getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(String imgUrls) {
        this.imgUrls = imgUrls;
    }
}
