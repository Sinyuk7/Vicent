package com.sinyuk.vincent.injector.modules;

import com.f2prateek.rx.preferences.RxSharedPreferences;
import com.sinyuk.remote.Endpoint;
import com.sinyuk.remote.OauthManager;
import com.sinyuk.remote.RemoteDataSource;
import com.sinyuk.remote.RemoteRepository;
import com.sinyuk.vincent.Prefs;

import java.io.File;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sinyuk on 2016/12/24.
 */
@Module
public class ApiModule {

    @Provides
    @Singleton
    @Named("token")
    String token(RxSharedPreferences preferences) {
        return preferences.getString(Prefs.KEY_TOKEN).get();
    }

    @Provides
    @Singleton
    @Named("api")
    Endpoint api() {
        return new Endpoint("https://api.weibo.com/2/");
    }


    @Provides
    @Singleton
    RemoteRepository remoteDataSource(Endpoint endpoint, @Named("token") String accessToken, File path) {
        return new RemoteDataSource(endpoint, accessToken, path);
    }

    @Provides
    @Singleton
    @Named("oauth")
    Endpoint oauth() {
        return new Endpoint("https://api.weibo.com/oauth2/");
    }

    @Provides
    @Singleton
    OauthManager oauthManager(@Named("oauth") Endpoint endpoint) {
        return new OauthManager(endpoint);
    }
}
