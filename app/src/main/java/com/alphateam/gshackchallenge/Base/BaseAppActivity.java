package com.alphateam.gshackchallenge.Base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import dagger.android.AndroidInjection;

public class BaseAppActivity extends AppCompatActivity implements BaseView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
    }

    @Override
    public void initView() {

    }

    @Override
    public void setListeners() {

    }

    @Override
    public void setPresenter() {

    }

    /**
     * Activa el progress
     */
    @Override
    public void showLoader() {

    }

    /**
     *Desactiva el Progress
     */
    @Override
    public void hideLoader() {

    }

    @Override
    public Activity getActivityInstance() {
        return this;
    }

    /**
     *
     * @param mensaje
     */
    public void showMensaje(String mensaje){

        Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();
    }
}