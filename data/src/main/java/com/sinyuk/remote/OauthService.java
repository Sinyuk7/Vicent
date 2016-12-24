package com.sinyuk.remote;

import com.sinyuk.entities.AccessToken;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by sinyuk on 2016/12/24.
 */

interface OauthService {
    //oauth2/access_token
    //OAuth2的access_token接口
    @GET("access_token")
    Observable<Response<AccessToken>> access_token(
            @Query("client_id") String client_id,
            @Query("client_secret") String client_secret,
            @Query("grant_type") String grant_type,
            @Query("code") String code,
            @Query("redirect_uri") String redirect_uri);
}
