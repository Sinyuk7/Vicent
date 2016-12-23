package com.sinyuk.vincent.ui.home;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.sinyuk.PhotoFeatureUsecase;
import com.sinyuk.entities.Photo;

import java.util.List;

import javax.inject.Inject;

import rx.Observer;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by sinyuk on 2016/12/21.
 */

public class FeatureListPresenter implements FeatureListContract.Presenter {
    private static final String TAG = "FeatureListPresenter";
    @NonNull
    private final FeatureListContract.View mView;
    @NonNull
    private final PhotoFeatureUsecase mUsecase;

    /**
     * Dagger strictly enforces that arguments not marked with {@code @Nullable} are not
     * injected with {@code @Nullable} values.
     */
    @NonNull
    private CompositeSubscription mSubscriptions;

    @Inject
    public FeatureListPresenter(@NonNull PhotoFeatureUsecase usecase,
                                @NonNull FeatureListContract.View view) {
        this.mUsecase = usecase;
        this.mView = view;

    }

    /**
     * Method injection is used here to safely reference {@code this}
     * after the object is created.
     * For more information, see Java Concurrency in Practice.
     */
    @Inject
    void setupListeners() {
        mView.setPresenter(this);

    }

    @Override
    public void subscribe() {
        mSubscriptions = new CompositeSubscription();
    }

    @Override
    public void unsubscribe() {
        mSubscriptions.clear();
    }

    @Override
    public void setFeature(@Nullable String feature) {

        mUsecase.setFeature(feature);
        refresh();

    }

    @Override
    public void setCategories(String categories) {

        mUsecase.setCategories(categories);
        refresh();


    }

    @Override
    public void setSort(String sort) {

        mUsecase.setSort(sort);
        refresh();

    }

    @Override
    public void setDirection(String direction) {

        mUsecase.setDirection(direction);
        refresh();

    }

    @Override
    public void refresh() {
        mSubscriptions.add(mUsecase.load(true)
                .doOnError(throwable -> {
                    throwable.printStackTrace();
                    Log.d(TAG, "call: ");
                })
                .doOnSubscribe(mView::startRefreshing)
                .subscribe(new Observer<List<Photo>>() {
                    @Override
                    public void onCompleted() {
                        mView.stopRefreshing();
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Photo> photos) {
                        if (!photos.isEmpty()) {
                            mView.setData(photos);
                        } else {
                            mView.showEmpty("");
                        }
                    }
                }));
    }

    @Override
    public void load() {
        mSubscriptions.add(mUsecase.load(false)
                .doOnSubscribe(mView::startLoading)
                .subscribe(new Observer<List<Photo>>() {
                    @Override
                    public void onCompleted() {
                        mView.stopLoading();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Photo> photos) {
                        if (!photos.isEmpty()) {
                            mView.setData(photos);
                        } else {
                            mView.showNoMore("");
                        }
                    }
                }));
    }


}
