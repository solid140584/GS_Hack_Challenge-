package com.alphateam.gshackchallenge.IO.Controllers;



import com.alphateam.gshackchallenge.IO.Request.LoginRequest;
import com.alphateam.gshackchallenge.IO.Request.RegistroRequest;
import com.alphateam.gshackchallenge.IO.Responses.LoginResponse;
import com.alphateam.gshackchallenge.IO.Responses.RegistroResponse;
import com.alphateam.gshackchallenge.Utils.Constants;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APILogin {
    @POST(Constants.JWT_Login)
    Observable<LoginResponse> JWT_Login(@Body LoginRequest request);

    @POST(Constants.JWT_Registro)
    Observable<RegistroResponse> JWT_Registro(@Body RegistroRequest request);
}
