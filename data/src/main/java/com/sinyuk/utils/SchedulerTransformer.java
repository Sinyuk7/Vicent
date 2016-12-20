package com.sinyuk.utils;

import rx.Scheduler;
import rx.Observable;


public final class SchedulerTransformer<T> implements Observable.Transformer<T, T> {
    private final Scheduler subscribeScheduler;
    private final Scheduler observeScheduler;

    public SchedulerTransformer(Scheduler s1, Scheduler s2) {
        this.subscribeScheduler = s1;
        this.observeScheduler = s2;
    }

    @Override
    public Observable<T> call(Observable<T> observable) {
        return observable
                .subscribeOn(subscribeScheduler)
                .observeOn(observeScheduler);
    }
}