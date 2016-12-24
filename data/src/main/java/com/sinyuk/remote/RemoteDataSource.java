package com.sinyuk.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sinyuk.entities.Timeline;
import com.sinyuk.utils.ErrorCheckerTransformer;
import com.sinyuk.utils.OauthInterceptor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Named;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by sinyuk on 2016/12/9.
 */

public final class RemoteDataSource implements RemoteRepository {

    private static final long MAX_CACHE = 1024 * 1024 * 100;

    private WeiboService weiboService;

    @Inject
    public RemoteDataSource(@Named("api") Endpoint endpoint,
                            @Named("token") String token,
                            File path) {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.addInterceptor(new OauthInterceptor(token));

        if (path != null) {
            final Cache cache = new Cache(path, MAX_CACHE);
            builder.cache(cache);
        }

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(loggingInterceptor);


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
                .baseUrl(endpoint.getEndpoint())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(builder.build())
                .build();

        weiboService = adapter.create(WeiboService.class);
    }


    @Override
    public Observable<Timeline> friends_timeline(
            @Query("since_id") String sinceId,
            @Query("feature") String feature) {
        return weiboService.friends_timeline(sinceId, feature)
                .compose(new ErrorCheckerTransformer<Response<Timeline>, Timeline>());
    }
}
