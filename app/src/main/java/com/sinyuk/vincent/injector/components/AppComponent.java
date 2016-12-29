package com.sinyuk.vincent.injector.components;

import com.sinyuk.vincent.injector.modules.ApiModule;
import com.sinyuk.vincent.injector.modules.AppModule;
import com.sinyuk.vincent.injector.modules.CommentViewModule;
import com.sinyuk.vincent.injector.modules.HomeViewModule;
import com.sinyuk.vincent.injector.modules.PlayerViewModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by sinyuk on 2016/12/20.
 */
@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface AppComponent {
    //    VincentApplication application();
//
//    @Named("computation")
//    Scheduler computation();
//
//    @Named("main")
//    Scheduler mainThread();
//
//    @Named("io")
//    Scheduler io();
//
//    @Named("io_main")
//    SchedulerTransformer io_main();
//
//    SharedPreferences sharedPreferences();
//
//    RxSharedPreferences rxSharedPreferences();
//
//    File cache();
    HomeViewComponent plus(HomeViewModule module);

    PlayerViewComponent plus(PlayerViewModule module);

    CommentViewComponent plus(CommentViewModule module);
}
