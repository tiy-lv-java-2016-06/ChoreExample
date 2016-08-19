package com.theironyard.choretesting;

import android.app.Application;

/**
 * Created by jeff on 8/18/16.
 */
public class BaseApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        ChoreService.initChorePrefs(this);
    }
}
