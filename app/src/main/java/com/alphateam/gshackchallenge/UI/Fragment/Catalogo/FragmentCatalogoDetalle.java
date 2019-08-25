package com.alphateam.gshackchallenge.UI.Fragment.Catalogo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alphateam.gshackchallenge.Base.FragmentGSHackBase;
import com.alphateam.gshackchallenge.IO.Responses.Catalogos;
import com.alphateam.gshackchallenge.R;
import com.alphateam.gshackchallenge.Utils.Controls.AdapterCatalogos;

import java.util.ArrayList;

public class FragmentCatalogoDetalle extends FragmentGSHackBase implements FragmentCatalogoDetallePresenterImpl.FragmentCatalogoDetalleView {

    private View view;
    public static final String TAG = FragmentCatalogoDetalle.class.getSimpleName();
    FragmentCatalogoDetallePresenter presenter;
    private TextView tvModelo, tvColores, tvTipoDeMotor, tvCilindrada, tvVelocidad, tvCapacidad, tvPeso;

    /**
     * Metodo para enviar parametros desde la Activity
     * @param args
     * @return
     */
    public static FragmentCatalogoDetalle getInstantce(@Nullable Bundle args){
        FragmentCatalogoDetalle fragmentCatalogo = new FragmentCatalogoDetalle();
        if(args !=null){
            fragmentCatalogo.setArguments(args);
        }
        return  fragmentCatalogo;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

     view = inflater.inflate(R.layout.fragment_catalogo_detalle,container,false);

     setPresenter();

     return view;
    }


    @Override
    public void initView() {

        tvModelo = (TextView) view.findViewById(R.id.tvModelo);
        tvTipoDeMotor = (TextView) view.findViewById(R.id.tvTipoDeMotor);
        tvPeso = (TextView) view.findViewById(R.id.tvPeso);
        tvColores = (TextView) view.findViewById(R.id.tvColores);
        tvCilindrada = (TextView) view.findViewById(R.id.tvCilindrada);
        tvCapacidad  = (TextView) view.findViewById(R.id.tvCapacidad);
        tvVelocidad = (TextView) view.findViewById(R.id.tvVelocidad);

    }

    @Override
    public void setListeners() {

    }

    @Override
    public void setPresenter() {

        presenter = new FragmentCatalogoDetallePresenterImpl();
        presenter.register(this);
        presenter.setArguments(getArguments());

    }

    @Override
    public void showLoader() {

    }

    @Override
    public void hideLoader() {

    }

    @Override
    public Activity getActivityInstance() {
        return getActivityInstance();
    }


    @Override
    public void sendData(Catalogos item) {

          tvModelo.setText(item.getModelo());
          tvCapacidad.setText(item.getCapacidad());
          tvCilindrada.setText(item.getCilindrada());
          tvColores.setText(item.getColores());
          tvPeso.setText(item.getPeso());
          tvModelo.setText(item.getModelo());
          tvTipoDeMotor.setText(item.getTipoDeMotor());

    }
}