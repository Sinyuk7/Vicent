package com.sinyuk.vincent.widgets;

import android.content.Context;
import android.util.AttributeSet;

import pl.droidsonroids.gif.GifImageView;

/**
 * Created by sinyuk on 2016/12/24.
 */

public class SquareImageView extends GifImageView{
    public SquareImageView(Context context) {
        super(context);
    }

    public SquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}
