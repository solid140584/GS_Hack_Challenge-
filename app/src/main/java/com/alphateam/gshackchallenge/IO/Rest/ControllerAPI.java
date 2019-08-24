package com.alphateam.gshackchallenge.IO.Rest;

import android.content.Context;

import com.alphateam.gshackchallenge.Base.ControllerBase;
import com.alphateam.gshackchallenge.Utils.Constants;

import retrofit2.Retrofit;

/**
 * Created by ISC Jesús Romero Mtz on 23/09/2018
 */
public class ControllerAPI extends ControllerBase implements APIServiceInterface {

    public static final String TAG = "CONTROLLER";
    private APIServiceInterface serviceInterface;


    public ControllerAPI(Context context) {
        super(context, Constants.DOMAIN_URL);
        this.serviceInterface = getRetrofitClient().create(APIServiceInterface.class);
    }

    public ControllerAPI(Context context, String urlBase) {
        super(context, urlBase);
        this.serviceInterface = getRetrofitClient().create(APIServiceInterface.class);
    }

    @Override
    public Retrofit generateBaseUrl(String url) {
        super.generateBaseUrl(url);
        this.serviceInterface = retrofit.create(APIServiceInterface.class);
        return retrofit;
    }

}
