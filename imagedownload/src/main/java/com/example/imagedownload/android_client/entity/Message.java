package com.example.imagedownload.android_client.entity;

import java.util.Date;

public class Message {
    private int id;
    private int fromid;
    private int toId;

    private String content;
    private Date createAt;
    private boolean hasRead;
    private String conversationId;
    private String imageUrl;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isHasRead() {
        return hasRead;
    }

    public int getFromid() {
        return fromid;
    }

    public int getToId() {
        return toId;
    }

    public String getConversationId() {
        return conversationId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public void setFromid(int fromid) {
        this.fromid = fromid;
    }

    public void setHasRead(boolean hasRead) {
        this.hasRead = hasRead;
    }

    public void setToId(int toId) {
        this.toId = toId;
    }


    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", fromid=" + fromid +
                ", toId=" + toId +
                ", content='" + content + '\'' +
                ", createAt=" + createAt +
                ", hasRead=" + hasRead +
                ", conversationId='" + conversationId + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
