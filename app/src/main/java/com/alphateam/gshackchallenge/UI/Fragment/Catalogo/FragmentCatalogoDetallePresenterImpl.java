package com.alphateam.gshackchallenge.UI.Fragment.Catalogo;

import android.os.Bundle;

import com.alphateam.gshackchallenge.Base.BasePresenterImpl;
import com.alphateam.gshackchallenge.Base.BaseView;
import com.alphateam.gshackchallenge.IO.Responses.Catalogos;
import com.alphateam.gshackchallenge.IO.Responses.Sucursales;
import com.alphateam.gshackchallenge.Utils.Constants;

public class FragmentCatalogoDetallePresenterImpl extends BasePresenterImpl implements FragmentCatalogoDetallePresenter {

    FragmentCatalogoDetalleView view;
    private Catalogos item;

    @Override
    public void register(BaseView view) {
        super.register(view);
        this.view = (FragmentCatalogoDetalleView) view;
    }

    @Override
    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
        if(bundle != null){

            item = (Catalogos) bundle.getSerializable(Constants.CATALOGO);
            if(item != null){

                view.sendData(item);

            }
        }
    }

    public interface FragmentCatalogoDetalleView extends BaseView{
          void sendData(Catalogos item);
    }
}