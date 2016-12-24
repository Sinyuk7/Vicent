package com.sinyuk;

import com.sinyuk.entities.Status;
import com.sinyuk.entities.Timeline;
import com.sinyuk.remote.RemoteRepository;
import com.sinyuk.utils.SchedulerTransformer;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by sinyuk on 2016/12/10.
 */

public class GetTimelineUsecase extends Usecase<Timeline> {

    private final RemoteRepository mRepository;
    private final SchedulerTransformer<Timeline> mSchedulerTransformer;
    private String feature;
    private int page = 0;

    @Inject
    GetTimelineUsecase(RemoteRepository repository,
                       @Named("io_main") SchedulerTransformer schedulerTransformer) {
        mRepository = repository;
        mSchedulerTransformer = schedulerTransformer;
    }

    public Observable<List<Status>> fetch(final boolean clear) {
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
                        if (timeline.getMaxId() != timeline.getNextCursor()) {
                            page++;
                        }
                    }
                })
                .flatMap(new Func1<Timeline, Observable<List<Status>>>() {
                    @Override
                    public Observable<List<Status>> call(Timeline timeline) {
                        return Observable.just(timeline.getStatuses());
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
