package com.sinyuk.vincent.injector.components;

import com.sinyuk.vincent.injector.modules.ApiModule;

import javax.inject.Singleton;

import dagger.Subcomponent;

/**
 * Created by sinyuk on 2016/12/24.
 */
@Singleton
@Subcomponent(modules = ApiModule.class)
interface ApiComponent {

}
