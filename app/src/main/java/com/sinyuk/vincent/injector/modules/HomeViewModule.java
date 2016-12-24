package com.sinyuk.vincent.injector.modules;

import com.sinyuk.vincent.ui.timeline.TimelineContract;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sinyuk on 2016/12/20.
 */

/**
 * This is a Dagger module. We use this to pass in the View dependency to the
 * presenter.
 */
@Module
public class HomeViewModule {
    private final TimelineContract.View featureList;

    public HomeViewModule(TimelineContract.View featureList) {
        this.featureList = featureList;
    }

    @Provides
    TimelineContract.View featureList() {
        return featureList;
    }


}
