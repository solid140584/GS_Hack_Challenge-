package com.alphateam.gshackchallenge.IO.Responses;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MomentosItalika implements Serializable {

    @SerializedName( "texto" )
    public String momento;

    @SerializedName( "imagen" )
    public String url;

    @SerializedName( "idEmoticon" )
    public int idEmoticon;

    public String getMomento() {
        return momento;
    }

    public void setMomento(String momento) {
        this.momento = momento;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getIdEmoticon() {
        return idEmoticon;
    }

    public void setIdEmoticon(int idEmoticon) {
        this.idEmoticon = idEmoticon;
    }

    @Override
    public String
    toString() {
        return "MomentosItalika{" +
                "momento='" + momento + '\'' +
                ", url='" + url + '\'' +
                ", idEmoticon=" + idEmoticon +
                '}';
    }
}
