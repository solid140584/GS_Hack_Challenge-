package com.alphateam.gshackchallenge.DI.Module;

import android.app.Application;

import com.alphateam.gshackchallenge.DI.Component.PerActivity;
import com.alphateam.gshackchallenge.UI.Activity.Home.MiMomentoActivity;
import com.alphateam.gshackchallenge.UI.Activity.Home.MiMomentoModule;
import com.alphateam.gshackchallenge.UI.Activity.Splash.SplashActivity;
import com.alphateam.gshackchallenge.UI.Activity.Splash.SplashModule;
import com.alphateam.gshackchallenge.Utils.ApplicationBase;
import com.alphateam.gshackchallenge.UI.Activity.Main.MainActivity;
import com.alphateam.gshackchallenge.UI.Activity.Main.MainModule;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.android.ContributesAndroidInjector;

/**
 * El AppModule es una clase abstracta que se anota con la anotación @Module e incluye el AndroidInjectionModule,
 * que contiene enlaces para garantizar la usabilidad de las clases "dagger.android framework".
 */
@Module(includes = AndroidInjectionModule.class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract Application application(ApplicationBase app);

     /**
     * Declarar el Module de la actividad que extiende de BaseAppCompactActivity
     */
    @PerActivity
    @ContributesAndroidInjector(modules = MainModule.class)
    abstract MainActivity MainActivityInjector();

    @PerActivity
    @ContributesAndroidInjector(modules = MiMomentoModule.class)
    abstract MiMomentoActivity MiMomentoActivityInjector();

    @PerActivity
    @ContributesAndroidInjector(modules = SplashModule.class)
    abstract SplashActivity SplashActivityInjector();

}