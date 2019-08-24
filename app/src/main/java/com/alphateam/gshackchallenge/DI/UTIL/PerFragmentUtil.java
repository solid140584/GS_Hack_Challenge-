
package com.alphateam.gshackchallenge.DI.UTIL;

import android.app.Fragment;

import com.jrgames.reporteciudadano.Base.BaseFragmentModule;
import com.jrgames.reporteciudadano.DI.Component.PerFragment;

import javax.inject.Inject;
import javax.inject.Named;


/**
 * PerFragmentUtil tiene un ámbito con @PerFragment.
 * Esto significa que el Fragmento y todos sus fragmentos secundarios y sus dependencias compartirán la misma instancia de esta clase.
 * Sin embargo, las diferentes instancias de fragmentos tendrán sus propias instancias.
 * Esto no está disponible en el nivel de Actividad y Aplicación.
 * Created By ISC Jesus Romero
 */
@PerFragment
public final class PerFragmentUtil {

    private final Fragment fragment;

    /**
     * Nota: Tenga en cuenta que el nombre del Fragmento en el constructor es BaseFragmentModule.FRAGMENT.
     * @param fragment
     */
    @Inject
    PerFragmentUtil(@Named(BaseFragmentModule.FRAGMENT) Fragment fragment) {
        this.fragment = fragment;
    }
}
