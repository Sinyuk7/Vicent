package com.sinyuk.vicent.injector.modules;

import com.sinyuk.vicent.ui.home.FeatureListContract;

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
    private final FeatureListContract.View featureList;

    public HomeViewModule(FeatureListContract.View featureList) {
        this.featureList = featureList;
    }

    @Provides
    FeatureListContract.View featureList() {
        return featureList;
    }


}
