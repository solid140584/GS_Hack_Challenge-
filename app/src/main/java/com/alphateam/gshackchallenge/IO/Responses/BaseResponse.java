package com.alphateam.gshackchallenge.IO.Responses;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BaseResponse implements Serializable {

    @SerializedName( "cabResponse" )
    public cabResponse cabResponse;
}
