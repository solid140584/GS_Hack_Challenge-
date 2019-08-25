package com.alphateam.gshackchallenge.UI.Fragment.Registro;

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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;

import com.alphateam.gshackchallenge.R;
import com.alphateam.gshackchallenge.UI.Activity.Home.MiMomentoActivity;
import com.alphateam.gshackchallenge.UI.Activity.Main.MainActivity;
import com.alphateam.gshackchallenge.UI.Activity.Splash.SplashActivity;
import com.alphateam.gshackchallenge.Utils.Constants;

import javax.inject.Inject;

public class FragmentRegistro extends Fragment implements RegistroPresenterImpl.RegistroView, View.OnClickListener {

    private View view;
    private EditText etNombre1, etNombre2, etApPaterno, etApMaterno, etTelefono, etCiudad, etContrasena, etConfirmarContrasena, etEmail;
    private Button btnRegistrar;
    private Spinner spGenero;
    ScrollView svRegistro;
    private int genero = 0;
    private final static String[] generos = { "Prefiero no responder", "Hombre", "Mujer"};

    RegistroPresenter presenter;

    public static FragmentRegistro getInstance(@Nullable Bundle args) {
        FragmentRegistro fragment = new FragmentRegistro();
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
        view = inflater.inflate(R.layout.fragment_registro, container, false);
        setPresenter();
        return view;
    }

    @Override
    public void initView() {
        etNombre1 =view.findViewById(R.id.etNombre1);
        etNombre2 =view.findViewById(R.id.etNombre2);
        etApPaterno =view.findViewById(R.id.etApPaterno);
        etApMaterno =view.findViewById(R.id.etApMaterno);
        etTelefono =view.findViewById(R.id.etTelefono);
        etCiudad =view.findViewById(R.id.etCiudad);
        etContrasena =view.findViewById(R.id.etContrasena);
        etConfirmarContrasena =view.findViewById(R.id.etConfirmarContrasena);
        etEmail =view.findViewById(R.id.etEmail);
        spGenero =view.findViewById(R.id.spGenero);
        svRegistro =(ScrollView) view.findViewById(R.id.svRegistro);
        btnRegistrar = view.findViewById(R.id.btnRegistrar);

//        spGenero.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, generos));

    }

    @Override
    public void setListeners() {
        btnRegistrar.setOnClickListener(this);
    }

    @Override
    public void setPresenter() {
        presenter = new RegistroPresenterImpl();
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

            case R.id.btnRegistrar:
                presenter.validateFieldsToRegister(etNombre1.getText().toString(), etNombre2.getText().toString(), etApPaterno.getText().toString(), etApMaterno.getText().toString(), etTelefono.getText().toString(), etCiudad.getText().toString(), etContrasena.getText().toString(), etConfirmarContrasena.getText().toString(), etEmail.getText().toString(), genero);
                break;

        }
    }

    @Override
    public void registerUser(String etNombre1, String etNombre2, String etApPaterno, String etApMaterno, String etTelefono, String etCiudad, String etContrasena, String etEmail, int genero) {
        presenter.RegistrarUsuario(etNombre1, etNombre2, etApPaterno, etApMaterno, etTelefono, etCiudad, etContrasena, etEmail, genero);
    }

    @Override
    public void passNOCoinciden() {
        etContrasena.setText("");
        etConfirmarContrasena.setText("");
        Toast.makeText(getContext(), "La contraseña no coincide", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void fieldIsEmpty() {
        Toast.makeText(getContext(), "Es necesario rellenar todos los campos", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void passLow6() {
        Toast.makeText(getContext(),"La contraseña debe ser mayor a 6 caracteres",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void Hard(String Nombre, String apellido, String pass) {
        SharedPreferences pref = getContext().getSharedPreferences(Constants.SHARED_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(Constants.USUARIO, Nombre);
        editor.putString(Constants.APELLIDO, apellido);
        editor.putString(Constants.PASS, pass);
        editor.commit();

        Intent i = new Intent(getContext(), MiMomentoActivity.class);
        Bundle bundle = new Bundle();
//        bundle.putInt(Constants.LOGIN,identificador);
        i.putExtras(bundle);
        startActivity(i);


    }
}
