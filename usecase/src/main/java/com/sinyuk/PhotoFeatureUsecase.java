package com.sinyuk;

import com.sinyuk.entities.Feature;
import com.sinyuk.remote.Parameters;
import com.sinyuk.remote.RemoteRepository;
import com.sinyuk.utils.SchedulerTransformer;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by sinyuk on 2016/12/10.
 */

public class PhotoFeatureUsecase extends Usecase<Feature> {

    private final RemoteRepository mRepository;
    private final SchedulerTransformer mSchedulerTransformer;
    private String feature = Parameters.Features.POPULAR;
    private int page = 1;

    @Inject
    public PhotoFeatureUsecase(RemoteRepository repository,
                               SchedulerTransformer schedulerTransformer) {

        mRepository = repository;
        mSchedulerTransformer = schedulerTransformer;
    }

    @Override
    public Observable<Feature> buildObservable() {
        return mRepository.photoByFeature();
    }
}
