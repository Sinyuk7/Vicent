package com.sinyuk;

/**
 * Created by sinyuk on 2016/12/24.
 */

public interface ListCallback {
    void startRefreshing();
    void startLoading();

    void stopRefreshing();
    void stopLoading();

    void error();
    void empty();
    void nomore();
}
