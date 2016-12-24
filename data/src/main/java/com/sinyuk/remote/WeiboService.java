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
            @Query("since_id") String sinceId,
            @Query("feature") String feature);
}
