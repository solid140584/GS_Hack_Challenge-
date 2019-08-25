package com.alphateam.gshackchallenge.UI.Fragment.Registro;


import android.text.TextUtils;
import android.widget.Toast;

import com.alphateam.gshackchallenge.Base.BasePresenterImpl;
import com.alphateam.gshackchallenge.Base.BaseView;
import com.alphateam.gshackchallenge.IO.Request.RegistroRequest;
import com.alphateam.gshackchallenge.IO.Responses.RegistroResponse;
import com.alphateam.gshackchallenge.Utils.ApplicationBase;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class RegistroPresenterImpl extends BasePresenterImpl implements RegistroPresenter {
    RegistroView view;
    Observable<RegistroResponse> observableRegistro;

    @Inject
    public RegistroPresenterImpl() {

    }

    @Override
    public void register(BaseView view) {
        super.register(view);
        this.view = (RegistroView) view;
    }

    @Override
    public void validateFieldsToRegister(String etNombre1, String etNombre2, String etApPaterno, String etApMaterno, String etTelefono, String etCiudad, String etContrasena, String etConfirmarContrasena, String etEmail, int genero) {
        if(!TextUtils.isEmpty(etNombre1)&&!TextUtils.isEmpty(etApPaterno)&&!TextUtils.isEmpty(etApMaterno)&&!TextUtils.isEmpty(etTelefono)&&!TextUtils.isEmpty(etCiudad)&&!TextUtils.isEmpty(etContrasena)&&!TextUtils.isEmpty(etContrasena)&&!TextUtils.isEmpty(etConfirmarContrasena)){
            if(etContrasena.length()>5) {
                if (etContrasena.equals(etConfirmarContrasena)) {
                    view.registerUser(etNombre1, etNombre2, etApPaterno, etApMaterno, etTelefono, etCiudad, etContrasena, etEmail, genero);
                } else {
                    view.passNOCoinciden();
                }
            }else {
                view.passLow6();
            }
        }else {
            view.fieldIsEmpty();
        }
    }

    @Override
    public void RegistrarUsuario(final String etNombre1, String etNombre2, final String etApPaterno, String etApMaterno, String etTelefono, String etCiudad, final String etContrasena, String etEmail, int genero) {
        RegistroRequest request = new RegistroRequest();
        request.setPrimerNombre(etNombre1);
        request.setSegundoNombre(etNombre2);
        request.setApPaterno(etApPaterno);
        request.setApMaterno(etApMaterno);
        request.setTelefono(etTelefono);
        request.setContraseña(etContrasena);
        request.setCiudad(etCiudad);
        request.setMail(etEmail);
        observableRegistro = ApplicationBase.getIntance().getmControllerLogin().JWT_Registro(request);
        observableRegistro.subscribe(new Observer<RegistroResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(RegistroResponse value) {
//                if(value!=null){
//
//                }
                view.Hard(etNombre1, etApPaterno, etContrasena);
            }

            @Override
            public void onError(Throwable e) {
                view.Hard(etNombre1, etApPaterno, etContrasena);
//                Toast.makeText(ApplicationBase.getAppContext(),"Ingresa la contraseña",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {

            }
        });
    }

    public interface RegistroView extends BaseView{

        void registerUser(String etNombre1, String etNombre2, String etApPaterno, String etApMaterno, String etTelefono, String etCiudad, String etContrasena, String etEmail, int genero);

        void passNOCoinciden();

        void fieldIsEmpty();

        void passLow6();

        void Hard(String Nombre, String apellido, String pass);
    }
}
