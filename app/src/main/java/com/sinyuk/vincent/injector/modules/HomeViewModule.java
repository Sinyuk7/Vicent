package com.sinyuk.vincent.injector.modules;

import com.sinyuk.vincent.injector.scopes.ActivityScope;
import com.sinyuk.vincent.ui.timeline.TimelineContract;

import org.jetbrains.annotations.NotNull;

import javax.inject.Named;

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
    private final TimelineContract.View timelineView;

    @Named("uid")
    private final long uid;
    @Named("timeline_type")
    @NotNull
    private final String timeline_type;

    public HomeViewModule(TimelineContract.View timelineView,
                          @NotNull String timeline_type,
                          long uid
    ) {
        this.timelineView = timelineView;
        this.uid = uid;
        this.timeline_type = timeline_type;
    }


    @Provides
    @ActivityScope
    TimelineContract.View view() {
        return timelineView;
    }

    @Provides
    @Named("uid")
    @ActivityScope
    long uid() {
        return uid;
    }

    @Provides
    @Named("timeline_type")
    @ActivityScope
    String timeline_type() {
        return timeline_type;
    }


}
