package com.sinyuk.vicent.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by sinyuk on 2016/12/20.
 */

public class BaseActivity extends AppCompatActivity {

    protected static String TAG = "";
    protected CompositeSubscription mCompositeSubscription;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TAG = this.getClass().getSimpleName();

        mCompositeSubscription = new CompositeSubscription();

    }


    protected void addSubscription(Subscription s) {
        mCompositeSubscription.add(s);
    }

    protected void removeSubscription(Subscription s) {
        mCompositeSubscription.remove(s);
    }

    protected void clearSubscription() {
        mCompositeSubscription.clear();
    }


    @Subscribe()
    public void onEvent() {
    }

    public void onNavback(View v) {
        onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCompositeSubscription.unsubscribe();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }
}
