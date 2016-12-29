package com.sinyuk.vincent.ui.comment;

import com.sinyuk.entities.Comment;
import com.sinyuk.vincent.base.BasePresenter;
import com.sinyuk.vincent.base.BaseView;

import java.util.List;

/**
 * Created by sinyuk on 2016/12/29.
 */

public interface CommentContract {
    interface View extends BaseView<Presenter> {
        void setData(List<Comment> comments, boolean clear);

        void startRefreshing();

        void stopRefreshing();

        void startLoading();

        void stopLoading();

        void showError(Throwable throwable);

        void showNoMore();

        void showEmpty();
    }

    interface Presenter extends BasePresenter {

        void refresh();

        void loadMore();
    }
}
