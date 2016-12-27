package com.sinyuk.vincent.ui.timeline;

import android.support.annotation.NonNull;

import com.sinyuk.GetTimelineUsecase;
import com.sinyuk.entities.Status;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by sinyuk on 2016/12/21.
 */

public class TimelinePresenter implements TimelineContract.Presenter {
    private static final String TAG = "TimelinePresenter";
    @NonNull
    private final TimelineContract.View mView;
    @NonNull
    private final GetTimelineUsecase mUsecase;

    private boolean dataInTransit = false;
    private boolean reachBottom = false;
    private List<Status> statusList = new ArrayList<>();
    /**
     * Dagger strictly enforces that arguments not marked with {@code @Nullable} are not
     * injected with {@code @Nullable} values.
     */
    private CompositeSubscription mSubscriptions;

    @Inject
    public TimelinePresenter(
            @NonNull TimelineContract.View mView,
            @NonNull GetTimelineUsecase mUsecase) {
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

    }

    @Override
    public void unsubscribe() {
        mSubscriptions.clear();
    }


    @Override
    public void setFeature(int feature) {
        mUsecase.setFeature(feature);
    }

    @Override
    public void refresh() {
        if (dataInTransit) return;

        mSubscriptions.add(mUsecase.fetch(true)
                .doOnSubscribe(() -> dataInTransit = true)
                .doOnSubscribe(mView::startRefreshing)
                .doOnSubscribe(() -> statusList.clear())
                .doOnTerminate(() -> dataInTransit = reachBottom = false)
                .doOnTerminate(mView::stopRefreshing)
                .doOnError(mView::showError)
                .subscribe(timeline -> {
                    if (timeline.getTotalNumber() == 0) {
                        mView.showEmpty();
                    } else {
                        mView.setData(timeline.getStatuses(), true);
                    }
                }));
    }

    @Override
    public void loadMore() {
        if (dataInTransit || reachBottom) return;
        mSubscriptions.add(mUsecase.fetch(false)
                .doOnSubscribe(() -> dataInTransit = true)
                .doOnTerminate(() -> dataInTransit = false)
                .doOnSubscribe(mView::startLoading)
                .doOnTerminate(mView::stopLoading)
                .doOnError(mView::showError)
                .subscribe(timeline -> {
                    if (timeline.getNextCursor() == 0) {
                        reachBottom = true;
                        mView.showNoMore();
                    } else {
                        mView.setData(timeline.getStatuses(), false);
                    }
                }));
    }


}
