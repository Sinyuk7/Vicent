package com.sinyuk.vincent.injector.modules;

import com.sinyuk.vincent.injector.scopes.ActivityScope;
import com.sinyuk.vincent.ui.comment.CommentContract;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sinyuk on 2016/12/29.
 */
@Module
public class CommentViewModule {
    private final CommentContract.View commentView;

    @Named("status_id")
    private final long status_id;

    public CommentViewModule(CommentContract.View commentView, long status_id) {
        this.commentView = commentView;
        this.status_id = status_id;
    }


    @Provides
    @ActivityScope
    CommentContract.View commentView() {
        return commentView;
    }


    @Provides
    @ActivityScope
    @Named("status_id")
    long status_id() {
        return status_id;
    }
}
