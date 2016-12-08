package com.sinyuk.model;

public final class Images {
    /**
     * size : 2
     * url : https://drscdn.500px.org/photo/186992801/q%3D50_w%3D140_h%3D140/353e544ff545b39d6c960c80ede2500c?v=3
     * https_url : https://drscdn.500px.org/photo/186992801/q%3D50_w%3D140_h%3D140/353e544ff545b39d6c960c80ede2500c?v=3
     * format : jpeg
     */

    private int size;
    private String url;
    private String https_url;
    private String format;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHttps_url() {
        return https_url;
    }

    public void setHttps_url(String https_url) {
        this.https_url = https_url;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}