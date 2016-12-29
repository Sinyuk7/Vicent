package com.sinyuk.remote;

import com.sinyuk.entities.Comments;
import com.sinyuk.entities.Timeline;
import com.sinyuk.entities.User;

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
    @GET("statuses/user_timeline.json")
    Observable<Response<Timeline>> user_timeline(
            @Query("uid") long uid,
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

    //    users/comment_show
    //    根据用户ID获取用户信息

    @GET("users/comment_show.json")
    Observable<Response<User>> users_show(
            @Query("uid") long uid);

    //    users/domain_show
//   通过个性化域名获取用户资料以及用户最新的一条微博
    @GET("users/domain_show.json")
    Observable<Response<User>> domain_show(
            @Query("domain") String domain);

    //    comments/comment_show
    //    根据微博ID返回某条微博的评论列表
    @GET("comments/show.json")
    Observable<Response<Comments>> comment_show(
            @Query("id") long id,
            @Query("page") int page);

    //    comments/comment_timeline
    //    获取当前登录用户的最新评论包括接收到的与发出的
    @GET("comments/timeline.json")
    Observable<Response<Comments>> comment_timeline(
            @Query("page") int page);
}
