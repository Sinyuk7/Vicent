package com.sinyuk.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sinyuk.entities.AccessToken;
import com.sinyuk.utils.ErrorCheckerTransformer;

import javax.inject.Inject;
import javax.inject.Named;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by sinyuk on 2016/12/24.
 */

public class OauthManager {
    private final OauthService oauthService;

    @Inject
    public OauthManager(@Named("oauth") Endpoint endpoint) {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


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

        oauthService = adapter.create(OauthService.class);
    }

    public Observable<AccessToken> access_token(String client_id,
                                                String client_secret,
                                                String grant_type,
                                                String code,
                                                String redirect_uri) {
        return oauthService.access_token(
                client_id,
                client_secret,
                grant_type,
                code,
                redirect_uri)
                .compose(new ErrorCheckerTransformer<Response<AccessToken>, AccessToken>());
    }
}
