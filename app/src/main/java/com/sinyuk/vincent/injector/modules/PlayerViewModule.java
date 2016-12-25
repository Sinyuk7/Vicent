package com.sinyuk.vincent.injector.modules;

import com.android.annotations.Nullable;
import com.sinyuk.vincent.injector.scopes.ActivityScope;
import com.sinyuk.vincent.ui.timeline.TimelineContract;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sinyuk on 2016/12/25.
 */
@Module
public class PlayerViewModule {
    private final TimelineContract.View timelineView;
    @Nullable
    @Named("uid")
    private final long uid;
    @Nullable
    @Named("screen_name")
    private final String screenName;

    public PlayerViewModule(TimelineContract.View timelineView, long uid, String screenName) {
        this.timelineView = timelineView;
        this.uid = uid;
        this.screenName = screenName;
    }

    @Provides
    @ActivityScope
    TimelineContract.View timelineView() {
        return timelineView;
    }


    @Provides
    @ActivityScope
    @Named("uid")
    long uid() {
        return uid;
    }


    @Provides
    @ActivityScope
    @Named("screen_name")
    String screenName() {
        return screenName;
    }
}
