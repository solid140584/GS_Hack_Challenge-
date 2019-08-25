package com.alphateam.gshackchallenge.UI.controllers;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alphateam.gshackchallenge.IO.Responses.MomentosItalika;
import com.alphateam.gshackchallenge.R;
import com.alphateam.gshackchallenge.Utils.ApplicationBase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.UUID;

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
    public void onBindViewHolder(@NonNull ViewHolderMomentos holder, int position) {
        holder.onBindHoleder(lst.get( position ));
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

        public void onBindHoleder(MomentosItalika momento){
            tvMomento.setText( momento.momento );
            new getImageFromUri(momento.url);
        }

        class getImageFromUri extends AsyncTask<Void, Void, Bitmap>{

            String uri;

            public getImageFromUri(String uri){
                this.uri = uri;
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected Bitmap doInBackground(Void... voids) {
                return loadImage();
            }

            @Override
            protected void onPostExecute(Bitmap bm) {
                super.onPostExecute( bm);
                if(bm != null) {
                    imgMomento.setImageBitmap( bm );
                }else{
                    imgMomento.setVisibility( View.GONE );
                }
            }

            private Bitmap loadImage(){
                try{
                    URL url = new URL(uri);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setDoInput( true );
                    connection.connect();

                    InputStream input = connection.getInputStream();
                    return BitmapFactory.decodeStream( input );

//                    uri = parseBitmapToUri( bitmap );
                }catch (IOException e){
                    return null;
                }
            }

//            private String parseBitmapToUri(Bitmap bitmap) throws IOException {
//                ContextWrapper wrapper = new ContextWrapper( ApplicationBase.getIntance().getApplicationContext().getApplicationContext());
//                File file = wrapper.getDir( "Image",Context.MODE_PRIVATE );
//                file = new File(file,"photoImage"+ UUID.randomUUID()+".jpg" );
//
//                OutputStream stream = new FileOutputStream(file);
//                bitmap.compress( Bitmap.CompressFormat.JPEG,100,stream );
//
//                stream.flush();
//                stream.close();
//
//                return file.getAbsolutePath();
//            }
        }
    }
}
