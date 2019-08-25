package com.alphateam.gshackchallenge.UI.Fragment.Momentos.MomentosPresenterImpl;

import android.util.Log;

import com.alphateam.gshackchallenge.Base.BasePresenterImpl;
import com.alphateam.gshackchallenge.Base.BaseView;
import com.alphateam.gshackchallenge.IO.Responses.MomentosItalika;
import com.alphateam.gshackchallenge.IO.Responses.MomentosItalikaResponse;
import com.alphateam.gshackchallenge.Utils.ApplicationBase;

import java.lang.reflect.Array;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentMomentosPresenterImpl extends BasePresenterImpl implements FragmentMomentosPresenter{

    FragmentMomentosView view;

    @Override
    public void register(BaseView view) {
        super.register(view);
        this.view=(FragmentMomentosView) view;
    }

    @Override
    public void getMomentos() {
        onShowLoader();
        ApplicationBase.getIntance().getControllerMomentos().getMomentos().enqueue( new Callback<MomentosItalikaResponse>() {
            @Override
            public void onResponse(Call<MomentosItalikaResponse> call, Response<MomentosItalikaResponse> response) {
                if(response.isSuccessful()){
                    if(response.body().cabResponse.codeResponse==0) {
                       if(response.body().lstMomentos != null) {
                           view.momentosList(response.body().lstMomentos);
                           onHideLoader();
                       }
                    }
                }
            }

            @Override
            public void onFailure(Call<MomentosItalikaResponse> call, Throwable t) {
                Log.v("as",t.getMessage());
            }
        } );
    }

    public interface FragmentMomentosView{
        void momentosList(ArrayList<MomentosItalika> lst);
    }
}
