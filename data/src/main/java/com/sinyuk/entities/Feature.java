package com.sinyuk.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sinyuk on 2016/12/9.
 */

public final class Feature {

    @SerializedName("feature")
    private String feature;
    @SerializedName("filters")
    private Filters filters;
    @SerializedName("current_page")
    private int currentPage;
    @SerializedName("total_pages")
    private int totalPages;
    @SerializedName("total_items")
    private int totalItems;
    @SerializedName("photos")
    private List<Photo> photos;

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public Filters getFilters() {
        return filters;
    }

    public void setFilters(Filters filters) {
        this.filters = filters;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public static class Filters {
        /**
         * category : false
         * exclude : false
         */

        @SerializedName("category")
        private boolean category;
        @SerializedName("exclude")
        private boolean exclude;

        public boolean isCategory() {
            return category;
        }

        public void setCategory(boolean category) {
            this.category = category;
        }

        public boolean isExclude() {
            return exclude;
        }

        public void setExclude(boolean exclude) {
            this.exclude = exclude;
        }
    }
}
