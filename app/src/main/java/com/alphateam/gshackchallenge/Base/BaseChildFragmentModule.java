package com.alphateam.gshackchallenge.Base;

import dagger.Module;

/**
 * BaseFragmentModule proporciona las dependencias de fragmentos base;
 * hasta ahora solo el childFragmentManager llamado CHILD_FRAGMENT_MANAGER.
 * El módulo de las subclases de BaseFragment debe incluir el BaseFragmentModule y proporcionar una implementación
 * concreta del Fragmento llamado FRAGMENT.
 */
@Module
public abstract class BaseChildFragmentModule {

    /**
     * See class documentation regarding the need for this name.
     */
    public static final String CHILD_FRAGMENT = "BaseChildFragmentModule.childFragment";
}
