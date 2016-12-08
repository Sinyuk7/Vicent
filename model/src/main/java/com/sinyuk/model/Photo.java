package com.sinyuk.model;

import java.util.List;

/**
 * Created by sinyuk on 2016/12/8.
 */

public class Photo {
    private int id;
    private int user_id;
    private String name;
    private String description;
    private String camera;
    private String lens;
    private String focal_length;
    private String iso;
    private String shutter_speed;
    private String aperture;
    private int times_viewed;
    private double rating;
    private int status;
    private String created_at;
    private int category;
    private String taken_at;
    private int width;
    private int height;
    private int votes_count;
    private int favorites_count;
    private int comments_count;
    private String highest_rating_date;
    private int collections_count;
    private int crop_version;
    private boolean privacy;
    private String image_url;
    private String url;
    private int positive_votes_count;
    private boolean watermark;
    private String image_format;
    private User user;
    private boolean is_free_photo;
    private List<Images> images;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getLens() {
        return lens;
    }

    public void setLens(String lens) {
        this.lens = lens;
    }

    public String getFocal_length() {
        return focal_length;
    }

    public void setFocal_length(String focal_length) {
        this.focal_length = focal_length;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public String getShutter_speed() {
        return shutter_speed;
    }

    public void setShutter_speed(String shutter_speed) {
        this.shutter_speed = shutter_speed;
    }

    public String getAperture() {
        return aperture;
    }

    public void setAperture(String aperture) {
        this.aperture = aperture;
    }

    public int getTimes_viewed() {
        return times_viewed;
    }

    public void setTimes_viewed(int times_viewed) {
        this.times_viewed = times_viewed;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }


    public String getTaken_at() {
        return taken_at;
    }

    public void setTaken_at(String taken_at) {
        this.taken_at = taken_at;
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

    public int getVotes_count() {
        return votes_count;
    }

    public void setVotes_count(int votes_count) {
        this.votes_count = votes_count;
    }

    public int getFavorites_count() {
        return favorites_count;
    }

    public void setFavorites_count(int favorites_count) {
        this.favorites_count = favorites_count;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public String getHighest_rating_date() {
        return highest_rating_date;
    }

    public void setHighest_rating_date(String highest_rating_date) {
        this.highest_rating_date = highest_rating_date;
    }

    public int getCollections_count() {
        return collections_count;
    }

    public void setCollections_count(int collections_count) {
        this.collections_count = collections_count;
    }

    public int getCrop_version() {
        return crop_version;
    }

    public void setCrop_version(int crop_version) {
        this.crop_version = crop_version;
    }

    public boolean isPrivacy() {
        return privacy;
    }

    public void setPrivacy(boolean privacy) {
        this.privacy = privacy;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPositive_votes_count() {
        return positive_votes_count;
    }

    public void setPositive_votes_count(int positive_votes_count) {
        this.positive_votes_count = positive_votes_count;
    }
    public boolean isWatermark() {
        return watermark;
    }

    public void setWatermark(boolean watermark) {
        this.watermark = watermark;
    }

    public String getImage_format() {
        return image_format;
    }

    public void setImage_format(String image_format) {
        this.image_format = image_format;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isIs_free_photo() {
        return is_free_photo;
    }

    public void setIs_free_photo(boolean is_free_photo) {
        this.is_free_photo = is_free_photo;
    }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }


}
