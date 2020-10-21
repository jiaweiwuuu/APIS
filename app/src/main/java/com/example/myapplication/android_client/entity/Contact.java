package com.example.myapplication.android_client.entity;

public class Contact {
    private int id;
    private String name;
    private String headUrl;
    private String latestMessage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public String getLatestMessage() {
        return latestMessage;
    }

    public String getName() {
        return name;
    }

    public void setLatestMessage(String latestMessage) {
        this.latestMessage = latestMessage;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", headUrl='" + headUrl + '\'' +
                ", latestMessage='" + latestMessage + '\'' +
                '}';
    }
}
