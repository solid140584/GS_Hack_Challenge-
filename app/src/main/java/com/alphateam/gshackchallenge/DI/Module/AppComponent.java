package com.alphateam.gshackchallenge.DI.Module;

import com.alphateam.gshackchallenge.DI.Utils.ApplicationBase;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;

/**
 * El componente de aplicación se anota con @Component y @Singleton para indicar que sus módulos
 * (AppModule) proporcionarán dependencias @Singleton con o sin ámbito.
 *
 * El siguiente paso es crear las clases base para usar en toda la aplicación:
 * BaseActivity, BaseActivityModule, BaseFragment, BaseFragmentModule y BaseChildFragmentModule.
 */
@Singleton
@Component(modules = AppModule.class)
interface AppComponent extends AndroidInjector<ApplicationBase> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<ApplicationBase> {
    }
}