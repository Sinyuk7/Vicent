package com.sinyuk.vicent.injector.components;

import com.sinyuk.vicent.injector.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by sinyuk on 2016/12/20.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

}
