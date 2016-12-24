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

public class TimelineUsecase extends Usecase<Timeline> {

    private final RemoteRepository mRepository;
    private final SchedulerTransformer<Timeline> mSchedulerTransformer;
    private final ListCallback callback;
    private String feature;
    private int page = 0;

    @Inject
    TimelineUsecase(RemoteRepository repository,
                    @Named("io_main") SchedulerTransformer schedulerTransformer,
                    ListCallback callback) {
        mRepository = repository;
        mSchedulerTransformer = schedulerTransformer;
        this.callback = callback;
        if (callback == null) {
            throw new IllegalArgumentException("list callback can't be null !");
        }
    }


    public Observable<Timeline> load(final boolean clear) {
        return buildObservable()
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        if (clear) {
                            page = 1;
                            callback.startRefreshing();
                        } else {
                            callback.startLoading();
                        }
                    }
                })
                .doOnNext(new Action1<Timeline>() {
                    @Override
                    public void call(Timeline timeline) {
                        if (timeline.getTotalNumber() == 0) {
                            callback.empty();
                        } else {
                            if (timeline.getMaxId() == timeline.getNextCursor()) {
                                callback.nomore();
                            } else {
                                page++;
                            }
                        }
                    }
                })
                .doOnTerminate(new Action0() {
                    @Override
                    public void call() {
                        if (clear) {
                            callback.stopRefreshing();
                        } else {
                            callback.stopLoading();
                        }
                    }
                });
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getFeature() {
        return feature;
    }


    @Override
    protected Observable<Timeline> buildObservable() {
        return mRepository.friends_timeline(page, feature)
                .compose(mSchedulerTransformer);
    }
}
