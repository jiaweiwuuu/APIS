package com.example.imagedownload.android_client.entity;

import java.util.Date;
import java.util.List;

public class News {
    private int id;
    private String title;
    private String content;
    private int userId;
    private Date createAt;
    private int commentCount;
    private String imageUrl;
    private List<Image> images;

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                ", createAt=" + createAt +
                ", commentCount=" + commentCount +
                ", imageUrl='" + imageUrl + '\'' +
                ", images=" + images +
                '}';
    }

    public Date getCreateAt() {
        return createAt;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public int getUserId() {
        return userId;
    }

    public String getContent() {
        return content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
