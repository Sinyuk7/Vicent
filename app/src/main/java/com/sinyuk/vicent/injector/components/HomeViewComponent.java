package com.sinyuk.vicent.injector.components;

import com.sinyuk.vicent.injector.modules.HomeViewModule;
import com.sinyuk.vicent.injector.scopes.FragmentScoped;

import dagger.Component;

/**
 * Created by sinyuk on 2016/12/21.
 */
@FragmentScoped
@Component(dependencies = AppComponent.class, modules = HomeViewModule.class)
public interface HomeViewComponent {

}