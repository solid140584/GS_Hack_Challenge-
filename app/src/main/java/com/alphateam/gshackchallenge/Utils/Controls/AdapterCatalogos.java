package com.alphateam.gshackchallenge.Utils.Controls;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alphateam.gshackchallenge.IO.Responses.Catalogos;
import com.alphateam.gshackchallenge.IO.Responses.Sucursales;
import com.alphateam.gshackchallenge.R;

import java.util.ArrayList;


public class AdapterCatalogos extends RecyclerView.Adapter<ViewHolderCatalogos> {

    private ArrayList<Catalogos> listaPersonajes;
    private Context context;
    private OnAdapterClickListener listener;
    private View view;

    //2.- Creamos una constructor para transmitir ciertos elementos del fragmento al Adapter
    public AdapterCatalogos(Context context, ArrayList<Catalogos> lista, OnAdapterClickListener listener) {

        //Los compartimos con nuestras variables globales
        this.context = context;
        this.listaPersonajes = lista;
        this.listener = listener;

    }

    //3.- Declaramos que item (XML) va a inflar  a nuestro adapter
    @NonNull
    @Override
    public ViewHolderCatalogos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_sucursales, viewGroup, false);
        ViewHolderCatalogos viewHolderCatalogos = new ViewHolderCatalogos(view);

        return viewHolderCatalogos;
    }

    //5.- Declarar un item del tipo personajes para setear los datos a  nuestro viewHolder
    @Override
    public void onBindViewHolder(@NonNull final ViewHolderCatalogos holder, final int position) {

        final Catalogos item = listaPersonajes.get(position);//Instanciamos nuestro item con el objeto del tipo personajes de nuestra lista


        EnumCatalogos enumCatalogos = EnumCatalogos.getFromId(item.getId());

        switch (enumCatalogos) {

            case MOTONETA:

                holder.ivMoto.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_motoneta));

                break;

            case TRABAJO:

                holder.ivMoto.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_trabajo));

                break;

            case LINEAZ:

                holder.ivMoto.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_lineaz));

                break;

            case DOBLE:

                holder.ivMoto.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_doble));

                break;

            case CHOOPER:

                holder.ivMoto.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_chooper));

                break;

        }

        holder.tvTitle.setText(item.getNombre());


        holder.rlContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listener.sendToFragment(position, item);

            }
        });
    }

    /**
     * 4.- Regresamos el tamaño de la lista
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return listaPersonajes.size();//con esto regresamos el tamaño de la lista
    }

    /**
     * Declarando la clase tipo interface que servira como canal de comunicación entre el adapter y el fragmento para escuchar cual elemento es presionado de la lista
     */
    public interface OnAdapterClickListener {

        void sendToFragment(int position, Catalogos item);

    }
}