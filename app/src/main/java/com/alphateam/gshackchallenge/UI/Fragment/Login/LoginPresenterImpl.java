package com.alphateam.gshackchallenge.UI.Fragment.Login;

import android.text.TextUtils;

import com.alphateam.gshackchallenge.Base.BasePresenterImpl;
import com.alphateam.gshackchallenge.Base.BaseView;
import com.alphateam.gshackchallenge.IO.Request.LoginRequest;
import com.alphateam.gshackchallenge.IO.Responses.LoginResponse;
import com.alphateam.gshackchallenge.Utils.ApplicationBase;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class LoginPresenterImpl extends BasePresenterImpl implements LoginPresenter {
    LoginView view;
    Observable observableLogin;

    @Inject
    public LoginPresenterImpl(){

    }

    @Override
    public void register(BaseView view) {
        super.register(view);
        this.view = (LoginView) view;
    }

    @Override
    public void validateUser(String usuario, String pass) {
        if(TextUtils.isEmpty(usuario)){
            view.userIsEmpty();
        }else if(TextUtils.isEmpty(pass)){
            view.passIsEmpty();
        }else if (pass.length()<=6){
            view.passLow6();
        }else{
            view.success(usuario,pass);
        }
    }

    @Override
    public void Login(String usuario, String pass) {
        LoginRequest request = new LoginRequest();
        request.setUsuario(usuario);
        request.setContraseña(pass);
        observableLogin = ApplicationBase.getIntance().getmControllerLogin().JWT_Login(request);
        observableLogin.subscribe(new Observer<LoginResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(LoginResponse value) {
//                if(value!=null){
//
//                }
                view.SuccesLogin();
            }

            @Override
            public void onError(Throwable e) {
                view.SuccesLogin();
            }

            @Override
            public void onComplete() {

            }
        });
    }

    public interface LoginView extends BaseView{

        void userIsEmpty();

        void passIsEmpty();

        void passLow6();

        void success(String usuario, String pass);

        void SuccesLogin();
    }
}
