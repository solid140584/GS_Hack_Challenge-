package com.alphateam.gshackchallenge.UI.Activity.Splash.Presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.alphateam.gshackchallenge.Base.BasePresenterImpl;
import com.alphateam.gshackchallenge.Base.BaseView;
import com.alphateam.gshackchallenge.DI.Component.PerActivity;
import com.alphateam.gshackchallenge.Utils.ApplicationBase;
import com.alphateam.gshackchallenge.Utils.Constants;

import javax.inject.Inject;
@PerActivity
public class SplashPresenterImpl extends BasePresenterImpl implements SplashPresenter {
    SplashView view;
    private boolean isLogged;

    @Inject SplashPresenterImpl(){

    }

    @Override
    public void register(BaseView view) {
        super.register(view);
        this.view = (SplashView) view;
    }

    @Override
    public void validateLogin() {
        SharedPreferences pref = ApplicationBase.getIntance().getSharedPreferences(Constants.SHARED_PREFERENCES, Context.MODE_PRIVATE);
        isLogged = pref.getBoolean(Constants.LOGIN,false);
        if(isLogged){
            view.sendParameter(1);
        }else{
            view.sendParameter(0);
        }
    }

    public interface SplashView extends BaseView{

        void sendParameter(int i);
    }
}
