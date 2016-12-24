package com.sinyuk.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sinyuk on 2016/12/23.
 */

public final class Timeline {

    @SerializedName("hasvisible")
    private boolean hasvisible;
    @SerializedName("previous_cursor")
    private int previousCursor;
    @SerializedName("next_cursor")
    private long nextCursor;
    @SerializedName("total_number")
    private int totalNumber;
    @SerializedName("interval")
    private int interval;
    @SerializedName("uve_blank")
    private int uveBlank;
    @SerializedName("since_id")
    private long sinceId;
    @SerializedName("max_id")
    private long maxId;
    @SerializedName("has_unread")
    private int hasUnread;
    @SerializedName("statuses")
    private List<Status> statuses;

    public boolean isHasvisible() {
        return hasvisible;
    }

    public void setHasvisible(boolean hasvisible) {
        this.hasvisible = hasvisible;
    }

    public int getPreviousCursor() {
        return previousCursor;
    }

    public void setPreviousCursor(int previousCursor) {
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

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public int getUveBlank() {
        return uveBlank;
    }

    public void setUveBlank(int uveBlank) {
        this.uveBlank = uveBlank;
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

    public int getHasUnread() {
        return hasUnread;
    }

    public void setHasUnread(int hasUnread) {
        this.hasUnread = hasUnread;
    }

    public List<Status> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<Status> statuses) {
        this.statuses = statuses;
    }
}
