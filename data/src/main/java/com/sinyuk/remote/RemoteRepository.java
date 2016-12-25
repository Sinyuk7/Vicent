package com.sinyuk.remote;

import com.sinyuk.entities.Timeline;

import rx.Observable;

/**
 * Created by sinyuk on 2016/12/9.
 */

public interface RemoteRepository {
    //    statuses/friends_timeline
    //    获取当前登录用户及其所关注（授权）用户的最新微博
    Observable<Timeline> friends_timeline(
            int page,
            int feature);

    //    statuses/user_timeline
    //    获取某个用户最新发表的微博列表
    Observable<Timeline> user_timeline(
            long uid,
            int page,
            int feature);

    //    statuses/home_timeline
//    获取当前登录用户及其所关注（授权）用户的最新微博

    Observable<Timeline> home_timeline(
            int page,
            int feature);

    //    statuses/public_timeline
    //            返回最新的公共微博

    Observable<Timeline> public_timeline(int page);
}
