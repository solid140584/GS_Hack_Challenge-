package com.alphateam.gshackchallenge.Base;

import android.content.Context;
import android.util.Log;

import com.alphateam.gshackchallenge.Utils.Constants;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ISC Jesús Romero Mtz on 24/08/2019
 */
public class ControllerBase {
    protected Retrofit retrofit;
    protected Context context;
    private static final String TAG = "ControllerBase";

    private OkHttpClient.Builder getClientHttp() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(60, TimeUnit.SECONDS);
        httpClient.readTimeout(60, TimeUnit.SECONDS);
        httpClient.addNetworkInterceptor(new StethoInterceptor());

        return httpClient;
    }

    public ControllerBase(Context context, String urlBase) {
        this.context = context;
        retrofit = getClientRetrofit(urlBase, false);
    }

    public ControllerBase(Context context, String urlBase,boolean acceptNulls) {
        this.context = context;
        retrofit = getClientRetrofit(urlBase, acceptNulls);
    }

    public ControllerBase(Context context, HostnameVerifier hostnameVerifier, String urlBase) {
        this.context = context;
        retrofit = getClientRetrofit(urlBase,false);
    }

    private Retrofit getClientRetrofit(String urlBase, boolean acceptNulls) {

        Log.d(TAG, "getClientRetrofit:" + urlBase);

        return new Retrofit.Builder()
                .addConverterFactory(acceptNulls ? GsonConverterFactory.create(new GsonBuilder().serializeNulls().create()) : GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(getUrlBaseFormat(urlBase))
                .client(getClientHttp().build())
                .build();
    }


    public String getUrlBaseFormat(String urlBase) {
        return urlBase.endsWith("/") ? urlBase : urlBase.concat("/");
    }

    /*OBTIENE RETROFIT CLIENTE*/
    protected Retrofit getRetrofitClient() {
        return retrofit;
    }

    protected Retrofit generateBaseUrl(String url) {
        //VERIFICA SI ES HTTPS O NO
        if (url.startsWith(Constants.IS_HTTPS)) {
            retrofit = getClientRetrofit(url, false);
        }
        //GENERA UN CLIENTE SIN AUTENTIFICACIÓN
        else {
            retrofit = getClientRetrofit(url,  false);
        }
        return retrofit;
    }
}