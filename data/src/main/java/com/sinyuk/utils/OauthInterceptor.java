package com.sinyuk.utils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by sinyuk on 2016/12/24.
 */

public class OauthInterceptor implements Interceptor {
    private final String token;

    public OauthInterceptor(String token) {
        this.token = token;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();

        builder.addHeader("Authorization", String.format("OAuth2 %s", token));

        return chain.proceed(builder.build());
    }
}
