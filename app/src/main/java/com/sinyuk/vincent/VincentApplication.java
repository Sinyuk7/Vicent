package com.sinyuk.vincent;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.sinyuk.vincent.injector.components.AppComponent;
import com.sinyuk.vincent.injector.components.DaggerAppComponent;
import com.sinyuk.vincent.injector.modules.AppModule;

/**
 * Created by sinyuk on 2016/12/20.
 */

public class VincentApplication extends Application {
    private static final String TAG = "VincentApplication";
    private AppComponent appComponent = null;

    public static VincentApplication get(Context context) {
        return (VincentApplication) context.getApplicationContext();
    }


    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this)).build();
    }

    public AppComponent getAppComponent() {
        if (appComponent != null) {
            Log.d(TAG, "getAppComponent: not null");
        }
        return appComponent;
    }
}
