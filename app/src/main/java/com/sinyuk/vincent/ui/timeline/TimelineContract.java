package com.sinyuk.vincent.ui.timeline;

import com.sinyuk.entities.Status;
import com.sinyuk.vincent.base.BasePresenter;
import com.sinyuk.vincent.base.BaseView;

import java.util.List;

/**
 * Created by sinyuk on 2016/12/21.
 */

public interface TimelineContract {
    interface View extends BaseView<Presenter> {

        void setData(List<Status> photos,boolean clear);

        void startRefreshing();

        void stopRefreshing();

        void startLoading();

        void stopLoading();

        void showError(Throwable throwable);

        void showNoMore();

        void showEmpty();

    }

    interface Presenter extends BasePresenter {
        // filter
        void setFeature(int feature);

        void refresh();

        void loadMore();
    }

}
