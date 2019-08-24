package com.alphateam.gshackchallenge.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.support.multidex.MultiDexApplication;
import android.util.Log;
import android.widget.Toast;

//import com.alphateam.gshackchallenge.DI.Module.DaggerAppComponent;
import com.alphateam.gshackchallenge.IO.Rest.ControllerAPI;
import com.facebook.stetho.Stetho;

import java.util.Locale;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by ISC Jesús Romero Mtz on 24/08/2019
 */
public class ApplicationBase extends MultiDexApplication {

    private static Context context;
    public static ApplicationBase instance;
    public static String IPDeviceAddress;
    private ControllerAPI controllerAPI;

    private String setIdSesion;
    private String cookie;
    private SpeechRecognizer speechRecognizer;
    private TextToSpeech socioAsistente;

    @Inject
    DispatchingAndroidInjector<Activity> activityInjector;

    public void onCreate() {
        super.onCreate();
        initApplication();
      //  DaggerAppComponent.builder().create(this).inject(this);
    }

    public static ApplicationBase getIntance() {
        if (instance == null) {
            instance = new ApplicationBase();
            instance.initApplication();
        }
        return instance;
    }

    private void initApplication() {

        instance = this;

        context = getApplicationContext();

        Stetho.initializeWithDefaults(this);

        socioAsistente = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                if (status == TextToSpeech.SUCCESS) {
                    int ttsLang = socioAsistente.setLanguage(Locale.getDefault());
                    if (ttsLang == TextToSpeech.LANG_MISSING_DATA || ttsLang == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "The Language is not supported!");
                    } else {
                        Log.i("TTS", "Language Supported.");
                    }
                    Log.i("TTS", "Initialization success.");
                } else {
                    Toast.makeText(getApplicationContext(), "TTS Initialization failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
    }

    public static Context getAppContext() {
        return ApplicationBase.context;
    }

    public void setIdSesion(String setIdSesion) {
        this.setIdSesion = setIdSesion;
    }

    public String getIdSesion() {
        return this.setIdSesion;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public String getCookie() {
        return cookie;
    }

    public SpeechRecognizer getSpeechRecognizer() {
        return speechRecognizer;
    }

    public void setSpeechRecognizer(SpeechRecognizer speechRecognizer) {
        this.speechRecognizer = speechRecognizer;
    }

    public TextToSpeech getSocioAsistente() {
        return socioAsistente;
    }

    public void setSocioAsistente(TextToSpeech socioAsistente) {
        this.socioAsistente = socioAsistente;
    }



}