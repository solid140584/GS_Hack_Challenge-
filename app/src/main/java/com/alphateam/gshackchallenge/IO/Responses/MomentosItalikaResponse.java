package com.alphateam.gshackchallenge.IO.Responses;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MomentosItalikaResponse extends BaseResponse {

    @SerializedName( "lstMomentos" )
    public ArrayList<MomentosItalika> lstMomentos;

    public ArrayList<MomentosItalika> getLstMomentos() {
        return lstMomentos;
    }

    public void setLstMomentos(ArrayList<MomentosItalika> lstMomentos) {
        this.lstMomentos = lstMomentos;
    }

    @Override
    public String toString() {
        return "MomentosItalikaResponse{" +
                "lstMomentos=" + lstMomentos +
                '}';
    }
}
