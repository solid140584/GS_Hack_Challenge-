package com.alphateam.gshackchallenge.IO.Responses;

import com.google.gson.annotations.SerializedName;

public class cabResponse {

    @SerializedName( "mensajeResponse" )
    public String mensajeResponse;

    @SerializedName( "codeResponse" )
    public int codeResponse;

    public String getMensajeResponse() {
        return mensajeResponse;
    }

    public void setMensajeResponse(String mensajeResponse) {
        this.mensajeResponse = mensajeResponse;
    }

    public int getCodeResponse() {
        return codeResponse;
    }

    public void setCodeResponse(int codeResponse) {
        this.codeResponse = codeResponse;
    }

    @Override
    public String toString() {
        return "cabResponse{" +
                "mensajeResponse='" + mensajeResponse + '\'' +
                ", codeResponse='" + codeResponse + '\'' +
                '}';
    }
}
