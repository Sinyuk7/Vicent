package com.sinyuk.vicent.ui.home;

import com.sinyuk.vicent.base.BasePresenter;
import com.sinyuk.vicent.base.BaseView;

/**
 * Created by sinyuk on 2016/12/21.
 */

public interface FeatureListContract {
    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter {
        void setFeature(String feature);
    }

}
