package com.sinyuk.vincent.injector.components;

import com.sinyuk.vincent.injector.modules.HomeViewModule;
import com.sinyuk.vincent.injector.scopes.FragmentScoped;
import com.sinyuk.vincent.ui.home.HomeView;

import dagger.Component;

/**
 * Created by sinyuk on 2016/12/21.
 */
@FragmentScoped
@Component(dependencies = AppComponent.class, modules = HomeViewModule.class)
public interface HomeViewComponent {

    void inject(HomeView homeView);
}
