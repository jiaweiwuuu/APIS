package com.example.myapplication.android_client.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Comment {
    private int id;
    private String content;

    @SerializedName("entityId")
    private int newsId;

    private int entityType;

    private Date createAt;

    private int userId;

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", newsId=" + newsId +
                ", entityType=" + entityType +
                ", createAt=" + createAt +
                ", userId=" + userId +
                '}';
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public int getUserId() {
        return userId;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEntityType() {
        return entityType;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setEntityType(int entityType) {
        this.entityType = entityType;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }
}
