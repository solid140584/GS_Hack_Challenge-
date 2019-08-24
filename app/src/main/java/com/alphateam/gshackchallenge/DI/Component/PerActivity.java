package com.alphateam.gshackchallenge.DI.Component;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 *  Primero, cree las anotaciones de alcance personalizadas:
 *  @PerActivity, @PerFragment y @PerChildFragment.
 *  Primero, cree las anotaciones de alcance personalizadas: @PerActivity, @PerFragment y @PerChildFragment.
 *
 *
 *  La anotación del alcance @PerActivity especifica que la vida útil de una dependencia sea la misma
 *  que la de una Actividad. Esto se usa para anotar dependencias que se comportan como un singleton dentro de la vida
 *  útil de una actividad, un fragmento y fragmentos secundarios en lugar de la aplicación completa.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
