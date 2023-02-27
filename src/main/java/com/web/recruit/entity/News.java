package com.web.recruit.entity;

import java.util.Date;

public class News {
    private Integer newsId;

    private String newsTitle;

    private Date newsDate;

    private String newsPublisher;

    private String newsContent;

    public News() {

    }

    public Integer getNewsId() { return newsId; }

    public void setNewsId(Integer newsId) { this.newsId = newsId; }

    public String getNewsTitle() { return newsTitle; }

    public void setNewsTitle(String newsTitle) {

        this.newsTitle = newsTitle == null ? null : newsTitle.trim();
    }

    public Date getNewsDate() { return newsDate; }

    public void setNewsDate(Date newsDate) {
        this.newsDate = newsDate;
    }

    public String getNewsPublisher() {
        return newsPublisher;
    }

    public void setNewsPublisher(String newsPublisher) {
        this.newsPublisher = newsPublisher;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent == null ? null : newsContent.trim();
    }

    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", newsTitle='" + newsTitle + '\'' +
                ", newsDate='" + newsDate + '\'' +
                ", newsPublisher='" + newsPublisher + '\'' +
                ", newsContent='" + newsContent + '\'' +
                '}';
    }
}
