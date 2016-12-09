package com.sinyuk.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

/**
 * Created by sinyuk on 2016/12/9.
 */

public final class RemoteDataSource {
    private final static String END_POINT = "https://api.500px.com/v1/";
    private static final long MAX_CACHE = 1024 * 1024 * 100;

    private PxService pxService;

    @Inject
    public RemoteDataSource(SigningInterceptor signingInterceptor, File path) {
        Cache cache = new Cache(path, MAX_CACHE);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();


        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(loggingInterceptor);

        builder.addInterceptor(signingInterceptor);

        //设置超时
        builder.connectTimeout(30, TimeUnit.SECONDS);
        builder.readTimeout(30, TimeUnit.SECONDS);
        builder.writeTimeout(30, TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);


        final Gson gson = new GsonBuilder()
                // Blank fields are included as null instead of being omitted.
                .serializeNulls()
                .create();


        final Retrofit adapter = new Retrofit.Builder()
                .baseUrl(END_POINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(builder.build())
                .build();

        pxService = adapter.create(PxService.class);
    }
}