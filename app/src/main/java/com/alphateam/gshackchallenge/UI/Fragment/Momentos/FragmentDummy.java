package com.alphateam.gshackchallenge.UI.Fragment.Momentos;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alphateam.gshackchallenge.Base.FragmentGSHackBase;
import com.alphateam.gshackchallenge.R;


public class FragmentDummy extends FragmentGSHackBase {

    private View view;


    /**
     * Metodo para enviar parametros desde la Activity
     * @param args
     * @return
     */
    public static FragmentDummy getInstantce(@Nullable Bundle args){
        FragmentDummy fragmentDummy = new FragmentDummy();
        if(args !=null){
            fragmentDummy.setArguments(args);
        }
        return  fragmentDummy;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     view = inflater.inflate(R.layout.fragment_dummy,container,false);

     initUI();
     return view;
    }

    private void initUI(){


        Bundle bundle = getArguments(); //Creamos un bundle y recibimos el bundle del mainActivity
        if(bundle != null){ //Validamos que el bundle no  venga nulo

        }
    }
}