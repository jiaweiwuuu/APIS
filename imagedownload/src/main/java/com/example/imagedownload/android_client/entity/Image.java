package com.example.imagedownload.android_client.entity;

public class Image {
    private int id;
    private int questionId;
    private String imageUrl;

    public int getId() {
        return id;
    }

    public int getQuestionId() {
        return questionId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", questionId=" + questionId +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
