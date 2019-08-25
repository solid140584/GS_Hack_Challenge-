package com.alphateam.gshackchallenge.IO.Responses;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class CatalogoResponse implements Serializable {

    @SerializedName("cabResponse")
    cabResponse CabResponse;

    @SerializedName("lstLineas")
    ArrayList<Catalogos> lstCatalogos = new ArrayList<>();

    public cabResponse getCabResponse() {
        return CabResponse;
    }

    public void setCabResponse(cabResponse cabResponse) {
        CabResponse = cabResponse;
    }

    public ArrayList<Catalogos> getLstCalogos() {
        return lstCatalogos;
    }

    public void setLstCalogos(ArrayList<Catalogos> lstCalogos) {
        this.lstCatalogos = lstCalogos;
    }
}
