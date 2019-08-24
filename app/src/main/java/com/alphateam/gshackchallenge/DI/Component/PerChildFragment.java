package com.alphateam.gshackchallenge.DI.Component;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * La anotación de ámbito personalizado @PerChildFragment especifica que la vida útil de una dependencia
 * debe ser la misma que la de un Fragmento hijo (un fragmento dentro de un fragmento que se agrega mediante
 * Fragment.getChildFragmentManager ()). Esto se usa para anotar dependencias que se comportan como un singleton
 * dentro de la vida útil de un Fragmento hijo en lugar de toda la Aplicación, Actividad o Fragmento principal.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerChildFragment {
}
