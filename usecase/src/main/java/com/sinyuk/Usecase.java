package com.sinyuk;

import rx.Observable;

/**
 * Created by sinyuk on 2016/12/10.
 */

public abstract class Usecase<T> {
    public abstract Observable<T> buildObservable();

    public Observable<T> execute() {
        return buildObservable();
    }
}
