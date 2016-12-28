package com.sinyuk.vincent.ui.player;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import com.sinyuk.entities.User;
import com.sinyuk.vincent.BlankFragment;
import com.sinyuk.vincent.R;
import com.sinyuk.vincent.VincentApplication;
import com.sinyuk.vincent.base.BaseActivity;
import com.sinyuk.vincent.databinding.PlayerViewBinding;
import com.sinyuk.vincent.injector.modules.PlayerViewModule;

import javax.inject.Inject;

/**
 * Created by sinyuk on 2016/12/25.
 */

public class PlayerView extends BaseActivity implements PlayerContract.View {

    @SuppressWarnings("used")
    @Inject
    PlayerViewPresenter playerViewPresenter;

    private static final String KEY_UID = "UID";
    private PlayerContract.Presenter presenter;

    public static void start(Context context, long uid) {
        Intent starter = new Intent(context, PlayerView.class);
        starter.putExtra(KEY_UID, uid);
        context.startActivity(starter);
    }

    private PlayerViewBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        long uid = getIntent().getLongExtra(KEY_UID, 0);

        VincentApplication.get(this).getAppComponent()
                .plus(new PlayerViewModule(this, 2996704602L, null))
                .inject(this);


        binding = DataBindingUtil.setContentView(this, R.layout.player_view);

        initVP();

        presenter.fetchPlayer();
    }


    @Override
    protected void onResume() {
        super.onResume();
        presenter.subscribe();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.unsubscribe();
    }

    private void initVP() {
        BlankFragment timelineView = new BlankFragment();
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

    @Override
    public void setPresenter(PlayerContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void bindPlayer(User user) {
        binding.setUser(user);
    }
}
