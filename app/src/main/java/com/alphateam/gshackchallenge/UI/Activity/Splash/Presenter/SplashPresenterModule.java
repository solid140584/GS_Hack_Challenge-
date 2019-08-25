package com.alphateam.gshackchallenge.UI.Activity.Splash.Presenter;

import com.alphateam.gshackchallenge.DI.Component.PerActivity;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class SplashPresenterModule {
    @Binds
    @PerActivity
    abstract SplashPresenter miMomentoPresenter (SplashPresenterImpl SplashPresenterImpl);
}
