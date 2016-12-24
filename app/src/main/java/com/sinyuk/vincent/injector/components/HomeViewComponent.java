package com.sinyuk.vincent.injector.components;

import com.sinyuk.vincent.injector.modules.HomeViewModule;
import com.sinyuk.vincent.injector.scopes.ActivityScope;
import com.sinyuk.vincent.ui.home.HomeView;

import dagger.Subcomponent;

/**
 * Created by sinyuk on 2016/12/21.
 */
@ActivityScope
@Subcomponent(modules = HomeViewModule.class)
public interface HomeViewComponent {
    void inject(HomeView homeView);
}
