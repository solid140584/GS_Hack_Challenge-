package com.alphateam.gshackchallenge.UI.Fragment.Catalogo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alphateam.gshackchallenge.Base.FragmentGSHackBase;
import com.alphateam.gshackchallenge.IO.Responses.Catalogos;
import com.alphateam.gshackchallenge.IO.Responses.Sucursales;
import com.alphateam.gshackchallenge.R;
import com.alphateam.gshackchallenge.Utils.Constants;
import com.alphateam.gshackchallenge.Utils.Controls.AdapterCatalogos;

import java.util.ArrayList;


public class FragmentCatalogo extends FragmentGSHackBase implements FragmentCatalogoPresenterImpl.FragmentCatalogoView, AdapterCatalogos.OnAdapterClickListener{

    private View view;
    public static final String TAG = FragmentCatalogo.class.getSimpleName();
    FragmentCatalogoPresenter presenter;
    AdapterCatalogos adpt;
    ArrayList<Catalogos> listasucursales;
    private RecyclerView rvCatalogo;

    /**
     * Metodo para enviar parametros desde la Activity
     * @param args
     * @return
     */
    public static FragmentCatalogo getInstantce(@Nullable Bundle args){
        FragmentCatalogo fragmentCatalogo = new FragmentCatalogo();
        if(args !=null){
            fragmentCatalogo.setArguments(args);
        }
        return  fragmentCatalogo;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

     view = inflater.inflate(R.layout.fragment_catalogos,container,false);

     setPresenter();

     return view;
    }


    @Override
    public void initView() {

        rvCatalogo = (RecyclerView) view.findViewById(R.id.rvCatalogo);
        fillList();
        initRecyclerView(listasucursales);

    }

    @Override
    public void setListeners() {

    }

    @Override
    public void setPresenter() {

        presenter = new FragmentCatalogoPresenterImpl();
        presenter.register(this);
        presenter.getCatalogo();

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

    private void fillList(){

        listasucursales = new ArrayList<>();

        Catalogos trabajo = new Catalogos();
        trabajo.setId(0);
        trabajo.setNombre("Trabajo");
        trabajo.setModelo("FT127T");
        trabajo.setCilindrada("125cc");
        trabajo.setVelocidad("125km/h");
        trabajo.setCapacidad("16 L");
        trabajo.setPeso("188k.kg");
        trabajo.setColores("Negro con letrasa");
        trabajo.setPrecio("$8,000.00");
        listasucursales.add(trabajo);

        Catalogos motoneta = new Catalogos();
        motoneta.setId(1);
        motoneta.setNombre("Motoneta");
        listasucursales.add(motoneta);

        Catalogos linea = new Catalogos();
        linea.setId(2);
        linea.setNombre("Linea Z");
        listasucursales.add(linea);

        Catalogos depor = new Catalogos();
        depor.setId(3);
        depor.setNombre("Deportiva");
        listasucursales.add(depor);

        Catalogos doble = new Catalogos();
        doble.setId(4);
        doble.setNombre("Doble proposito");
        listasucursales.add(doble);

        Catalogos cuatri = new Catalogos();
        cuatri.setId(5);
        cuatri.setNombre("Cuatrimoto");
        listasucursales.add(cuatri);

        Catalogos chooper = new Catalogos();
        chooper.setId(6);
        chooper.setNombre("Chooper");
        listasucursales.add(chooper);

    }

    private void initRecyclerView(ArrayList<Catalogos> listasucursales){

        adpt = new AdapterCatalogos(getContext(),listasucursales,this);
        rvCatalogo.setLayoutManager(new GridLayoutManager(getContext(),2));
        rvCatalogo.setAdapter(adpt);

    }

    @Override
    public void sendToFragment(int position, Catalogos item) {

        Bundle bundle = new Bundle();
        bundle.putSerializable(Constants.CATALOGO,item);
        pushFragment(FragmentCatalogoDetalle.getInstantce(bundle),FragmentCatalogoDetalle.TAG,true,true);

    }

    /**
     * Llenamos la lista
     * @param lista
     */
    @Override
    public void sentList(ArrayList<Catalogos> lista) {

    }
}