package com.alphateam.gshackchallenge.UI.Fragment.Login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alphateam.gshackchallenge.IO.Responses.LoginResponse;
import com.alphateam.gshackchallenge.R;
import com.alphateam.gshackchallenge.UI.Activity.Home.MiMomentoActivity;
import com.alphateam.gshackchallenge.UI.Activity.Main.MainActivity;
import com.alphateam.gshackchallenge.UI.Fragment.Registro.FragmentRegistro;
import com.alphateam.gshackchallenge.Utils.ApplicationBase;
import com.alphateam.gshackchallenge.Utils.Constants;


public class FragmentLogin extends Fragment implements LoginPresenterImpl.LoginView, View.OnClickListener{
    private View view;
    private TextView tvRegistrate;
    private Button btnAccess;
    private EditText etUser;
    private EditText etPass;
    public static final String TAG = FragmentLogin.class.getSimpleName();


    LoginPresenter presenter;

    public static FragmentLogin getInstance(@Nullable Bundle args) {
        FragmentLogin fragment = new FragmentLogin();
        if (args != null) {
            fragment.setArguments(args);
        }
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);
        setPresenter();
        tvRegistrate.setText(getResources().getString(R.string.registrate));
        return view;
    }

    @Override
    public void initView() {
        tvRegistrate = (TextView) view.findViewById(R.id.tvRegistrate);
        btnAccess = (Button) view.findViewById(R.id.btnAccess);
        etUser = (EditText) view.findViewById(R.id.etUser);
        etPass = (EditText) view.findViewById(R.id.etPass);
    }

    @Override
    public void setListeners() {
        btnAccess.setOnClickListener(this);
        tvRegistrate.setOnClickListener(this);
    }

    @Override
    public void setPresenter() {
        presenter= new LoginPresenterImpl();
        presenter.register(this);
    }

    @Override
    public void showLoader() {

    }

    @Override
    public void hideLoader() {

    }

    @Override
    public Activity getActivityInstance() {
        return null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btnAccess:

                presenter.validateUser(etUser.getText().toString(),etPass.getText().toString());

                break;

            case R.id.tvRegistrate:
                Bundle bundle = new Bundle();
                Fragment fragmentRegistro =FragmentRegistro.getInstance(bundle);
                getFragmentManager()
                        .beginTransaction()
                        .addToBackStack(TAG)
                        .replace(R.id.frameLayout1, fragmentRegistro)
                        .commit();
                break;
        }
    }

    @Override
    public void userIsEmpty() {
        Toast.makeText(getContext(),"Ingresa un Usuario",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void passIsEmpty() {
        Toast.makeText(getContext(),"Ingresa la contraseña",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void passLow6() {
        Toast.makeText(getContext(),"La contraseña debe ser mayor a 6 caracteres",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void success(String usuario, String pass) {
        presenter.Login(usuario, pass);
    }

    @Override
    public void SuccesLogin() {
        SharedPreferences pref = ApplicationBase.getIntance().getSharedPreferences(Constants.SHARED_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(Constants.LOGIN,true);
        editor.commit();
        String nombre = pref.getString(Constants.USUARIO,"");
        String contraseña =pref.getString(Constants.PASS,"");

        if(nombre.equals(etUser.getText().toString()) && contraseña.equals(etPass.getText().toString())){
            Intent i = new Intent(getContext(), MiMomentoActivity.class);
            Bundle bundle = new Bundle();
//        bundle.putInt(Constants.LOGIN,identificador);
            i.putExtras(bundle);
            startActivity(i);
        }else {
            Toast.makeText(getContext(),"Usuario no registrado",Toast.LENGTH_SHORT).show();
        }


    }
}
