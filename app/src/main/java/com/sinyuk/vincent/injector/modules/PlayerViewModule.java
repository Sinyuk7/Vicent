package com.sinyuk.vincent.injector.modules;

import android.support.annotation.Nullable;

import com.sinyuk.vincent.injector.scopes.ActivityScope;
import com.sinyuk.vincent.ui.timeline.TimelineContract;

import org.jetbrains.annotations.NotNull;

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
    @Named("timeline_type")
    @NotNull
    private final String timeline_type;


    public PlayerViewModule(TimelineContract.View timelineView,
                            @NotNull String timeline_type,
                            long uid) {
        this.timelineView = timelineView;
        this.uid = uid;
        this.timeline_type = timeline_type;

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
    @Named("timeline_type")
    @ActivityScope
    String timeline_type() {
        return timeline_type;
    }
}
