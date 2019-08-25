package com.alphateam.gshackchallenge.Utils.Controls;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alphateam.gshackchallenge.R;

public class ViewHolderCatalogos extends RecyclerView.ViewHolder {

    public ImageView ivMoto;
    public TextView tvTitle;
    public CardView cvMoto;
    public RelativeLayout rlContent;

    public ViewHolderCatalogos(@NonNull View itemView) {
        super(itemView);

        cvMoto = itemView.findViewById(R.id.cvMoto);
        tvTitle = itemView.findViewById(R.id.tvTitle);
        ivMoto = itemView.findViewById(R.id.ivMoto);
        rlContent = itemView.findViewById(R.id.rlContent);

    }
}