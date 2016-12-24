package com.sinyuk;

import com.sinyuk.entities.Status;
import com.sinyuk.remote.RemoteRepository;
import com.sinyuk.utils.SchedulerTransformer;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;

/**
 * Created by sinyuk on 2016/12/10.
 */

public class PhotoFeatureUsecase extends Usecase<List<Status>> implements ListUsecase {

    private final RemoteRepository mRepository;
    private final SchedulerTransformer<List<Status>> mSchedulerTransformer;
    private String feature;
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


    public Observable<List<Status>> load(final boolean clear) {
        return buildObservable();
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
    protected Observable<List<Status>> buildObservable() {
        return null;
    }
}
