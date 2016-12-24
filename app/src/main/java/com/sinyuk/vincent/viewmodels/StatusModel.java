package com.sinyuk.vincent.viewmodels;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by sinyuk on 2016/12/24.
 */

public class StatusModel {
    @BindingAdapter("status_avatar")
    public static void loadAvatar(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .centerCrop()
                .into(imageView);
    }

    @BindingAdapter("url")
    public static void loadPhoto(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .centerCrop()
                .into(imageView);
    }

    public static String getPicUrl(String thumbnailPic, int spanCount) {
        String type = "bmiddle";
        switch (spanCount) {
            case 1:
                type = "large";
                break;
        }
        if (thumbnailPic.contains("thumbnail")) {
            return thumbnailPic.replace("thumbnail", type);
        }
        return thumbnailPic;
    }
}
