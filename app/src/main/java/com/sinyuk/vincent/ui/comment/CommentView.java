package com.sinyuk.vincent.ui.comment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sinyuk.entities.Comment;
import com.sinyuk.vincent.R;
import com.sinyuk.vincent.base.BaseFragment;

import java.util.List;

/**
 * Created by sinyuk on 2016/12/29.
 */

public class CommentView extends BaseFragment implements CommentContract.View {

    private CommentContract.Presenter presenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.subscribe();
        presenter.refresh();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.unsubscribe();
    }

    @Override
    public void setData(List<Comment> comments, boolean clear) {
        Log.d(TAG, "setData: ");
    }

    @Override
    public void startRefreshing() {
        Log.d(TAG, "startRefreshing: ");
    }

    @Override
    public void stopRefreshing() {
        Log.d(TAG, "stopRefreshing: ");
    }

    @Override
    public void startLoading() {
        Log.d(TAG, "startLoading: ");
    }

    @Override
    public void stopLoading() {
        Log.d(TAG, "stopLoading: ");
    }

    @Override
    public void showError(Throwable throwable) {
        Log.d(TAG, "showError: ");
    }

    @Override
    public void showNoMore() {
        Log.d(TAG, "showNoMore: ");
    }

    @Override
    public void showEmpty() {
        Log.d(TAG, "showEmpty: ");
    }

    @Override
    public void setPresenter(CommentContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
