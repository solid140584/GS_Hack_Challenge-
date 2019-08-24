package com.alphateam.gshackchallenge.Base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.alphateam.gshackchallenge.Utils.ApplicationBase;
import com.alphateam.gshackchallenge.Utils.SpeechRecognitionListener;

import dagger.android.AndroidInjection;

public class BaseAppActivity extends AppCompatActivity implements BaseView {

    public TextToSpeech socioAsistente;
    public SpeechRecognizer speechRecognizer;
    public SpeechRecognitionListener speechRecognitionListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // AndroidInjection.inject(this);
        socioAsistente = ApplicationBase.getIntance().getSocioAsistente();
        speechRecognizer = ApplicationBase.getIntance().getSpeechRecognizer();

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

    /**
     * Inicializa el asistente de voz de Google
     */
    public void startVoiceRecognitionActivity() {

        speechRecognitionListener = new SpeechRecognitionListener();
        speechRecognizer.setRecognitionListener(speechRecognitionListener);

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        //Specify the calling package to identify your application
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,getClass().getPackage().getName());
        //Given an hint to the recognizer about what the user is going to say
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        //specify the max number of results
        intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS,5);
        //User of SpeechRecognizer to "send" the intent.
        speechRecognizer.startListening(intent);

    }

    /**
     * Permite al Asistente de Banco Azteca hablar un mensaje parametrizado.
     * @param mensaje
     */
    public void speakAsistente(String mensaje){

        socioAsistente.speak(mensaje, TextToSpeech.QUEUE_FLUSH, null, "");

    }
}