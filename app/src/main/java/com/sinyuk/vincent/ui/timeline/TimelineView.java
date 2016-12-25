package com.sinyuk.vincent.ui.timeline;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sinyuk.entities.Status;
import com.sinyuk.myutils.ConvertUtils;
import com.sinyuk.vincent.R;
import com.sinyuk.vincent.base.BaseFragment;
import com.sinyuk.vincent.databinding.LayoutStatesBinding;
import com.sinyuk.vincent.utils.rv.GridSpacingItemDecoration;

import java.util.List;

/**
 * Created by sinyuk on 2016/12/21.
 */

public class TimelineView extends BaseFragment implements TimelineContract.View {
    private TimelineContract.Presenter presenter;
    private TimelineAdapter adapter;

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
        initList();
        presenter.subscribe();
        presenter.refresh();
    }

    private void initList() {
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setAutoMeasureEnabled(true);

        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setHasFixedSize(true);

        binding.recyclerView.addItemDecoration(new GridSpacingItemDecoration(1, ConvertUtils.dp2px(getContext(), 16), false));

        adapter = new TimelineAdapter(getContext());
        adapter.setHasStableIds(true);
        binding.recyclerView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.unsubscribe();
    }

    @Override
    public void setData(List<Status> photos) {
        adapter.setData(photos);
    }

    @Override
    public void startRefreshing() {

    }

    @Override
    public void stopRefreshing() {
        binding.viewAnimator.setDisplayedChildId(R.id.recyclerView);
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
