package com.sinyuk.remote;

import com.sinyuk.entities.Timeline;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by sinyuk on 2016/12/9.
 */

public interface WeiboService {

    //    statuses/friends_timeline
    //    获取当前登录用户及其所关注（授权）用户的最新微博
    @GET("statuses/friends_timeline.json")
    Observable<Response<Timeline>> friends_timeline(
            @Query("page") int page,
            @Query("feature") int feature);


    //    statuses/user_timeline
    //    获取某个用户最新发表的微博列表
    @GET("statuses/user_timeline.json?trim_user=1")
    Observable<Response<Timeline>> user_timeline(
            @Query("uid") long uid,
            @Query("screen_name") String screen_name,
            @Query("page") int page,
            @Query("feature") int feature);

//    statuses/home_timeline
//    获取当前登录用户及其所关注（授权）用户的最新微博

    @GET("statuses/home_timeline.json")
    Observable<Response<Timeline>> home_timeline(
            @Query("page") int page,
            @Query("feature") int feature);

    //    statuses/public_timeline
    //            返回最新的公共微博
    @GET("statuses/public_timeline.json")
    Observable<Response<Timeline>> public_timeline(
            @Query("page") int page);
}
