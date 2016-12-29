package com.sinyuk.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sinyuk.entities.Comments;
import com.sinyuk.entities.Timeline;
import com.sinyuk.entities.User;
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
import rx.Observable;

/**
 * Created by sinyuk on 2016/12/9.
 */

public final class RemoteDataSource implements RemoteRepository {

    private static final long MAX_CACHE = 1024 * 1024 * 100;

    private WeiboService weiboService;

    @Inject
    public RemoteDataSource(@Named("api") Endpoint endpoint,
                            @Named("token") String accessToken,
                            File path) {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.addInterceptor(new OauthInterceptor(accessToken));

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
    public Observable<Timeline> friends_timeline(int page, int feature) {
        return weiboService.friends_timeline(page, feature)
                .compose(new ErrorCheckerTransformer<Response<Timeline>, Timeline>());
    }

    @Override
    public Observable<Timeline> user_timeline(long uid, int page, int feature) {
        return weiboService.user_timeline(uid, page, feature)
                .compose(new ErrorCheckerTransformer<Response<Timeline>, Timeline>());
    }

    @Override
    public Observable<Timeline> home_timeline(int page, int feature) {
        return weiboService.home_timeline(page, feature)
                .compose(new ErrorCheckerTransformer<Response<Timeline>, Timeline>());
    }

    @Override
    public Observable<Timeline> public_timeline(int page) {
        return weiboService.public_timeline(page)
                .compose(new ErrorCheckerTransformer<Response<Timeline>, Timeline>());
    }

    @Override
    public Observable<User> users_show(long uid) {
        return weiboService.users_show(uid)
                .compose(new ErrorCheckerTransformer<Response<User>, User>());
    }

    @Override
    public Observable<User> domain_show(String domain) {
        return weiboService.domain_show(domain)
                .compose(new ErrorCheckerTransformer<Response<User>, User>());
    }

    @Override
    public Observable<Comments> comment_show(long id, int page) {
        return weiboService.comment_show(id, page)
                .compose(new ErrorCheckerTransformer<Response<Comments>, Comments>());
    }

    @Override
    public Observable<Comments> comment_timeline(int page) {
        return weiboService.comment_timeline(page)
                .compose(new ErrorCheckerTransformer<Response<Comments>, Comments>());
    }
}
