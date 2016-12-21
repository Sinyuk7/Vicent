package com.sinyuk.vicent.ui.home;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.sinyuk.remote.RemoteDataSource;

import javax.inject.Inject;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by sinyuk on 2016/12/21.
 */

public class FeatureListPresenter implements FeatureListContract.Presenter {
    @NonNull
    private final RemoteDataSource remoteDataSource;
    @NonNull
    private final FeatureListContract.View mView;

    /**
     * Dagger strictly enforces that arguments not marked with {@code @Nullable} are not
     * injected with {@code @Nullable} values.
     */
    @Nullable
    String feature;

    @NonNull
    private final CompositeSubscription mSubscriptions;

    @Inject
    public FeatureListPresenter(@NonNull RemoteDataSource remoteDataSource,
                                @Nullable String feature,
                                @NonNull FeatureListContract.View view) {
        this.remoteDataSource = remoteDataSource;
        this.feature = feature;
        this.mView = view;
        this.mSubscriptions = new CompositeSubscription();
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

    }

    @Override
    public void unsubscribe() {
        mSubscriptions.clear();
    }
}
