package com.sinyuk.vincent.widgets;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.sinyuk.vincent.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sinyuk on 2016/12/25.
 */

public class NavLayout extends LinearLayout implements ViewPager.OnPageChangeListener, View.OnClickListener {
    public static final String TAG = "NavLayout";
    private static final float INACTIVE_ALPHA = 0.75f;

    private ImageView tab1;
    private ImageView tab2;
    private ImageView tab3;
    private ImageView tab4;
    private ViewPager mViewPager;

    private List<View> tabList = new ArrayList<>();
    private float lastOffset = 0;

    public NavLayout(Context context) {
        super(context);
    }

    public NavLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NavLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        tab1 = (ImageView) findViewById(R.id.icon1);
        tab2 = (ImageView) findViewById(R.id.icon2);
        tab3 = (ImageView) findViewById(R.id.icon3);
        tab4 = (ImageView) findViewById(R.id.icon4);

        tabList.add(tab1);
        tabList.add(tab2);
        tabList.add(tab3);
        tabList.add(tab4);

        setListeners();
        resetAlpha();
    }

    private void setListeners() {
        for (int i = 0; i < tabList.size(); i++) {
            tabList.get(i).setOnClickListener(this);
        }
    }

    private void resetAlpha() {
        for (int i = 0; i < tabList.size(); i++) {
            tabList.get(i).setAlpha(INACTIVE_ALPHA);
        }
    }

    public void attachViewpager(@NotNull ViewPager viewPager) {
        this.mViewPager = viewPager;
        viewPager.addOnPageChangeListener(this);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

//        if (lastOffset < positionOffset) {
//            // ++ 向右 0 -> 1
//            float fraction = positionOffset * positionOffset * positionOffset;
//            if (position >= 0
//                    && position < tabList.size()
//                    && tabList.get(position) != null) {
//                tabList.get(position)
//                        .setAlpha(1 - fraction * (1 - INACTIVE_ALPHA));
//            }
//
//            if (position + 1 >= 0
//                    && position + 1 < tabList.size()
//                    && tabList.get(position + 1) != null) {
//                tabList.get(position + 1)
//                        .setAlpha(INACTIVE_ALPHA + fraction * (1 - INACTIVE_ALPHA));
//            }
//
//        } else {
//            // -- 向左 1 -> 0
//            float fraction = (float) Math.sqrt(positionOffset);
//
//            if (position >= 0
//                    && position < tabList.size()
//                    && tabList.get(position) != null) {
//                tabList.get(position)
//                        .setAlpha(INACTIVE_ALPHA + fraction * (1 - INACTIVE_ALPHA));
//            }
//
//            if (position - 1 >= 0
//                    && position - 1 < tabList.size()
//                    && tabList.get(position - 1) != null) {
//                tabList.get(position - 1)
//                        .setAlpha(1 - fraction * (1 - INACTIVE_ALPHA));
//            }
//        }
//
//        Log.d(TAG, "onPageScrolled: position" + position);
//        Log.d(TAG, "onPageScrolled: offset" + positionOffset);
//        lastOffset = positionOffset;
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if (state == ViewPager.SCROLL_STATE_IDLE) {
            toggleSelected(mViewPager.getCurrentItem());
        }
    }

    private void toggleSelected(int currentItem) {
        for (int i = 0; i < tabList.size(); i++) {
            if (tabList.get(i) != null) {
                if (i == currentItem) {
                    tabList.get(i).setAlpha(1f);
                } else {
                    tabList.get(i).setAlpha(INACTIVE_ALPHA);
                }
            }
        }
    }


    public void setSelectedItem(int index) {
        if (tabList == null) return;
        if (index >= 0 && index < tabList.size()) {
            if (tabList.get(index) != null) {
                tabList.get(index).setAlpha(1f);
            }
        }
    }

    @Override
    public void onClick(View view) {
        if (mViewPager == null) {
            return;
        }

        if (mViewPager.getAdapter().getCount() != 4) {
            return;
        }

        final int current = mViewPager.getCurrentItem();
        boolean scrolled;
        switch (view.getId()) {
            case R.id.icon1:
                scrolled = Math.abs(current) == 1;
                mViewPager.setCurrentItem(0, scrolled);
                if (!scrolled) {
                    toggleSelected(0);
                }
                break;
            case R.id.icon2:
                scrolled = Math.abs(current - 1) == 1;
                mViewPager.setCurrentItem(1, scrolled);
                if (!scrolled) {
                    toggleSelected(1);
                }
                break;
            case R.id.icon3:
                scrolled = Math.abs(current - 2) == 1;
                mViewPager.setCurrentItem(2, scrolled);
                if (!scrolled) {
                    toggleSelected(2);
                }
                break;
            case R.id.icon4:
                scrolled = Math.abs(current - 3) == 1;
                mViewPager.setCurrentItem(3, scrolled);
                if (!scrolled) {
                    toggleSelected(3);
                }
                break;
        }
    }
}
