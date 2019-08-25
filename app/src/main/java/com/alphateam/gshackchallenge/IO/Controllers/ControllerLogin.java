package com.alphateam.gshackchallenge.IO.Controllers;

import android.content.Context;


import com.alphateam.gshackchallenge.IO.Request.LoginRequest;
import com.alphateam.gshackchallenge.IO.Request.RegistroRequest;
import com.alphateam.gshackchallenge.IO.Responses.LoginResponse;
import com.alphateam.gshackchallenge.IO.Responses.RegistroResponse;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class ControllerLogin extends ControllerBase implements APILogin{
    private APILogin serviceInterface;

    public ControllerLogin(Context ctx) {
        super(ctx);
    }

    public ControllerLogin(Context ctx, String url) {
        super(ctx, url);
        this.serviceInterface =retrofit.create(APILogin.class);
    }


    @Override
    public Observable<LoginResponse> JWT_Login(LoginRequest request) {
        return serviceInterface.JWT_Login(request).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<RegistroResponse> JWT_Registro(RegistroRequest request) {
        return serviceInterface.JWT_Registro(request).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
