package com.sinyuk;

import com.sinyuk.entities.Timeline;
import com.sinyuk.remote.RemoteRepository;
import com.sinyuk.utils.SchedulerTransformer;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

/**
 * Created by sinyuk on 2016/12/25.
 */

public class GetUserTimelineUsecase extends Usecase<Timeline> {
    private final RemoteRepository mRepository;
    private final SchedulerTransformer<Timeline> mSchedulerTransformer;
    private long uid;
    private String screen_name;
    private int feature = 0;
    private int page = 1;


    @Inject
    GetUserTimelineUsecase(
            RemoteRepository repository,
            @Named("io_main") SchedulerTransformer schedulerTransformer,
            @Named("uid") long uid,
            @Named("screen_name") String screen_name) {
        mRepository = repository;
        mSchedulerTransformer = schedulerTransformer;
        this.uid = uid;
        this.screen_name = screen_name;
    }

    public Observable<Timeline> fetch(final boolean clear) {
        return buildObservable()
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        if (clear) {
                            page = 1;

                        }
                    }
                })
                .doOnNext(new Action1<Timeline>() {
                    @Override
                    public void call(Timeline timeline) {
                        if (timeline.getMaxId() > timeline.getNextCursor()) {
                            page++;
                        }
                    }
                });
    }

    public void setFeature(int feature) {
        this.feature = feature;
    }

    public int getFeature() {
        return feature;
    }

    public long getUid() {
        return uid;
    }

    public String getScreenName() {
        return screen_name;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public void setScreenName(String screen_name) {
        this.screen_name = screen_name;
    }

    @Override
    protected Observable<Timeline> buildObservable() {
        return mRepository.user_timeline(uid, screen_name, page, feature)
                .compose(mSchedulerTransformer);
    }
}
