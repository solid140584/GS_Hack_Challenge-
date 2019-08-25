package com.alphateam.gshackchallenge.UI.Activity.Splash;

import android.app.Activity;

import com.alphateam.gshackchallenge.Base.BaseActivityModule;
import com.alphateam.gshackchallenge.DI.Component.PerActivity;
import com.alphateam.gshackchallenge.UI.Activity.Splash.Presenter.SplashPresenterModule;

import dagger.Binds;
import dagger.Module;

@Module(includes = {
        BaseActivityModule.class,
        SplashPresenterModule.class
})

public abstract class SplashModule {
    @Binds
    @PerActivity
    abstract Activity activity(SplashActivity mainActivity);
}
