package com.sinyuk.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sinyuk on 2016/12/29.
 */

public class Comments {
    @SerializedName("comments")
    private List<Comment> comments;

    @SerializedName("hasvisible")
    private boolean hasvisible;
    @SerializedName("previous_cursor")
    private long previousCursor;
    @SerializedName("next_cursor")
    private long nextCursor;
    @SerializedName("total_number")
    private int totalNumber;
    @SerializedName("since_id")
    private long sinceId;
    @SerializedName("max_id")
    private long maxId;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public boolean isHasvisible() {
        return hasvisible;
    }

    public void setHasvisible(boolean hasvisible) {
        this.hasvisible = hasvisible;
    }

    public long getPreviousCursor() {
        return previousCursor;
    }

    public void setPreviousCursor(long previousCursor) {
        this.previousCursor = previousCursor;
    }

    public long getNextCursor() {
        return nextCursor;
    }

    public void setNextCursor(long nextCursor) {
        this.nextCursor = nextCursor;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public long getSinceId() {
        return sinceId;
    }

    public void setSinceId(long sinceId) {
        this.sinceId = sinceId;
    }

    public long getMaxId() {
        return maxId;
    }

    public void setMaxId(long maxId) {
        this.maxId = maxId;
    }
}
