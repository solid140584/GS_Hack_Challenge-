package com.alphateam.gshackchallenge.IO.Controllers;

import android.content.Context;

import com.alphateam.gshackchallenge.IO.Controllers.Interface.APIMomentos;
import com.alphateam.gshackchallenge.IO.Responses.MomentosItalika;
import com.alphateam.gshackchallenge.IO.Responses.MomentosItalikaResponse;

import java.util.ArrayList;

import retrofit2.Call;

public class ControllerMomentos extends ControllerBase implements APIMomentos {
    APIMomentos serviceInterface = retrofit.create( APIMomentos.class );

    public ControllerMomentos(Context ctx) {
        super( ctx,"http://siidmex-001-site4.etempurl.com/Momentos/" );
    }

    @Override
    public Call<MomentosItalikaResponse> getMomentos() {
        return serviceInterface.getMomentos();
    }
}
