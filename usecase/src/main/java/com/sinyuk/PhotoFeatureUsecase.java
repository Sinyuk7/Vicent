package com.sinyuk;

import com.sinyuk.entities.Feature;
import com.sinyuk.remote.Parameters;
import com.sinyuk.remote.RemoteRepository;
import com.sinyuk.utils.SchedulerTransformer;


import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;

/**
 * Created by sinyuk on 2016/12/10.
 */

public class PhotoFeatureUsecase extends Usecase<Feature> implements ListUsecase {

    private final RemoteRepository mRepository;
    private final SchedulerTransformer<Feature> mSchedulerTransformer;
    private String feature = Parameters.Features.POPULAR;
    private int page = 1;

    @Inject
    public PhotoFeatureUsecase(RemoteRepository repository,
                               @Named("io_main") SchedulerTransformer schedulerTransformer) {

        mRepository = repository;
        mSchedulerTransformer = schedulerTransformer;
    }

    @Override
    public Observable<Feature> buildObservable() {
        return mRepository.photoByFeature(feature, page)
                .compose(mSchedulerTransformer);
    }


    public void setFeature( String feature) {
        this.feature = feature;
    }

    @Override
    public void increaseOffset() {
        page++;
    }

    @Override
    public void resetOffset() {
        page = 1;
    }
}
