package com.example.easydragview;

import android.app.Application;
import android.content.Context;

import me.weishu.reflection.Reflection;

/*
Because this lib needs Dalvik to use some methods,
to bypass google's restriction of non-sdk api,
you must extend EasyApplication to make this
lib runnable.
https://developer.android.com/distribute/best-practices/develop/restrictions-non-sdk-interfaces
 */
public class EasyApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        Reflection.unseal(base);
    }
}
