package com.sinyuk.vincent.ui.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fivehundredpx.greedolayout.GreedoLayoutManager;
import com.fivehundredpx.greedolayout.GreedoSpacingItemDecoration;
import com.sinyuk.entities.Photo;
import com.sinyuk.myutils.ConvertUtils;
import com.sinyuk.vincent.R;
import com.sinyuk.vincent.base.BaseFragment;
import com.sinyuk.vincent.databinding.LayoutStatesBinding;

import java.util.List;

/**
 * Created by sinyuk on 2016/12/21.
 */

public class FeatureList extends BaseFragment implements FeatureListContract.View {
    private FeatureListContract.Presenter presenter;
    private PhotoAdapter photoAdapter;

    @Override
    public void setPresenter(FeatureListContract.Presenter presenter) {
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

    }

    private void initList() {
        photoAdapter = new PhotoAdapter();
        final GreedoLayoutManager layoutManager = new GreedoLayoutManager(photoAdapter);
        layoutManager.setMaxRowHeight(ConvertUtils.dp2px(getContext(), 160));
        layoutManager.setAutoMeasureEnabled(true);
        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setHasFixedSize(true);

        int spacing = ConvertUtils.dp2px(getContext(), 4);
        binding.recyclerView.addItemDecoration(new GreedoSpacingItemDecoration(spacing));

        photoAdapter.setHasStableIds(true);
        binding.recyclerView.setAdapter(photoAdapter);
    }

    @Override
    public void startRefreshing() {
        Log.d(TAG, "startRefreshing: ");
        binding.viewAnimator.setDisplayedChildId(R.id.loadingLayout);
    }

    @Override
    public void setData(List<Photo> photos) {
        photoAdapter.setData(photos);
    }

    @Override
    public void stopRefreshing() {
        binding.viewAnimator.setDisplayedChildId(R.id.recyclerView);
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
    public void showError(String message) {
        binding.setErrorMessage(message);
        binding.viewAnimator.setDisplayedChildId(R.id.errorLayout);
    }

    @Override
    public void showNoMore(String message) {

    }

    @Override
    public void showEmpty(String message) {
        binding.setEmptyMessage(message);
        binding.viewAnimator.setDisplayedChildId(R.id.emptyLayout);
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

}
