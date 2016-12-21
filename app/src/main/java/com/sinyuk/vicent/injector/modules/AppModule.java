package com.sinyuk.vicent.injector.modules;

import com.sinyuk.remote.Endpoint;
import com.sinyuk.remote.RemoteDataSource;
import com.sinyuk.remote.RemoteRepository;
import com.sinyuk.utils.SchedulerTransformer;
import com.sinyuk.vicent.BuildConfig;
import com.sinyuk.vicent.VincentApplication;

import java.io.File;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

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

    //    Endpoint endpoint, SigningInterceptor signingInterceptor, File path
    @Provides
    @Singleton
    Endpoint endpoint() {
        return new Endpoint("https://api.500px.com/v1/");
    }

    @Provides
    @Singleton
    SigningInterceptor signingInterceptor() {
        return new SigningInterceptor(new OkHttpOAuthConsumer(BuildConfig.CONSUMER_KEY, BuildConfig.CONSUMER_SECRET));
    }

    @Provides
    @Singleton
    File cache() {
        return new File("");
    }

    @Provides
    @Singleton
    RemoteRepository remoteDataSource(Endpoint endpoint, SigningInterceptor signingInterceptor, File path) {
        return new RemoteDataSource(endpoint, signingInterceptor, path);
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

}
