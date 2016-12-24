package com.sinyuk.vincent.ui.models;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by sinyuk on 2016/12/22.
 */

public class PhotoViewModel {
    private static final String TAG = "PhotoViewModel";

    @BindingAdapter("photo")
    public static void loadPhoto(ImageView imageView, Photo photo) {
        String url = photo.getImages().get(0).getUrl();
        Glide.with(imageView.getContext())
                .load(url)
                .crossFade(300)
                .into(imageView);
    }
}
