package com.sinyuk.vincent.ui.timeline;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sinyuk.entities.Status;
import com.sinyuk.vincent.R;
import com.sinyuk.vincent.base.BaseFragment;
import com.sinyuk.vincent.databinding.LayoutStatesBinding;

import java.util.List;

/**
 * Created by sinyuk on 2016/12/21.
 */

public class TimelineView extends BaseFragment implements TimelineContract.View {
    private TimelineContract.Presenter presenter;

    @Override
    public void setPresenter(TimelineContract.Presenter presenter) {
        this.presenter = presenter;
    }

    private LayoutStatesBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.layout_states, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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
    public void setData(List<Status> photos) {

    }

    @Override
    public void startRefreshing() {

    }

    @Override
    public void stopRefreshing() {

    }

    @Override
    public void startLoading() {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showError(Throwable throwable) {

    }

    @Override
    public void showNoMore() {

    }

    @Override
    public void showEmpty() {

    }
}
