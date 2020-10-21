package com.example.imagedownload.android_client.entity;

public class User {
    private int id;
    private String name;
    private String password;
    private String salt;
    private String headUrl;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSalt() {
        return salt;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name=" + name +
                ", password='" + password + '\'' +
                ", salt=" + salt +
                ", headUrl='" + headUrl + '\'' +
                '}';
    }
}
