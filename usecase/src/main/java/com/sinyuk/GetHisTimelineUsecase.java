package com.sinyuk;

import com.sinyuk.entities.Timeline;

import rx.Observable;

/**
 * Created by sinyuk on 2016/12/25.
 */

public class GetHisTimelineUsecase extends Usecase<Timeline>{
    @Override
    protected Observable<Timeline> buildObservable() {
        return null;
    }
}
