package com.alphateam.gshackchallenge.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.multidex.MultiDexApplication;

import com.alphateam.gshackchallenge.DI.Module.DaggerAppComponent;
import com.facebook.stetho.Stetho;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by ISC Jesús Romero Mtz on 24/08/2019
 */
public class ApplicationBase extends MultiDexApplication implements HasActivityInjector {

    private static Context context;
    public static ApplicationBase instance;
    public static String IPDeviceAddress;
    //private ControllerAPI controllerAPI;

    private IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
    private String setIdSesion;
    private String cookie;
    @Inject
    DispatchingAndroidInjector<Activity> activityInjector;

    public void onCreate() {
        super.onCreate();
        initApplication();
        DaggerAppComponent.builder().create(this).inject(this);
    }

    public static ApplicationBase getIntance() {
        if (instance == null) {
            instance = new ApplicationBase();
            instance.initApplication();
        }
        return instance;
    }

    private void initApplication() {
        instance = this;
        context = getApplicationContext();
        Stetho.initializeWithDefaults(this);
    }

    public static Context getAppContext() {
        return ApplicationBase.context;
    }
    public void setIdSesion(String setIdSesion) {
        this.setIdSesion = setIdSesion;
    }
    public String getIdSesion() {
        return this.setIdSesion;
    }
    public void setCookie(String cookie) {
        this.cookie = cookie;
    }
    public String getCookie() {
        return cookie;
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityInjector;
    }

}