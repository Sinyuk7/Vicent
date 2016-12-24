package com.sinyuk.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sinyuk on 2016/12/24.
 */

public class AccessToken {

    /**
     * access_token : ACCESS_TOKEN
     * expires_in : 1234
     * remind_in : 798114
     * uid : 12341234
     */

    @SerializedName("access_token")
    private String accessToken;
    @SerializedName("expires_in")
    private long expiresIn;
    @SerializedName("uid")
    private String uid;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
