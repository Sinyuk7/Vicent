package com.sinyuk.vincent.utils.glide;

import com.bumptech.glide.load.engine.Resource;

import pl.droidsonroids.gif.GifDrawable;

class MyDrawableResource implements Resource<GifDrawable> {
    private pl.droidsonroids.gif.GifDrawable drawable;

    MyDrawableResource(pl.droidsonroids.gif.GifDrawable gifDrawable) {
        this.drawable = gifDrawable;
    }

    @Override
    public GifDrawable get() {
        return drawable;
    }

    @Override
    public int getSize() {
        return (int) drawable.getInputSourceByteCount();
    }

    @Override
    public void recycle() {
        drawable.stop();
        drawable.recycle();
    }
}