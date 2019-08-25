package com.alphateam.gshackchallenge.UI.Fragment.Momentos;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.alphateam.gshackchallenge.Base.FragmentGSHackBase;
import com.alphateam.gshackchallenge.IO.Responses.MomentosItalika;
import com.alphateam.gshackchallenge.R;
import com.alphateam.gshackchallenge.UI.Fragment.Momentos.MomentosPresenterImpl.FragmentMomentosPresenter;
import com.alphateam.gshackchallenge.UI.Fragment.Momentos.MomentosPresenterImpl.FragmentMomentosPresenterImpl;
import com.alphateam.gshackchallenge.UI.controllers.AdapterMomentos;

import java.util.ArrayList;

public class FragmentMomentos extends FragmentGSHackBase implements FragmentMomentosPresenterImpl.FragmentMomentosView {

    View v;
    RecyclerView rvMomentos;
    FloatingActionButton faAdd;
    FragmentMomentosPresenter presenter;

    public static final String TAG = FragmentMomentos.class.getSimpleName();
    public static FragmentMomentos getInstantce(@Nullable Bundle args){
        FragmentMomentos fm = new FragmentMomentos();
        if(args !=null){
            fm.setArguments(args);
        }
        return  fm;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate( R.layout.fragment_momentos,container,false );
        presenter = new FragmentMomentosPresenterImpl();
        presenter.register( this );
        presenter.getMomentos();
        return  v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult( requestCode, resultCode, data );
    }

    @Override
    public void initView(){
        rvMomentos = v.findViewById( R.id.rvMomentos );
        faAdd = v.findViewById( R.id.fabAdd );
    }

    @Override
    public void setListeners(){
        faAdd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogAdd dialog = new DialogAdd();
                dialog.show( getFragmentManager() , TAG);
            }
        } );
    }

    @Override
    public void momentosList(ArrayList<MomentosItalika> lst) {
        if(lst.size()>0) {
            setRecycler( lst );
        }else{
//            TODO implementar pantalla de lista vacía o navegar a fragment catalogo
        }
    }

    public void setRecycler(ArrayList<MomentosItalika> lst){
        AdapterMomentos adapterMomentos = new AdapterMomentos( getContext(), lst );
        rvMomentos.setLayoutManager( new LinearLayoutManager( getContext(),LinearLayout.VERTICAL ,false));
        rvMomentos.setAdapter( adapterMomentos );
    }
}
