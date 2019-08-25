package com.alphateam.gshackchallenge.UI.Activity.Splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import com.alphateam.gshackchallenge.Base.BaseAppActivity;
import com.alphateam.gshackchallenge.R;
import com.alphateam.gshackchallenge.UI.Activity.Home.MiMomentoActivity;
import com.alphateam.gshackchallenge.UI.Activity.Main.MainActivity;
import com.alphateam.gshackchallenge.UI.Activity.Splash.Presenter.SplashPresenter;
import com.alphateam.gshackchallenge.UI.Activity.Splash.Presenter.SplashPresenterImpl;
import com.alphateam.gshackchallenge.Utils.Constants;

import javax.inject.Inject;

public class SplashActivity extends BaseAppActivity implements SplashPresenterImpl.SplashView{
    @Inject
    SplashPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setPresenter();
        presenter.validateLogin();
    }

    @Override
    public void initView() {

    }

    @Override
    public void setListeners() {

    }

    @Override
    public void setPresenter() {
        super.setPresenter();
        presenter.register(this);

    }

    @Override
    public void showLoader() {

    }

    @Override
    public void hideLoader() {

    }

    @Override
    public Activity getActivityInstance() {
        return null;
    }

    @Override
    public void sendParameter(final int identificador) {
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(SplashActivity.this, identificador==1 ? MiMomentoActivity.class: MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt(Constants.LOGIN,identificador);
                i.putExtras(bundle);
                startActivity(i);
                finish();

            }
        },800);
    }
}
