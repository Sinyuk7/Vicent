package com.sinyuk.vincent.ui.home;

import com.sinyuk.entities.Feature;
import com.sinyuk.vincent.base.BasePresenter;
import com.sinyuk.vincent.base.BaseView;

/**
 * Created by sinyuk on 2016/12/21.
 */

public interface FeatureListContract {
    interface View extends BaseView<Presenter> {

        void setData(Feature feature);

        void startRefreshing();

        void stopRefreshing();

        void startLoading();

        void stopLoading();

        void showError(String message);

        void showNoMore(String message);

        void showEmpty(String message);

    }

    interface Presenter extends BasePresenter {
        // filter
        void setFeature(String feature);

        // refresh
        void refresh();

        // load more
        void load();

    }

}
