package com.alphateam.gshackchallenge.UI.Fragment.Catalogo;

import com.alphateam.gshackchallenge.Base.BasePresenterImpl;
import com.alphateam.gshackchallenge.Base.BaseView;
import com.alphateam.gshackchallenge.IO.Responses.CatalogoResponse;
import com.alphateam.gshackchallenge.IO.Responses.Catalogos;
import com.alphateam.gshackchallenge.Utils.ApplicationBase;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentCatalogoPresenterImpl extends BasePresenterImpl implements FragmentCatalogoPresenter {

    FragmentCatalogoView view;

    @Override
    public void register(BaseView view) {
        super.register(view);
        this.view = (FragmentCatalogoView) view;
    }

    @Override
    public void getCatalogo() {
        ApplicationBase.getIntance().getControllerCatalogo().getcatalogos().enqueue(new Callback<CatalogoResponse>() {
            @Override
            public void onResponse(Call<CatalogoResponse> call, Response<CatalogoResponse> response) {
                if(response.isSuccessful()){
                    if(response.body().getCabResponse().codeResponse==0){

                        view.sentList(response.body().getLstCalogos());

                    }
                }
            }

            @Override
            public void onFailure(Call<CatalogoResponse> call, Throwable t) {

            }
        });
    }

    public interface FragmentCatalogoView extends BaseView{

          void sentList(ArrayList<Catalogos> lista);

    }
}
