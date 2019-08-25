package com.alphateam.gshackchallenge.UI.Activity.Main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.SpeechRecognizer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.textservice.SpellCheckerSession;

import com.alphateam.gshackchallenge.Base.BaseAppActivity;
import com.alphateam.gshackchallenge.R;
import com.alphateam.gshackchallenge.UI.Activity.Home.MiMomentoActivity;
import com.alphateam.gshackchallenge.UI.Activity.Main.Presenter.MainPresenter;
import com.alphateam.gshackchallenge.UI.Activity.Main.Presenter.MainPresenterImpl;
import com.alphateam.gshackchallenge.UI.Fragment.Login.FragmentLogin;
import com.alphateam.gshackchallenge.Utils.SpeechRecognitionListener;

import java.util.ArrayList;

import javax.inject.Inject;

public class MainActivity extends BaseAppActivity implements MainPresenterImpl.MainView{
    private Fragment conteiner;
    private FragmentTransaction fragmentTransaction;

    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setPresenter();
        presenter.ValidarLogin();



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

    public void pushFragment(Fragment fragment, String TAG, boolean backStack, boolean animation){
        if(!isFinishing()){

            this.conteiner = fragment;
            fragmentTransaction = getSupportFragmentManager().beginTransaction();

            if(animation){

                fragmentTransaction.setCustomAnimations(R.anim.aparecer_fragmento,R.anim.desaparecer_fragmento,R.anim.aparecer_fragmento,R.anim.desaparecer_fragmento);

            }

            fragmentTransaction.replace(R.id.frameLayout1,conteiner);//Reemplaza nuestro contenedor (FragmentA, FragmentB ó FragmentC por el fragment que deseamos)

            if(backStack) {

                fragmentTransaction.addToBackStack(TAG);

            }
            fragmentTransaction.commitAllowingStateLoss();

        }
    }

    @Override
    public void isLogin(Boolean isLogin) {
        if(isLogin){
            startActivity(new Intent(this, MiMomentoActivity.class));
        }else {
            pushFragment(FragmentLogin.getInstance(null),FragmentLogin.TAG,true,true);
        }
    }
}