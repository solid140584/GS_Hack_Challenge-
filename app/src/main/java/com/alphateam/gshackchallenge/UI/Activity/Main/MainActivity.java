package com.alphateam.gshackchallenge.UI.Activity.Main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.SpeechRecognizer;
import android.text.TextUtils;
import android.view.textservice.SpellCheckerSession;

import com.alphateam.gshackchallenge.Base.BaseAppActivity;
import com.alphateam.gshackchallenge.R;
import com.alphateam.gshackchallenge.UI.Activity.Home.MiMomentoActivity;
import com.alphateam.gshackchallenge.UI.Activity.Main.Presenter.MainPresenter;
import com.alphateam.gshackchallenge.UI.Activity.Main.Presenter.MainPresenterImpl;
import com.alphateam.gshackchallenge.Utils.SpeechRecognitionListener;

import java.util.ArrayList;

import javax.inject.Inject;

public class MainActivity extends BaseAppActivity implements MainPresenterImpl.MainView{

    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setPresenter();
        startActivity(new Intent(this, MiMomentoActivity.class));

    }

    @Override
    public void initView() {
        super.initView();



    }

    @Override
    public void setListeners() {
        super.setListeners();

    }


    @Override
    public void setPresenter() {
        super.setPresenter();
        presenter.register(this);
    }

    @Override
    public void showLoader() {
        super.showLoader();
    }

    @Override
    public void hideLoader() {
        super.hideLoader();
    }


}