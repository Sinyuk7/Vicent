package com.sinyuk.vincent.ui.comment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;

import com.sinyuk.vincent.VincentApplication;
import com.sinyuk.vincent.injector.modules.CommentViewModule;

import javax.inject.Inject;

/**
 * Created by sinyuk on 2016/12/29.
 */

public class CommentBottomSheet extends BottomSheetDialogFragment {

    @Inject
    CommentPresenter commentPresenter;

    private static final String KEY_STATUS_ID = "STATUS_ID";

    public static CommentBottomSheet newInstance(long status_id) {

        Bundle args = new Bundle();
        args.putLong(KEY_STATUS_ID, status_id);
        CommentBottomSheet fragment = new CommentBottomSheet();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CommentView commentView = new CommentView();

        if (getChildFragmentManager().findFragmentByTag(
                CommentView.class.getSimpleName()) == null) {
            getChildFragmentManager().beginTransaction().add(commentView,
                    CommentView.class.getSimpleName())
                    .commit();
        }

        long status_id = getArguments().getLong(KEY_STATUS_ID, 0);

        VincentApplication.get(getContext()).getAppComponent()
                .plus(new CommentViewModule(commentView, status_id))
                .inject(this);
    }
}
