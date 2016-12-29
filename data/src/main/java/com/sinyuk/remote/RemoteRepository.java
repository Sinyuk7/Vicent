package com.sinyuk.remote;

import com.sinyuk.entities.Comment;
import com.sinyuk.entities.Timeline;
import com.sinyuk.entities.User;

import java.util.List;

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


    Observable<User> users_show(long uid);

    Observable<User> domain_show(String domain);


    //    comments/comment_show
    //    根据微博ID返回某条微博的评论列表
    Observable<List<Comment>> comment_show(long id, int page);

    //    comments/comment_timeline
    //    获取当前登录用户的最新评论包括接收到的与发出的
    Observable<List<Comment>> comment_timeline(int page);
}
