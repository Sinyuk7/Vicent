package com.sinyuk.vincent.injector.modules;

import com.sinyuk.remote.Endpoint;
import com.sinyuk.remote.OauthManager;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sinyuk on 2016/12/24.
 */
@Module
public class OauthModule {
    @Provides
    @Singleton
    @Named("oauth")
    Endpoint endpoint() {
        return new Endpoint("https://api.weibo.com/oauth2/");
    }

    @Provides
    @Singleton
    OauthManager oauthManager(@Named("oauth") Endpoint endpoint) {
        return new OauthManager(endpoint);
    }
}
