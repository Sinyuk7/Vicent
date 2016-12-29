package com.sinyuk.vincent.injector.components;

import com.sinyuk.vincent.injector.modules.CommentViewModule;
import com.sinyuk.vincent.injector.scopes.ActivityScope;
import com.sinyuk.vincent.ui.comment.CommentBottomSheet;

import dagger.Subcomponent;

/**
 * Created by sinyuk on 2016/12/29.
 */
@ActivityScope
@Subcomponent(modules = CommentViewModule.class)
public interface CommentViewComponent {

    void inject(CommentBottomSheet commentBottomSheet);
}
