package com.alphateam.gshackchallenge.UI.controllers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alphateam.gshackchallenge.IO.Responses.MomentosItalika;
import com.alphateam.gshackchallenge.R;

import java.util.ArrayList;

public class AdapterMomentos extends RecyclerView.Adapter <AdapterMomentos.ViewHolderMomentos>{

    Context ctx;
    ArrayList<MomentosItalika> lst;
    View v ;

    public AdapterMomentos (Context ctx, ArrayList<MomentosItalika> lst) {
        this.ctx = ctx;
        this.lst = lst;
    }


    @NonNull
    @Override
    public ViewHolderMomentos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v = LayoutInflater.from( ctx ).inflate( R.layout.item_momentos,viewGroup,false );
        return new ViewHolderMomentos(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderMomentos viewHolderMomentos, int i) {

    }

    @Override
    public int getItemCount() {
        return lst.size();
    }

    class ViewHolderMomentos extends RecyclerView.ViewHolder{

        TextView tvMomento;
        ImageView imgMomento;

        public ViewHolderMomentos(@NonNull View v) {
            super( v);
            tvMomento = v.findViewById( R.id.tvMomento );
            imgMomento = v.findViewById( R.id.imgMomento );
        }

        public void onBindHoleder(){

        }


    }
}
