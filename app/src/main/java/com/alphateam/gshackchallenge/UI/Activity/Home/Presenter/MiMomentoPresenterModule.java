package com.alphateam.gshackchallenge.UI.Activity.Home.Presenter;

import com.alphateam.gshackchallenge.DI.Component.PerActivity;
import com.alphateam.gshackchallenge.UI.Activity.Main.Presenter.MainPresenter;
import com.alphateam.gshackchallenge.UI.Activity.Main.Presenter.MainPresenterImpl;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MiMomentoPresenterModule {

    @Binds
    @PerActivity
    abstract MiMomentoPresenter miMomentoPresenter (MiMomentoPresenterImpl miMomentoPresenterImpl);

}