package com.sinyuk.vincent.ui.player;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import com.sinyuk.vincent.BlankFragment;
import com.sinyuk.vincent.R;
import com.sinyuk.vincent.VincentApplication;
import com.sinyuk.vincent.base.BaseActivity;
import com.sinyuk.vincent.databinding.PlayerViewBinding;
import com.sinyuk.vincent.injector.modules.PlayerViewModule;
import com.sinyuk.vincent.ui.timeline.TimelinePresenter;
import com.sinyuk.vincent.ui.timeline.TimelineView;

import javax.inject.Inject;

/**
 * Created by sinyuk on 2016/12/25.
 */

public class PlayerView extends BaseActivity {


    private static final String KEY_UID = "UID";

    public static void start(Context context, long uid) {
        Intent starter = new Intent(context, PlayerView.class);
        starter.putExtra(KEY_UID, uid);
        context.startActivity(starter);
    }

    private PlayerViewBinding binding;

    @Inject
    TimelinePresenter timelinePresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.player_view);


        initVP();
    }

    private void initVP() {
        TimelineView timelineView = new TimelineView();
        long uid = getIntent().getLongExtra(KEY_UID, 0);
        VincentApplication.get(this).getAppComponent()
                .plus(new PlayerViewModule(timelineView, "user", 0))
                .inject(this);

        BlankFragment exploreView = new BlankFragment();
        BlankFragment messageView = new BlankFragment();
        BlankFragment profileView = new BlankFragment();

        binding.viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return timelineView;
                    case 1:
                        return exploreView;
                    case 2:
                        return messageView;
                    case 3:
                        return profileView;
                    default:
                        return null;
                }
            }

            @Override
            public int getCount() {
                return 4;
            }
        });

        binding.viewPager.setOffscreenPageLimit(3);
    }
}
