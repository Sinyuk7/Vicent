package com.sinyuk;

import com.sinyuk.entities.Comment;
import com.sinyuk.remote.RemoteRepository;
import com.sinyuk.utils.SchedulerTransformer;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

/**
 * Created by sinyuk on 2016/12/29.
 */

public class GetCommentUsecase extends Usecase<List<Comment>> {

    private final RemoteRepository mRepository;

    private final SchedulerTransformer<List<Comment>> mSchedulerTransformer;

    @Named("status_id")
    private final long id;

    private int page = 1;

    @Inject
    GetCommentUsecase(RemoteRepository mRepository,
                      @Named("io_main") SchedulerTransformer mSchedulerTransformer,
                      @Named("status_id") long id) {
        this.mRepository = mRepository;
        this.mSchedulerTransformer = mSchedulerTransformer;
        this.id = id;
    }

    public Observable<List<Comment>> fetch(final boolean clear) {
        return buildObservable()
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        if (clear) {
                            page = 1;
                        }
                    }
                })
                .doOnNext(new Action1<List<Comment>>() {
                    @Override
                    public void call(List<Comment> comments) {
                        if (!comments.isEmpty()) {
                            ++page;
                        }
                    }
                });
    }

    public long getId() {
        return id;
    }

    @Override
    protected Observable<List<Comment>> buildObservable() {
        if (id == 0) {
            return mRepository.comment_timeline(page)
                    .compose(mSchedulerTransformer);
        }

        return mRepository.comment_show(id, page)
                .compose(mSchedulerTransformer);
    }
}
