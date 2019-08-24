package com.alphateam.gshackchallenge.UI.Activity.Main;

import android.app.Activity;

import com.alphateam.gshackchallenge.Base.BaseActivityModule;
import com.alphateam.gshackchallenge.DI.Component.PerActivity;
import com.alphateam.gshackchallenge.UI.Activity.Main.Presenter.MainPresenterModule;

import dagger.Binds;
import dagger.Module;

@Module(includes = {
        BaseActivityModule.class,
        MainPresenterModule.class
})
public abstract class MainModule {

    // @PerFragment
    // @ContributesAndroidInjector(modules = Example1FragmentModule.class)
    // abstract FragmentExample example1FragmentInjector();

    @Binds
    @PerActivity
    abstract Activity activity(MainActivity mainActivity);

}