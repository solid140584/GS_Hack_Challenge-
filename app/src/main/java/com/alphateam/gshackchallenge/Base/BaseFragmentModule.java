package com.alphateam.gshackchallenge.Base;

/**
 * Created by ISC Jesús Romero Mtz on 23/09/2018
 */

import android.app.Fragment;
import android.app.FragmentManager;



import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * BaseFragmentModule proporciona las dependencias de fragmentos base;
 * hasta ahora solo el childFragmentManager llamado CHILD_FRAGMENT_MANAGER.
 *
 * El módulo de las subclases de BaseFragment debe incluir el BaseFragmentModule y proporcionar una implementación
 * concreta del Fragmento llamado FRAGMENT.
 */
@Module
public abstract class BaseFragmentModule {

    /**
     * See {@link BaseChildFragmentModule} class documentation regarding the need for this name.
     */
    public static final String FRAGMENT = "BaseFragmentModule.fragment";

    public static final String CHILD_FRAGMENT_MANAGER = "BaseFragmentModule.childFragmentManager";

    @Provides
    @Named(CHILD_FRAGMENT_MANAGER)
    @PerFragment
    static FragmentManager childFragmentManager(@Named(FRAGMENT) Fragment fragment) {
        return fragment.getChildFragmentManager();
    }
}