package com.sinyuk.vicent.ui.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sinyuk.vicent.R;
import com.sinyuk.vicent.base.BaseFragment;
import com.sinyuk.vicent.databinding.HomeFeatureListBinding;

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
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.setText(presenter.getFeature());
    }
}
