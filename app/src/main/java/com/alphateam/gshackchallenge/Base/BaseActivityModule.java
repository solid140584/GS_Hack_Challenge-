package com.alphateam.gshackchallenge.Base;

/**
 * Created by ISC Jesús Romero Mtz on 23/09/2018
 */

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;


import com.alphateam.gshackchallenge.DI.Component.PerActivity;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * BaseActivityModule proporciona las dependencias de actividad base.
 * la actividad Contexto y la actividad FragmentManager denominada ACTIVITY_FRAGMENT_MANAGER.
 *
 * El módulo de las subclases de BaseActivity debe incluir el BaseActivityModule y proporcionar
 * una implementación concreta de la Actividad.
 */
@Module
public abstract class BaseActivityModule {

    static final String ACTIVITY_FRAGMENT_MANAGER = "BaseActivityModule.activityFragmentManager";

    @Binds
    @PerActivity

    /*
     * PerActivity annotation isn't necessary since Activity instance is unique but is here for
     * convention. In general, providing Application, Activity, Fragment, BroadcastReceiver,
     * etc does not require scoped annotations since they are the components being injected and
     * their instance is unique.
     *
     * However, having a scope annotation makes the module easier to read. We wouldn't have to look
     * at what is being provided in order to understand its scope.
     */
    abstract Context activityContext(Activity activity);

    @Provides
    @Named(ACTIVITY_FRAGMENT_MANAGER)
    @PerActivity
    static FragmentManager activityFragmentManager(Activity activity) {
        return activity.getFragmentManager();
    }
}