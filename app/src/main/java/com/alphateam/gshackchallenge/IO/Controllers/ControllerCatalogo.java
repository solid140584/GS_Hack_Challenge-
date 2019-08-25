package com.alphateam.gshackchallenge.IO.Controllers;

import android.content.Context;

import com.alphateam.gshackchallenge.IO.Controllers.Interface.APICatalogos;
import com.alphateam.gshackchallenge.IO.Controllers.Interface.APIMomentos;
import com.alphateam.gshackchallenge.IO.Responses.CatalogoResponse;
import com.alphateam.gshackchallenge.IO.Responses.Catalogos;
import com.alphateam.gshackchallenge.IO.Responses.MomentosItalikaResponse;

import retrofit2.Call;

public class ControllerCatalogo extends ControllerBase implements APICatalogos {

    APICatalogos serviceInterface = retrofit.create( APICatalogos.class );

    public ControllerCatalogo(Context ctx) {
        super( ctx,"http://siidmex-001-site4.etempurl.com/LineaProducto/" );
    }

    @Override
    public Call<CatalogoResponse> getcatalogos() {
        return serviceInterface.getcatalogos();
    }
}
