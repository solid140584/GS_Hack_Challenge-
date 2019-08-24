package com.alphateam.gshackchallenge.UI.Activity.Home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.alphateam.gshackchallenge.Base.BaseAppActivity;
import com.alphateam.gshackchallenge.R;
import com.alphateam.gshackchallenge.UI.Activity.Home.Presenter.MiMomentoPresenter;
import com.alphateam.gshackchallenge.UI.Activity.Home.Presenter.MiMomentoPresenterImpl;
import com.alphateam.gshackchallenge.UI.Activity.Main.Presenter.MainPresenter;
import com.alphateam.gshackchallenge.UI.Fragment.Mapa.FragmentGSMapa;

import javax.inject.Inject;

public class MiMomentoActivity extends BaseAppActivity implements MiMomentoPresenterImpl.MiMomentoView, NavigationView.OnNavigationItemSelectedListener {

    private TextView mTextMessage;
    private Fragment conteiner;
    private FragmentTransaction fragmentTransaction;

    @Inject
    MiMomentoPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_momento);

        setPresenter();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitle(getString(R.string.miMomento));

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        BottomNavigationView navView = findViewById(R.id.btn_nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    @Override
    public void initView() {
        super.initView();
    }

    @Override
    public void setListeners() {
        super.setListeners();
    }

    @Override
    public void setPresenter() {
        super.setPresenter();

        presenter.register(this);

    }

    @Override
    public void showLoader() {
        super.showLoader();
    }

    @Override
    public void hideLoader() {
        super.hideLoader();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mi_momento, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Escucha los Clicks del DrawerLayout
     * @param item
     * @return
     */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_citas) {

            //TODO inflar Fragmento de Citas Aqui

        } else if (id == R.id.nav_credito) {

            //TODO Inflar Fragmento de Credito Aqui

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * Escucha cuando se Presiona el Toolbar
     */
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_momento:

                    //TODO Fragment Mi momento

                    return true;

                case R.id.nav_top:

                    //TODO Fragment Top

                    return true;

                case R.id.nav_catalogo:

                    //TODO Fragment catalogo

                    return true;

                case R.id.nav_mapa:

                    pushFragment(FragmentGSMapa.getInstantce(null),FragmentGSMapa.TAG,true,true);

                    return true;

            }
            return false;
        }
    };

    /**
     * Metodo para inflar los Fragmentos
     * @param fragment
     */
    public void pushFragment(Fragment fragment, String TAG, boolean backStack, boolean animation){
        if(!isFinishing()){

            this.conteiner = fragment;
            fragmentTransaction = getSupportFragmentManager().beginTransaction();

            if(animation){

                fragmentTransaction.setCustomAnimations(R.anim.aparecer_fragmento,R.anim.desaparecer_fragmento,R.anim.aparecer_fragmento,R.anim.desaparecer_fragmento);

            }

            fragmentTransaction.replace(R.id.frameLayout,conteiner);//Reemplaza nuestro contenedor (FragmentA, FragmentB ó FragmentC por el fragment que deseamos)

            if(backStack) {

                fragmentTransaction.addToBackStack(TAG);

            }
            fragmentTransaction.commitAllowingStateLoss();

        }
    }
}