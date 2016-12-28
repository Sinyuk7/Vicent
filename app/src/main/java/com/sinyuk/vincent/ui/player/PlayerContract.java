package com.sinyuk.vincent.ui.player;

import com.sinyuk.entities.User;
import com.sinyuk.vincent.base.BasePresenter;
import com.sinyuk.vincent.base.BaseView;

/**
 * Created by sinyuk on 2016/12/28.
 */

public interface PlayerContract {
    interface View extends BaseView<Presenter> {
        void bindPlayer(User user);
    }

    interface Presenter extends BasePresenter {
        void fetchPlayer();
    }
}
