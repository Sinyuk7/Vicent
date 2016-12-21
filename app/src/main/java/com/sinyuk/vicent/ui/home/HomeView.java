package com.sinyuk.vicent.ui.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.sinyuk.myutils.android.ActivityUtils;
import com.sinyuk.vicent.R;
import com.sinyuk.vicent.VincentApplication;
import com.sinyuk.vicent.base.BaseActivity;
import com.sinyuk.vicent.databinding.HomeViewBinding;
import com.sinyuk.vicent.injector.components.DaggerHomeViewComponent;
import com.sinyuk.vicent.injector.modules.HomeViewModule;

import java.util.Random;

import javax.inject.Inject;

/**
 * Created by sinyuk on 2016/12/20.
 */

public class HomeView extends BaseActivity {

    private HomeViewBinding binding;

    @Inject
    FeatureListPresenter featureListPresenter;

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

        if (featureListPresenter == null) {
            Log.e(TAG, "featureListPresenter is NULL");
        }
    }

    public void onSwitch(View view) {
        featureListPresenter.setFeature("Roll-> " + new Random().nextInt(10000));
    }
}
