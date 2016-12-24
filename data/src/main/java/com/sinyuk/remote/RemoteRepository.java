package com.sinyuk.remote;

import com.sinyuk.entities.Timeline;

import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by sinyuk on 2016/12/9.
 */

public interface RemoteRepository {
    //    statuses/friends_timeline
//    获取当前登录用户及其所关注（授权）用户的最新微博
    Observable<Timeline> friends_timeline(
            @Query("page") int page,
            @Query("feature") String feature);
}
