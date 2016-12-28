package com.sinyuk.vincent.ui.player;

import android.support.annotation.NonNull;

import com.sinyuk.GetPlayerUsecase;

import javax.inject.Inject;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by sinyuk on 2016/12/28.
 */

public class PlayerViewPresenter implements PlayerContract.Presenter {
    private static final String TAG = "TimelinePresenter";
    @NonNull
    private final PlayerContract.View mView;
    @NonNull
    private final GetPlayerUsecase mUsecase;

    private CompositeSubscription mSubscriptions;

    @Inject
    public PlayerViewPresenter(
            @NonNull PlayerContract.View mView,
            @NonNull GetPlayerUsecase mUsecase) {
        this.mView = mView;
        this.mUsecase = mUsecase;
        mSubscriptions = new CompositeSubscription();
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
        mSubscriptions.clear();
    }

    @Override
    public void unsubscribe() {

    }
}
