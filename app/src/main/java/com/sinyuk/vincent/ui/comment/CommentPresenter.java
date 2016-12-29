package com.sinyuk.vincent.ui.comment;

import android.support.annotation.NonNull;

import com.sinyuk.GetCommentUsecase;
import com.sinyuk.entities.Comment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by sinyuk on 2016/12/29.
 */

public class CommentPresenter implements CommentContract.Presenter {
    private static final String TAG = "CommentPresenter";

    @NonNull
    private final CommentContract.View mView;
    @NonNull
    private final GetCommentUsecase mUsecase;

    private boolean dataInTransit = false;
    private boolean reachBottom = false;
    private List<Comment> commentList = new ArrayList<>();

    private CompositeSubscription mSubscriptions;

    @Inject
    CommentPresenter(@NonNull CommentContract.View mView, @NonNull GetCommentUsecase mUsecase) {
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
    public void refresh() {
        if (dataInTransit) return;

        mSubscriptions.add(mUsecase.fetch(true)
                .doOnSubscribe(() -> dataInTransit = true)
                .doOnSubscribe(mView::startRefreshing)
                .doOnSubscribe(() -> commentList.clear())
                .doOnTerminate(() -> dataInTransit = reachBottom = false)
                .doOnTerminate(mView::stopRefreshing)
                .doOnError(mView::showError)
                .subscribe(comments -> {
                    if (comments.getComments().isEmpty()) {
                        mView.showEmpty();
                    } else {
                        mView.setData(comments.getComments(), true);
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
                .subscribe(comments -> {
                    if (comments.getComments().isEmpty()) {
                        reachBottom = true;
                        mView.showNoMore();
                    } else {
                        mView.setData(comments.getComments(), false);
                    }
                }));
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
        mSubscriptions.clear();
    }
}
