package com.alphateam.gshackchallenge.UI.Activity.Main.Presenter;

import com.alphateam.gshackchallenge.DI.Component.PerActivity;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MainPresenterModule {

    @Binds
    @PerActivity
    abstract MainPresenter mainPresenter (MainPresenterImpl mainPresenterImpl);

}
