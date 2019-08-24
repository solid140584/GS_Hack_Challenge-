package com.alphateam.gshackchallenge.UI.Activity.Main;

import android.os.Bundle;
import android.os.Handler;
import android.speech.SpeechRecognizer;

import com.alphateam.gshackchallenge.Base.BaseAppActivity;
import com.alphateam.gshackchallenge.R;
import com.alphateam.gshackchallenge.UI.Activity.Main.Presenter.MainPresenter;
import com.alphateam.gshackchallenge.UI.Activity.Main.Presenter.MainPresenterImpl;
import com.alphateam.gshackchallenge.Utils.SpeechRecognitionListener;

import java.util.ArrayList;

import javax.inject.Inject;

public class MainActivity extends BaseAppActivity implements MainPresenterImpl.MainView, SpeechRecognitionListener.SpListener {

   // @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setPresenter();

    }

    @Override
    public void initView() {
        super.initView();

        speakAsistente("Hola socio, ¿En qué puedo ayudarte?");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                startVoiceRecognitionActivity();
                speechRecognitionListener.setOnClickListener(MainActivity.this);

            }
        }, 100);
    }

    @Override
    public void setListeners() {
        super.setListeners();
    }

    @Override
    public void setPresenter() {
        super.setPresenter();
        presenter = new MainPresenterImpl();
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

    /**
     *
     * @param results
     */
    @Override
    public void onResults(Bundle results) {

        ArrayList<String> matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);

        if(String.valueOf(matches.get(0).toUpperCase()).equals("BANCO AZTECA")){

            showMensaje("Mensaje de prueba Exitoso ");

        }

    }

    @Override
    public void onError(String error) {
       speakAsistente("Lo siento, no he podido procesar tu petición, podrías repetirme el mensaje por favor");
    }
}