package com.sinyuk.vincent.ui.player;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.sinyuk.vincent.R;
import com.sinyuk.vincent.base.BaseActivity;
import com.sinyuk.vincent.databinding.PlayerViewBinding;

/**
 * Created by sinyuk on 2016/12/25.
 */

public class PlayerView extends BaseActivity {
    private PlayerViewBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.player_view);


    }
}
