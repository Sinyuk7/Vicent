package com.sinyuk.vincent.ui.player;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.sinyuk.myutils.android.ActivityUtils;
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

        TimelineView timelineView = (TimelineView) getSupportFragmentManager().findFragmentById(R.id.timeline_fragment);

        if (timelineView == null) {
            timelineView = new TimelineView();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), timelineView, R.id.timeline_fragment);
        }

        long uid = getIntent().getLongExtra(KEY_UID, 0);

        VincentApplication.get(this).getAppComponent()
                .plus(new PlayerViewModule(timelineView, "user", uid))
                .inject(this);
    }
}
