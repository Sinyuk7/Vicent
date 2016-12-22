package com.sinyuk.remote;

import com.sinyuk.entities.Feature;

import rx.Observable;

/**
 * Created by sinyuk on 2016/12/9.
 */

public interface RemoteRepository {
    Observable<Feature> photoByFeature(String feature,
                                       String categories,
                                       String sort,
                                       String sort_direction,
                                       int page);
}
