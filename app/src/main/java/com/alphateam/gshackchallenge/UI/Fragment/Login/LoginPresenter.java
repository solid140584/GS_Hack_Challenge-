package com.alphateam.gshackchallenge.UI.Fragment.Login;

import com.alphateam.gshackchallenge.Base.BasePresenter;

public interface LoginPresenter extends BasePresenter {
    void validateUser(String usuario,String pass);

    void Login(String usuario, String pass);
}
