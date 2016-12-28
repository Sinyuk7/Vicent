package com.sinyuk.vincent.ui.player;

import android.support.annotation.NonNull;
import android.util.Log;

import com.sinyuk.GetPlayerUsecase;
import com.sinyuk.entities.User;

import javax.inject.Inject;

import rx.Observer;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by sinyuk on 2016/12/28.
 */

public class PlayerViewPresenter implements PlayerContract.Presenter {
    private static final String TAG = "PlayerViewPresenter";
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
        Log.d(TAG, "subscribe: ");
    }

    @Override
    public void unsubscribe() {
        Log.d(TAG, "unsubscribe: ");
        mSubscriptions.clear();
    }

    @Override
    public void fetchPlayer() {
        mSubscriptions.add(mUsecase.execute().subscribe(new Observer<User>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(User user) {
                mView.bindPlayer(user);
            }
        }));
    }
}
