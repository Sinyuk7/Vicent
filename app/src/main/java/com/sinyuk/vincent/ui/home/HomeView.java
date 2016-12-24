package com.sinyuk.vincent.ui.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.sinyuk.myutils.android.ActivityUtils;
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

        TimelineView timelineView = (TimelineView) getSupportFragmentManager().findFragmentById(R.id.timeline_fragment);

        if (timelineView == null) {
            timelineView = new TimelineView();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), timelineView, R.id.timeline_fragment);
        }

        VincentApplication.get(this).getAppComponent()
                .plus(new HomeViewModule(timelineView)).inject(this);

    }
}
