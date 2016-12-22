package com.sinyuk;

import rx.Observable;

/**
 * Created by sinyuk on 2016/12/10.
 */

public abstract class Usecase<T> {
    protected abstract Observable<T> buildObservable();
}
