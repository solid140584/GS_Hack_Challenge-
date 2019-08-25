package com.alphateam.gshackchallenge.IO.Controllers.Interface;

import com.alphateam.gshackchallenge.IO.Responses.CatalogoResponse;
import com.alphateam.gshackchallenge.IO.Responses.Catalogos;
import com.alphateam.gshackchallenge.IO.Responses.MomentosItalikaResponse;

import retrofit2.Call;
import retrofit2.http.POST;

public interface APICatalogos {

    @POST("obtenerLineas")
    public Call<CatalogoResponse> getcatalogos();

}
