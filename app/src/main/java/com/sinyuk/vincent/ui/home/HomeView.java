package com.sinyuk.vincent.ui.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.sinyuk.myutils.android.ActivityUtils;
import com.sinyuk.vincent.R;
import com.sinyuk.vincent.VincentApplication;
import com.sinyuk.vincent.base.BaseActivity;
import com.sinyuk.vincent.databinding.HomeViewBinding;
import com.sinyuk.vincent.injector.components.DaggerHomeViewComponent;
import com.sinyuk.vincent.injector.modules.HomeViewModule;

import javax.inject.Inject;

/**
 * Created by sinyuk on 2016/12/20.
 */

public class HomeView extends BaseActivity {

    private HomeViewBinding binding;

    @Inject
    FeatureListPresenter featureListPresenter;
    private int[] mColors;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.home_view);

        FeatureList featureList = (FeatureList) getSupportFragmentManager().findFragmentById(R.id.featureList);

        if (featureList == null) {
            featureList = new FeatureList();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), featureList, R.id.featureList);
        }

        DaggerHomeViewComponent.builder()
                .appComponent(VincentApplication.get(this).getAppComponent())
                .homeViewModule(new HomeViewModule(featureList))
                .build()
                .inject(this);


    }
}
