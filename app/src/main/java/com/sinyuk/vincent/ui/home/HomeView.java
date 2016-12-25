package com.sinyuk.vincent.ui.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import com.sinyuk.vincent.BlankFragment;
import com.sinyuk.vincent.R;
import com.sinyuk.vincent.VincentApplication;
import com.sinyuk.vincent.base.BaseActivity;
import com.sinyuk.vincent.databinding.HomeViewBinding;
import com.sinyuk.vincent.injector.modules.HomeViewModule;
import com.sinyuk.vincent.ui.timeline.TimelinePresenter;
import com.sinyuk.vincent.ui.timeline.TimelineView;

import javax.inject.Inject;

/**
 * Created by sinyuk on 2016/12/20.
 */

public class HomeView extends BaseActivity {

    private HomeViewBinding binding;

    @Inject
    TimelinePresenter timelinePresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.home_view);


        initVP();
        initNav();
    }

    private void initVP() {
        TimelineView homeTimeLine = new TimelineView();
        VincentApplication.get(this).getAppComponent()
                .plus(new HomeViewModule(homeTimeLine, "home", 0))
                .inject(this);

        BlankFragment exploreView = new BlankFragment();
        BlankFragment messageView = new BlankFragment();
        BlankFragment profileView = new BlankFragment();

        binding.viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return homeTimeLine;
                    case 1:
                        return exploreView;
                    case 2:
                        return messageView;
                    case 3:
                        return profileView;
                    default:
                        return null;
                }
            }

            @Override
            public int getCount() {
                return 4;
            }
        });

        binding.viewPager.setOffscreenPageLimit(3);
    }

    private void initNav() {
        binding.navLayout.attachViewpager(binding.viewPager);
        binding.navLayout.setSelectedItem(0);
    }
}
