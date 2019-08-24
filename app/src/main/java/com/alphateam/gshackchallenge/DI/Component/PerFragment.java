package com.alphateam.gshackchallenge.DI.Component;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * La anotación de ámbito personalizado @PerFragment especifica que la vida útil de una dependencia
 * debe ser la misma que la de un Fragmento. Esto se usa para anotar dependencias que se comportan
 * como un singleton dentro de la vida útil de un Fragmento y fragmentos secundarios
 * en lugar de la Aplicación o Actividad completa.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerFragment {
}
