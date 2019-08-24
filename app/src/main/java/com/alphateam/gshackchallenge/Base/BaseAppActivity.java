package com.alphateam.gshackchallenge.Base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class BaseAppActivity extends AppCompatActivity implements BaseView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {

    }

    @Override
    public void implementOnClickListener() {

    }

    @Override
    public void setPresenter() {

    }

    //TODO Activa el progress
    @Override
    public void showLoader() {

    }

    // TODO Desactiva el Progress
    @Override
    public void hideLoader() {

    }

    @Override
    public Activity getActivityInstance() {
        return this;
    }

    //TODO puede invocarlo en cualquier activity
    public void showMensaje(String mensaje){

    }
}