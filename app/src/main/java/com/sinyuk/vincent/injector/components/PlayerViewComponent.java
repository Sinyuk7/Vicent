package com.sinyuk.vincent.injector.components;

import com.sinyuk.vincent.injector.modules.PlayerViewModule;
import com.sinyuk.vincent.injector.scopes.ActivityScope;
import com.sinyuk.vincent.ui.player.PlayerView;

import dagger.Subcomponent;

/**
 * Created by sinyuk on 2016/12/25.
 */
@ActivityScope
@Subcomponent(modules = PlayerViewModule.class)
public interface PlayerViewComponent {
    void inject(PlayerView playerView);
}
