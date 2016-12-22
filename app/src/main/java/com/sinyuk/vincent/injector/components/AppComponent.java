package com.sinyuk.vincent.injector.components;

import com.sinyuk.remote.Endpoint;
import com.sinyuk.remote.RemoteRepository;
import com.sinyuk.utils.SchedulerTransformer;
import com.sinyuk.vincent.VincentApplication;
import com.sinyuk.vincent.injector.modules.AppModule;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;
import rx.Scheduler;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

/**
 * Created by sinyuk on 2016/12/20.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    VincentApplication application();

    Endpoint endpoint();

    SigningInterceptor signingInterceptor();

    RemoteRepository repository();


    @Named("computation")
    Scheduler computation();

    @Named("main")
    Scheduler mainThread();

    @Named("io")
    Scheduler io();


    @Named("io_main")
    SchedulerTransformer io_main();

}
