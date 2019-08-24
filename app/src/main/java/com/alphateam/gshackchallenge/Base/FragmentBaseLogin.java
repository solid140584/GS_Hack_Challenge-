package com.alphateam.gshackchallenge.Base;

import android.app.Activity;
import android.support.v4.app.Fragment;


//TODO base de fragments
public class FragmentBaseLogin extends Fragment implements BaseView {

    public void navFragment(Fragment fragment, String Tag, boolean backstack, int enterAnimation, int exitAnimation){

        if(getActivity()!=null){

           // MainActivity act = (MainActivity)getActivity();
           // act.navFragment(fragment,Tag,backstack,enterAnimation,exitAnimation);

        }
    }

   /* public void disableDrawer(){

        if(getActivity()!=null){

            MainActivity act = (MainActivity)getActivity();
            act.setDrawerEnabled(false);

        }
    }

    public void setName(String name){

        if(getActivity()!=null){

            MainActivity act = (MainActivity)getActivity();
            act.setName(name);

        }
    }

    public void enableDrawer(){

        if(getActivity()!=null){

            MainActivity act = (MainActivity)getActivity();
            act.setDrawerEnabled(true);

        }
    }*/

    @Override
    public void initView() {

    }

    @Override
    public void setListeners() {

    }

    @Override
    public void setPresenter() {

    }

    @Override
    public void showLoader() {

    }

    @Override
    public void hideLoader() {

    }

    @Override
    public Activity getActivityInstance() {
        return getActivity();
    }
}