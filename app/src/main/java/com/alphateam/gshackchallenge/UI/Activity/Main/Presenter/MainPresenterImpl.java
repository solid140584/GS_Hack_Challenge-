package com.alphateam.gshackchallenge.UI.Activity.Main.Presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.alphateam.gshackchallenge.Base.BasePresenterImpl;
import com.alphateam.gshackchallenge.Base.BaseView;
import com.alphateam.gshackchallenge.DI.Component.PerActivity;
import com.alphateam.gshackchallenge.Utils.ApplicationBase;
import com.alphateam.gshackchallenge.Utils.Constants;

import javax.inject.Inject;

@PerActivity
public class MainPresenterImpl extends BasePresenterImpl implements MainPresenter {

    MainView view;
    private boolean isLogged;

    @Inject
    public MainPresenterImpl() {
    }

    @Override
    public void register(BaseView view) {
        super.register(view);
        this.view = (MainView) view;
    }

    @Override
    public void ValidarLogin() {
        SharedPreferences pref = ApplicationBase.getIntance().getSharedPreferences(Constants.SHARED_PREFERENCES, Context.MODE_PRIVATE);
        isLogged = pref.getBoolean(Constants.LOGIN,false);
        view.isLogin(isLogged);
    }

    public interface MainView extends BaseView{

        void isLogin(Boolean isLogin);
    }
}