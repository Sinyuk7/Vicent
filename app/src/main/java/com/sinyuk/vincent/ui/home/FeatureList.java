package com.sinyuk.vincent.ui.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sinyuk.entities.Feature;
import com.sinyuk.vincent.R;
import com.sinyuk.vincent.base.BaseFragment;
import com.sinyuk.vincent.databinding.HomeFeatureListBinding;

/**
 * Created by sinyuk on 2016/12/21.
 */

public class FeatureList extends BaseFragment implements FeatureListContract.View {
    private FeatureListContract.Presenter presenter;

    @Override
    public void setPresenter(FeatureListContract.Presenter presenter) {
        this.presenter = presenter;
    }

    private HomeFeatureListBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_feature_list, container, false);
        return binding.getRoot();
    }

    @Override
    public void startRefreshing() {
        Log.d(TAG, "startRefreshing: ");
    }

    @Override
    public void setData(Feature feature) {
        Log.d(TAG, "setData: " + feature.toString());
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
    public void showError(String message) {

    }

    @Override
    public void showNoMore(String message) {

    }

    @Override
    public void showEmpty(String message) {

    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.unsubscribe();
    }

}
