package com.sinyuk;

import com.sinyuk.entities.Feature;
import com.sinyuk.remote.Parameters;
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

public class PhotoFeatureUsecase extends Usecase<Feature> implements ListUsecase {

    private final RemoteRepository mRepository;
    private final SchedulerTransformer<Feature> mSchedulerTransformer;
    private String feature = Parameters.Features.POPULAR;
    private String categories;
    private String direction;


    private String sort;
    private int page = 1;

    @Inject
    public PhotoFeatureUsecase(RemoteRepository repository,
                               @Named("io_main") SchedulerTransformer schedulerTransformer) {

        mRepository = repository;
        mSchedulerTransformer = schedulerTransformer;
    }


    public Observable<Feature> load(final boolean clear) {
        return buildObservable()
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        if (clear) {
                            resetOffset();
                        }
                    }
                })
                .doOnNext(new Action1<Feature>() {
                    @Override
                    public void call(Feature feature) {
                        if (feature != null) {
                            increaseOffset();
                        }
                    }
                })
                .doOnError(new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getFeature() {
        return feature;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }


    @Override
    public void increaseOffset() {
        page++;
    }

    @Override
    public void resetOffset() {
        page = 1;
    }

    @Override
    protected Observable<Feature> buildObservable() {
        return mRepository.photoByFeature(feature, categories, sort, direction, page)
                .compose(mSchedulerTransformer);
    }
}
