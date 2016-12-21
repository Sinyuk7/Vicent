package com.sinyuk.vicent.ui.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.sinyuk.myutils.android.ActivityUtils;
import com.sinyuk.vicent.R;
import com.sinyuk.vicent.VincentApplication;
import com.sinyuk.vicent.base.BaseActivity;
import com.sinyuk.vicent.databinding.HomeViewBinding;
import com.sinyuk.vicent.injector.components.DaggerHomeViewComponent;
import com.sinyuk.vicent.injector.modules.HomeViewModule;

/**
 * Created by sinyuk on 2016/12/20.
 */

public class HomeView extends BaseActivity {

    private HomeViewBinding binding;

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
                .build();

    }

}
