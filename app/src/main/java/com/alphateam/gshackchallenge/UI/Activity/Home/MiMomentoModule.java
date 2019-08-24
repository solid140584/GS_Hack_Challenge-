package com.alphateam.gshackchallenge.UI.Activity.Home;

import android.app.Activity;

import com.alphateam.gshackchallenge.Base.BaseActivityModule;
import com.alphateam.gshackchallenge.DI.Component.PerActivity;
import com.alphateam.gshackchallenge.UI.Activity.Home.Presenter.MiMomentoPresenterModule;
import com.alphateam.gshackchallenge.UI.Activity.Main.MainActivity;
import com.alphateam.gshackchallenge.UI.Activity.Main.Presenter.MainPresenterModule;

import dagger.Binds;
import dagger.Module;

@Module(includes = {
        BaseActivityModule.class,
        MiMomentoPresenterModule.class
})
public abstract class MiMomentoModule {

    @Binds
    @PerActivity
    abstract Activity activity(MiMomentoActivity mainActivity);

}