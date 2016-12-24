package com.sinyuk.vincent.injector.modules;

import android.content.SharedPreferences;

import com.f2prateek.rx.preferences.RxSharedPreferences;
import com.sinyuk.utils.SchedulerTransformer;
import com.sinyuk.vincent.VincentApplication;

import java.io.File;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by sinyuk on 2016/12/20.
 */

@Module
public class AppModule {
    private final VincentApplication application;

    public AppModule(VincentApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    VincentApplication application() {
        return application;
    }

    @Provides
    @Singleton
    @Named("computation")
    Scheduler computation() {
        return Schedulers.computation();
    }


    @Provides
    @Singleton
    @Named("main")
    Scheduler mainThread() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @Singleton
    @Named("io")
    Scheduler io() {
        return Schedulers.io();
    }


    @Provides
    @Singleton
    @Named("io_main")
    SchedulerTransformer io_main(@Named("io") Scheduler io, @Named("main") Scheduler main) {
        return new SchedulerTransformer(io, main);
    }

    @Provides
    @Singleton
    SharedPreferences sharedPreferences() {
        return application.getSharedPreferences("Vincent", MODE_PRIVATE);
    }

    @Provides
    @Singleton
    RxSharedPreferences rxSharedPreferences(SharedPreferences preferences) {
        return RxSharedPreferences.create(preferences);
    }

    @Provides
    @Singleton
    File cache() {
        return new File(application.getExternalCacheDir(), "cache");
    }


}
