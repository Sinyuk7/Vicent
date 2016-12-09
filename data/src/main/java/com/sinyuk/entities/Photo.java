package com.sinyuk.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sinyuk on 2016/12/8.
 */

public class Photo {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("times_viewed")
    private int timesViewed;
    @SerializedName("rating")
    private double rating;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("category")
    private int category;
    @SerializedName("privacy")
    private boolean privacy;
    @SerializedName("width")
    private int width;
    @SerializedName("height")
    private int height;
    @SerializedName("votes_count")
    private int votesCount;
    @SerializedName("comments_count")
    private int commentsCount;
    @SerializedName("nsfw")
    private boolean nsfw;
    @SerializedName("image_url")
    private String imageUrl;
    @SerializedName("user")
    private User user;
    @SerializedName("images")
    private List<Images> images;

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTimesViewed() {
        return timesViewed;
    }

    public void setTimesViewed(int timesViewed) {
        this.timesViewed = timesViewed;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public boolean isPrivacy() {
        return privacy;
    }

    public void setPrivacy(boolean privacy) {
        this.privacy = privacy;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getVotesCount() {
        return votesCount;
    }

    public void setVotesCount(int votesCount) {
        this.votesCount = votesCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public boolean isNsfw() {
        return nsfw;
    }

    public void setNsfw(boolean nsfw) {
        this.nsfw = nsfw;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
