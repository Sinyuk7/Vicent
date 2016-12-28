package com.sinyuk.vincent.injector.modules;

import android.support.annotation.Nullable;

import com.sinyuk.vincent.injector.scopes.ActivityScope;
import com.sinyuk.vincent.ui.player.PlayerContract;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sinyuk on 2016/12/25.
 */
@Module
public class PlayerViewModule {
    private final PlayerContract.View playerView;
    @Named("uid")
    private final long uid;

    @Nullable
    @Named("domain")
    private final String domain;

    public PlayerViewModule(PlayerContract.View playerView, long uid, @Nullable String domain) {
        this.playerView = playerView;
        this.uid = uid;
        this.domain = domain;
    }

    @Provides
    @ActivityScope
    PlayerContract.View playerView() {
        return playerView;
    }


    @Provides
    @ActivityScope
    @Named("uid")
    long uid() {
        return uid;
    }


    @Provides
    @ActivityScope
    @Named("domain")
    @Nullable
    String domain() {
        return domain;
    }

}
