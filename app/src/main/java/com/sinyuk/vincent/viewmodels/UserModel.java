package com.sinyuk.vincent.viewmodels;

import android.databinding.BindingAdapter;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;

/**
 * Created by sinyuk on 2016/12/28.
 */

public class UserModel {
    @BindingAdapter("player_avatar")
    public static void loadAvatar(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .priority(Priority.IMMEDIATE)
                .crossFade(150)
                .into(imageView);
    }


    @BindingAdapter({"player_cover", "player_cover_phone"})
    public static void loadCover(ImageView imageView, String player_cover, String player_cover_phone) {
        String url = player_cover;
        if (TextUtils.isEmpty(player_cover))
            url = player_cover_phone;

        Glide.with(imageView.getContext())
                .load(url)
                .crossFade(300)
                .priority(Priority.HIGH)
                .into(imageView);
    }
}
