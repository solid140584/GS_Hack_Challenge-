package com.alphateam.gshackchallenge.Base;

import android.support.v4.app.Fragment;
import com.alphateam.gshackchallenge.UI.Activity.Home.MiMomentoActivity;

public class FragmentGSHackBase extends Fragment {

    /**
     * Este metodo se implementa desde la Base y permite comunicarse (cambiar fragmentos)desde un Fragment
     * @param fragment
     * @param TAG
     * @param backStack
     * @param animation
     * Booleano que determina si deseas mostrar una Animación
     */
    public void startFragment(Fragment fragment, String TAG, boolean backStack, boolean animation){

        if(getActivity()!=null){
            MiMomentoActivity act = (MiMomentoActivity)getActivity();
            act.pushFragment(fragment,TAG,backStack,animation);
        }
    }


    /**
     * Muestra un Loader
     */
    public void showProgress(){
        if(getActivity()!=null){
            MiMomentoActivity act = (MiMomentoActivity)getActivity();
            act.showLoader();
        }
    }

    /**
     * Oculta un Loader
     */
    public void hideProgress(){
        if(getActivity()!=null){
            MiMomentoActivity act = (MiMomentoActivity)getActivity();
            act.hideLoader();
        }
    }

    /**
     * Muestra un Toast con un mensaje Parametrizado
     * @param mensaje
     */
    public void showMessage(String mensaje){
        if(getActivity()!=null){
            MiMomentoActivity act = (MiMomentoActivity)getActivity();
            act.showMensaje(mensaje);
        }
    }
}
