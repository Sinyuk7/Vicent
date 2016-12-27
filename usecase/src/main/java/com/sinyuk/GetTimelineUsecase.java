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
 * Created by sinyuk on 2016/12/10.
 */

public class GetTimelineUsecase extends Usecase<Timeline> {

    private final RemoteRepository mRepository;
    private final SchedulerTransformer<Timeline> mSchedulerTransformer;
    private int feature = 0;
    private int page = 1;
    @Named("uid")
    private long uid;
    @Named("timeline_type")
    private String timeline_type;

    @Inject
    GetTimelineUsecase(RemoteRepository repository,
                       @Named("io_main") SchedulerTransformer schedulerTransformer,
                       @Named("timeline_type") String timeline_type,
                       @Named("uid") long uid) {
        mRepository = repository;
        mSchedulerTransformer = schedulerTransformer;
        this.uid = uid;
        this.timeline_type = timeline_type;
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
                        if (0 != timeline.getNextCursor()) {
                            ++page;
                        }
                        System.out.println("NextCursor: " + timeline.getNextCursor());
                        System.out.println("page: " + page);

                    }
                });
    }

    public void setFeature(int feature) {
        this.feature = feature;
    }

    public int getFeature() {
        return feature;
    }

    public int getPage() {
        return page;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getTimelineType() {
        return timeline_type;
    }

    public void setTimelineType(String timeline_type) {
        this.timeline_type = timeline_type;
    }

    @Override
    protected Observable<Timeline> buildObservable() {
        switch (timeline_type) {
            case "home":
                return mRepository.home_timeline(page, feature)
                        .compose(mSchedulerTransformer);
            case "friends":
                return mRepository.friends_timeline(page, feature)
                        .compose(mSchedulerTransformer);
            case "public":
                return mRepository.public_timeline(page)
                        .compose(mSchedulerTransformer);
            case "user":
                return mRepository.user_timeline(uid, page, feature)
                        .compose(mSchedulerTransformer);
            default:
                return Observable.error(new Throwable("timeline type can't be null!"));
        }

    }
}
