package com.alphateam.gshackchallenge.UI.Activity.Main.Presenter;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class MainPresenterModule {

    @Binds
    abstract MainPresenter mainPresenter (MainPresenterImpl mainPresenterImpl);

}
