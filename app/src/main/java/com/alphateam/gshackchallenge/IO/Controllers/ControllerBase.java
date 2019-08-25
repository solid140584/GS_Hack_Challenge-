package com.alphateam.gshackchallenge.IO.Controllers;

import android.content.Context;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ControllerBase{

    Context ctx ;
    protected Retrofit retrofit;
    public HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

    public ControllerBase (Context ctx) {
        this.ctx = ctx;
    }

    public ControllerBase (Context ctx, String url) {
        this.ctx = ctx;
        retrofit = getClienRetrofit(url);
    }

    private OkHttpClient.Builder getClienHttp() {
        interceptor =new HttpLoggingInterceptor();
         interceptor.setLevel( HttpLoggingInterceptor.Level.BODY );
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout( 60, TimeUnit.SECONDS );
        httpClient.readTimeout( 60,TimeUnit.SECONDS);
         httpClient.addInterceptor( interceptor );
        httpClient.addNetworkInterceptor( new StethoInterceptor() );
        return httpClient;
    }

    public Retrofit getClienRetrofit(String url ) {
        return new Retrofit.Builder()
                .addConverterFactory( GsonConverterFactory.create() )
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl( getURLBaseFormat( url ))
                .client( getClienHttp().build() )
                .build();
    }

    public String getURLBaseFormat(String url) {
        return url.endsWith( "/" ) ? url : url + "/";
    }

}