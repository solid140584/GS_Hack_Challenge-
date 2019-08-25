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

import com.alphateam.gshackchallenge.DI.Module.DaggerAppComponent;
import com.alphateam.gshackchallenge.IO.Controllers.ControllerCatalogo;
import com.alphateam.gshackchallenge.IO.Controllers.ControllerLogin;

import com.alphateam.gshackchallenge.IO.Controllers.ControllerMomentos;
import com.facebook.stetho.Stetho;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by ISC Jesús Romero Mtz on 24/08/2019
 */
public class ApplicationBase extends MultiDexApplication implements HasActivityInjector {

    private static Context context;
    public static ApplicationBase instance;
    public static String IPDeviceAddress;
    private ControllerMomentos controllerMomentos;
    private ControllerCatalogo controllerCatalogo;

    //private ControllerAPI controllerAPI;
    private ControllerLogin mControllerLogin;



    private IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
    private String setIdSesion;
    private String cookie;

    private TextToSpeech socioAsistente;
    private SpeechRecognizer speechRecognizer;

    @Inject
    DispatchingAndroidInjector<Activity> activityInjector;

    public void onCreate() {
        super.onCreate();
        initApplication();
        DaggerAppComponent.builder().create(this).inject(this);
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
        controllerMomentos = new ControllerMomentos(context);
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

        controllerMomentos = new ControllerMomentos(context);
        controllerCatalogo = new ControllerCatalogo(context);
        mControllerLogin = new ControllerLogin(context,"http://siidmex-001-site4.etempurl.com/Usuario/");

    }

    public ControllerMomentos getControllerMomentos(){
        return controllerMomentos;
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

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityInjector;
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

    public ControllerCatalogo getControllerCatalogo() {
        return controllerCatalogo;
    }

    public void setControllerCatalogo(ControllerCatalogo controllerCatalogo) {
        this.controllerCatalogo = controllerCatalogo;

    }

    public ControllerLogin getmControllerLogin() {
        return mControllerLogin;
    }

    public void setmControllerLogin(ControllerLogin mControllerLogin) {
        this.mControllerLogin = mControllerLogin;
    }

    public void setControllerMomentos(ControllerMomentos controllerMomentos) {
        this.controllerMomentos = controllerMomentos;

    }
}