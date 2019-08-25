package com.alphateam.gshackchallenge.UI.Fragment.Registro;

import com.alphateam.gshackchallenge.Base.BasePresenter;

public interface RegistroPresenter extends BasePresenter {
    void validateFieldsToRegister(String etNombre1, String etNombre2, String etApPaterno, String etApMaterno, String etTelefono, String etCiudad, String etContrasena, String etConfirmarContrasena, String etEmail, int genero);

    void RegistrarUsuario(String etNombre1, String etNombre2, String etApPaterno, String etApMaterno, String etTelefono, String etCiudad, String etContrasena, String etEmail, int genero);
}
