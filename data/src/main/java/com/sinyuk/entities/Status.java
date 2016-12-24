package com.sinyuk.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sinyuk on 2016/12/23.
 */

public class Status {
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("id")
    private long id;
    @SerializedName("mid")
    private String mid;
    @SerializedName("idstr")
    private String idstr;
    @SerializedName("text")
    private String text;
    @SerializedName("source_allowclick")
    private int sourceAllowclick;
    @SerializedName("source_type")
    private int sourceType;
    @SerializedName("source")
    private String source;
    @SerializedName("favorited")
    private boolean favorited;
    @SerializedName("truncated")
    private boolean truncated;
    @SerializedName("in_reply_to_status_id")
    private String inReplyToStatusId;
    @SerializedName("in_reply_to_user_id")
    private String inReplyToUserId;
    @SerializedName("in_reply_to_screen_name")
    private String inReplyToScreenName;
    @SerializedName("reposts_count")
    private int repostsCount;
    @SerializedName("comments_count")
    private int commentsCount;
    @SerializedName("attitudes_count")
    private int attitudesCount;
    @SerializedName("isLongText")
    private boolean isLongText;
    @SerializedName("retweeted_status")
    private Status retweetedStatus;
    @SerializedName("user")
    private User user;
    @SerializedName("thumbnail_pic")
    private String thumbnailPic;
    @SerializedName("bmiddle_pic")
    private String bmiddlePic;
    @SerializedName("original_pic")
    private String originalPic;
    @SerializedName("pic_urls")
    private List<PicUrls> picUrls;

    public String getThumbnailPic() {
        return thumbnailPic;
    }

    public void setThumbnailPic(String thumbnailPic) {
        this.thumbnailPic = thumbnailPic;
    }

    public String getBmiddlePic() {
        return bmiddlePic;
    }

    public void setBmiddlePic(String bmiddlePic) {
        this.bmiddlePic = bmiddlePic;
    }

    public String getOriginalPic() {
        return originalPic;
    }

    public void setOriginalPic(String originalPic) {
        this.originalPic = originalPic;
    }

    public List<PicUrls> getPicUrls() {
        return picUrls;
    }

    public void setPicUrls(List<PicUrls> picUrls) {
        this.picUrls = picUrls;
    }

    public static class PicUrls {
        /**
         * thumbnail_pic : http://ww1.sinaimg.cn/thumbnail/42b97fafgw1fb1n72ldcmg208m05yx6p.gif
         */

        @SerializedName("thumbnail_pic")
        private String thumbnailPic;

        public String getThumbnailPic() {
            return thumbnailPic;
        }

        public void setThumbnailPic(String thumbnailPic) {
            this.thumbnailPic = thumbnailPic;
        }
    }

    public Status getRetweetedStatus() {
        return retweetedStatus;
    }

    public void setRetweetedStatus(Status retweetedStatus) {
        this.retweetedStatus = retweetedStatus;
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

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getIdstr() {
        return idstr;
    }

    public void setIdstr(String idstr) {
        this.idstr = idstr;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }

    public boolean isTruncated() {
        return truncated;
    }

    public void setTruncated(boolean truncated) {
        this.truncated = truncated;
    }

    public String getInReplyToStatusId() {
        return inReplyToStatusId;
    }

    public void setInReplyToStatusId(String inReplyToStatusId) {
        this.inReplyToStatusId = inReplyToStatusId;
    }

    public String getInReplyToUserId() {
        return inReplyToUserId;
    }

    public void setInReplyToUserId(String inReplyToUserId) {
        this.inReplyToUserId = inReplyToUserId;
    }

    public String getInReplyToScreenName() {
        return inReplyToScreenName;
    }

    public void setInReplyToScreenName(String inReplyToScreenName) {
        this.inReplyToScreenName = inReplyToScreenName;
    }

    public int getRepostsCount() {
        return repostsCount;
    }

    public void setRepostsCount(int repostsCount) {
        this.repostsCount = repostsCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public int getAttitudesCount() {
        return attitudesCount;
    }

    public void setAttitudesCount(int attitudesCount) {
        this.attitudesCount = attitudesCount;
    }

    public boolean isLongText() {
        return isLongText;
    }

    public void setLongText(boolean longText) {
        isLongText = longText;
    }
}
