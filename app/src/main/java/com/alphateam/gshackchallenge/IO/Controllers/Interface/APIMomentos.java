package com.alphateam.gshackchallenge.IO.Controllers.Interface;

import com.alphateam.gshackchallenge.IO.Responses.MomentosItalika;
import com.alphateam.gshackchallenge.IO.Responses.MomentosItalikaResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.POST;

public interface APIMomentos {

    @POST("obtenerVerMomentos")
    public Call<MomentosItalikaResponse> getMomentos();


}
