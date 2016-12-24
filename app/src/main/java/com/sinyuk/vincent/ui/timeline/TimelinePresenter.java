package com.sinyuk.vincent.ui.timeline;

import android.support.annotation.NonNull;
import android.util.Log;

import com.sinyuk.GetTimelineUsecase;

import javax.inject.Inject;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by sinyuk on 2016/12/21.
 */

public class TimelinePresenter implements TimelineContract.Presenter, ListCallback {
    private static final String TAG = "TimelinePresenter";
    @NonNull
    private final TimelineContract.View mView;
    @NonNull
    private final GetTimelineUsecase mUsecase;

    /**
     * Dagger strictly enforces that arguments not marked with {@code @Nullable} are not
     * injected with {@code @Nullable} values.
     */
    private CompositeSubscription mSubscriptions;

    @Inject
    public TimelinePresenter(@NonNull GetTimelineUsecase usecase,
                             @NonNull TimelineContract.View view) {
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
        mUsecase.setCallback(this);
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
    public void startRefreshing() {
        Log.d(TAG, "startRefreshing: ");
    }

    @Override
    public void startLoading() {
        Log.d(TAG, "startLoading: ");
    }

    @Override
    public void stopRefreshing() {
        Log.d(TAG, "stopRefreshing: ");
    }

    @Override
    public void stopLoading() {
        Log.d(TAG, "stopLoading: ");
    }

    @Override
    public void error() {
        Log.d(TAG, "error: ");
    }

    @Override
    public void empty() {
        Log.d(TAG, "empty: ");
    }

    @Override
    public void nomore() {
        Log.d(TAG, "nomore: ");
    }
}
