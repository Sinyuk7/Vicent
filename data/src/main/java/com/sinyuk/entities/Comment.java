package com.sinyuk.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sinyuk on 2016/12/29.
 */

public class Comment {
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("id")
    private long id;
    @SerializedName("text")
    private String text;
    @SerializedName("source")
    private String source;
    @SerializedName("mid")
    private String mid;
    @SerializedName("user")
    private User user;
    @SerializedName("reply_comment")
    private Comment replyComment;
    @SerializedName("source_allowclick")
    private int sourceAllowclick;
    @SerializedName("source_type")
    private int sourceType;
    @SerializedName("floor_number")
    private int floorNumber;

    public Comment getReplyComment() {
        return replyComment;
    }

    public void setReplyComment(Comment replyComment) {
        this.replyComment = replyComment;
    }

    public int getSourceAllowclick() {
        return sourceAllowclick;
    }

    public void setSourceAllowclick(int sourceAllowclick) {
        this.sourceAllowclick = sourceAllowclick;
    }

    public int getSourceType() {
        return sourceType;
    }

    public void setSourceType(int sourceType) {
        this.sourceType = sourceType;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }
}
