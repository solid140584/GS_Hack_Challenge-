package com.alphateam.gshackchallenge.UI.Fragment.Momentos;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.media.ExifInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.alphateam.gshackchallenge.R;
import com.alphateam.gshackchallenge.Utils.ApplicationBase;
import com.alphateam.gshackchallenge.Utils.Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.internal.Util;

import static android.app.Activity.RESULT_OK;

public class DialogAdd extends DialogFragment implements View.OnClickListener {

    EditText etMomento;
    ImageView imgGaleria, imgCamera;
    Button btnMomento;
    String momentoItalika;
    boolean btnisClicked;
    private static final int WRITE_EXTERNAL_PERMISSION = 100;
    private static final int CAMERA_PERMISSION = 200;
    private String mPhoto;
    private Uri imageUriCamara, imageUriGallery;
    private String nameFile, nombreImagen;
    private static final String TAG = DialogAdd.class.getSimpleName();
    Bitmap selectedBitmap;
    private ImageView imgMiniatura;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView( inflater, container, savedInstanceState );
        View v = inflater.inflate( R.layout.item_agregar_momento, container, false );
        initView( v );
        return v;
    }

    public void initView(View v) {
        etMomento = v.findViewById( R.id.etMomento );
        imgGaleria = v.findViewById( R.id.imgGaleria );
        imgCamera = v.findViewById( R.id.imgCamera );
        btnMomento = v.findViewById( R.id.btnMomento );
        imgMiniatura = v.findViewById( R.id.imgMiniatura );
        setListeners();
    }

    private void setListeners() {
        imgCamera.setOnClickListener( this );
        imgGaleria.setOnClickListener( this );
        btnMomento.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgGaleria: {
//                Toast.makeText( getContext(),"imgGalería",Toast.LENGTH_SHORT ).show();
                if (ContextCompat.checkSelfPermission( ApplicationBase.getAppContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE ) == PackageManager.PERMISSION_GRANTED) {
                    Intent i = new Intent( Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI );
                    startActivityForResult( i, 4415 );
                } else {
                    requestPermissions( new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_EXTERNAL_PERMISSION );
                }
            }
            break;
            case R.id.imgCamera: {
//                Toast.makeText( getContext(),"imgCamera",Toast.LENGTH_SHORT ).show();
                if (ContextCompat.checkSelfPermission( ApplicationBase.getAppContext(), Manifest.permission.CAMERA ) == PackageManager.PERMISSION_GRANTED) {
                    getImageFromCamera();
                } else {
                    requestPermissions( new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION );
                }
            }
            break;
            case R.id.btnMomento: {
                Toast.makeText( getContext(), "btnMomento", Toast.LENGTH_SHORT ).show();
                momentoItalika = etMomento.getText().toString();
                btnisClicked = true;
                dismiss();
            }
            break;
            default: {
                Toast.makeText( getContext(), "imgDefault", Toast.LENGTH_SHORT ).show();
            }
        }
    }

    public boolean deletePreview() {
        String gsg = Environment.getExternalStorageDirectory() + "/Android/data/com.alphateam.gshackchallenge/files/Pictures";
        File dir = new File( gsg );
        if (dir.isDirectory()) {
            String[] hijos = dir.list();
            for (int i = 0; i < hijos.length; i++) {
                return new File( dir, hijos[i] ).delete();
            }
        }
        return true;
    }

    public void getImageFromCamera() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {

            imageUriCamara = null;
            deletePreview();
            Intent cameraIntent = new Intent( android.provider.MediaStore.ACTION_IMAGE_CAPTURE );
            File photo = null;
            try {
                photo = createImageFile();
                nameFile = photo.toString();
            } catch (IOException ex) {
                Log.e( TAG, ex.getMessage() );
            }
            Uri photoURI = FileProvider.getUriForFile( getContext(), "com.alphateam.gshackchallenge", photo );
            cameraIntent.putExtra( MediaStore.EXTRA_OUTPUT, photoURI );
            imageUriCamara = Uri.fromFile( photo );
            startActivityForResult( cameraIntent, 4416 );

        } else {
            imageUriCamara = null;
            selectedBitmap = null;
            nombreImagen = "";
            deletePreview();
            final String dir = getActivity().getExternalFilesDir( Environment.DIRECTORY_PICTURES ) + "/";
            File newdir = new File( dir );
            if (newdir.mkdirs()) {
                Log.e( TAG, "Se creo el Dir" );
            } else {
                Log.e( TAG, "No se creo el Dir" );
            }
//            String timeStamp = new SimpleDateFormat(Constants.DATE_FORMAT_CONFIGURACION).format(new Date());
            String imageFileName = "JPEG_" + getNameFromDate() + "_";
            String direction = dir + imageFileName + ".jpg";
            Log.e( "", "" + direction );
            deletePhotosByDir( newdir );
//            if (newdir.isDirectory()) {
//                File[] hijos = newdir.listFiles();
//                for (int i = 0; i < hijos.length; i++) {
//                    hijos[i].delete();
//                }
//            }
            File photo = new File( direction );
            mPhoto = photo.getAbsolutePath();
            try {
                photo.createNewFile();
            } catch (IOException e) {
                Log.e( TAG, e.toString() );
            }
            imageUriCamara = Uri.fromFile( photo );
            Intent cameraIntent = new Intent( MediaStore.ACTION_IMAGE_CAPTURE );
            cameraIntent.putExtra( MediaStore.EXTRA_OUTPUT, imageUriCamara );
            startActivityForResult( cameraIntent, 4416 );
        }


    }

    public boolean deletePhotosByDir(File dir) {

//        Log.e("", "" + gsg);
//        File dir = new File(gsg);
        if (dir.isDirectory()) {
            String[] hijos = dir.list();
            for (int i = 0; i < hijos.length; i++) {
                return new File( dir, hijos[i] ).delete();
            }
        }
        return true;
    }

    public String getNameFromDate() {
        Date date = new Date();
        String fecha = "";
        SimpleDateFormat sdfDate = new SimpleDateFormat( "HH:mm:ss" );
        try {
            fecha = sdfDate.format( date );
            Log.e( "Date", "" + fecha );
        } catch (ClassCastException e) {
            Log.i( TAG, e.getMessage() );
        }
        return "" + fecha;
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat( "yyyy-MM-dd" ).format( new Date() );
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getActivity().getExternalFilesDir( Environment.DIRECTORY_PICTURES );
        File image = File.createTempFile( imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */ );
        mPhoto = image.getAbsolutePath();
        return image;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult( requestCode, resultCode, data );
        switch (requestCode) {
            case 4415: {
//                Galería
                if(resultCode == RESULT_OK) {
                    imgGaleria.setVisibility( View.GONE );
                    imgCamera.setVisibility( View.GONE );
                    imgMiniatura.setVisibility( View.VISIBLE );
                    Bitmap bitmap;
                    try {
                        bitmap = Utils.getThumbnailBitmap( getContext(), data.getData() );
                    } catch (IOException e) {
                        bitmap = null;
                        Log.v( TAG, e.getMessage() );
                    }
                    if (bitmap != null) {
                        imgMiniatura.setImageBitmap( bitmap );
                    } else {
                        Toast.makeText( getContext(), "Ups!!! algo salió mal", Toast.LENGTH_SHORT ).show();
                        imgGaleria.setVisibility( View.VISIBLE );
                        imgCamera.setVisibility( View.VISIBLE );
                        imgMiniatura.setVisibility( View.GONE );
                    }
                }
            }
            break;
            case 4416:{
//                Camera
                if(resultCode == RESULT_OK) {
                    imgGaleria.setVisibility( View.GONE );
                    imgCamera.setVisibility( View.GONE );
                    imgMiniatura.setVisibility( View.VISIBLE );
                    selectedBitmap = BitmapFactory.decodeFile( "/"+nameFile );
                    try {
                        ExifInterface exif = new ExifInterface ( imageUriCamara.getPath() );
                        int rotation = exif.getAttributeInt( ExifInterface.TAG_ORIENTATION,ExifInterface.ORIENTATION_NORMAL );
                        int rotationInDegrees = Utils.exifToDegrees(rotation);
                        Matrix matrix = new Matrix(  );
                        if(rotation != 0f){
                            matrix.preRotate( rotationInDegrees );
                        }
                        int width = selectedBitmap.getWidth();
                        int heigth = selectedBitmap.getHeight();
                        int newWidth = 420;
                        int newHeigth = 297;
                        float scaleWidth = ((float)newWidth/width);
                        float scaleHeigth = ((float)newHeigth/heigth);
                        matrix.postScale( scaleWidth,scaleHeigth );
                        Bitmap adjustedBitmap = Bitmap.createBitmap( selectedBitmap,0,0 ,width,heigth,matrix,true);
                        imgMiniatura.setImageBitmap( adjustedBitmap );
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
            break;

        }
    }

    @Override
    public void dismiss() {
        if (!TextUtils.isEmpty( etMomento.getText().toString() ) && !btnisClicked) {
//            TODO implementar el salvado del mensaje y la imagen
            AlertDialog.Builder dialog = new AlertDialog.Builder( getContext() );
            dialog.setTitle( "¡Atención!" )
                    .setMessage( "El mensaje no se ha envíado deseas guardarlo" )
                    .setPositiveButton( "Guardar borrador", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText( getContext(), "Salvar", Toast.LENGTH_SHORT ).show();
                            dismiss();
                            DialogAdd.super.dismiss();
                        }
                    } )
                    .setNegativeButton( "Descartar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText( getContext(), "descartar", Toast.LENGTH_SHORT ).show();
                            dismiss();
                            DialogAdd.super.dismiss();
                        }
                    } )
                    .setNeutralButton( "", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText( getContext(), "Continuar", Toast.LENGTH_SHORT ).show();
                            dismiss();
                        }
                    } )
                    .show();
            btnisClicked = false;

        } else {
            super.dismiss();
        }
    }
}
