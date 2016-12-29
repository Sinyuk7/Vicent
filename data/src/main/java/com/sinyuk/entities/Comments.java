package com.sinyuk.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by sinyuk on 2016/12/29.
 */

public class Comments {
    @SerializedName("comments")
    private List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
