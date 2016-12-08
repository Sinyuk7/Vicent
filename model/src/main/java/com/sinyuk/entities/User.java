package com.sinyuk.entities;

import com.google.gson.annotations.SerializedName;

public final class User {


    @SerializedName("id")
    private int id;
    @SerializedName("username")
    private String username;
    @SerializedName("firstname")
    private String firstname;
    @SerializedName("lastname")
    private String lastname;
    @SerializedName("city")
    private String city;
    @SerializedName("country")
    private String country;
    @SerializedName("usertype")
    private int usertype;
    @SerializedName("fullname")
    private String fullname;
    @SerializedName("userpic_url")
    private String userpicUrl;
    @SerializedName("userpic_https_url")
    private String userpicHttpsUrl;
    @SerializedName("cover_url")
    private String coverUrl;
    @SerializedName("upgrade_status")
    private int upgradeStatus;
    @SerializedName("store_on")
    private boolean storeOn;
    @SerializedName("affection")
    private int affection;
    @SerializedName("avatars")
    private Avatars avatars;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getUsertype() {
        return usertype;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUserpicUrl() {
        return userpicUrl;
    }

    public void setUserpicUrl(String userpicUrl) {
        this.userpicUrl = userpicUrl;
    }

    public String getUserpicHttpsUrl() {
        return userpicHttpsUrl;
    }

    public void setUserpicHttpsUrl(String userpicHttpsUrl) {
        this.userpicHttpsUrl = userpicHttpsUrl;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public int getUpgradeStatus() {
        return upgradeStatus;
    }

    public void setUpgradeStatus(int upgradeStatus) {
        this.upgradeStatus = upgradeStatus;
    }

    public boolean isStoreOn() {
        return storeOn;
    }

    public void setStoreOn(boolean storeOn) {
        this.storeOn = storeOn;
    }

    public int getAffection() {
        return affection;
    }

    public void setAffection(int affection) {
        this.affection = affection;
    }

    public Avatars getAvatars() {
        return avatars;
    }

    public void setAvatars(Avatars avatars) {
        this.avatars = avatars;
    }
}