package com.alphateam.gshackchallenge.UI.Fragment.Mapa;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alphateam.gshackchallenge.Base.FragmentGSHackBase;
import com.alphateam.gshackchallenge.IO.Responses.Sucursales;
import com.alphateam.gshackchallenge.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class FragmentGSMapa extends FragmentGSHackBase implements OnMapReadyCallback, LocationListener, GoogleMap.OnMarkerClickListener {

    private View view;
    private GoogleMap mMap;
    LocationListener locationListener;
    private LocationManager locationManager;
    private Location location;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 100;
    private static final int LOCATION_TIME = 5000;
    private static final int LOCATION_DISTANCE = 10;
    public static final String TAG = FragmentGSMapa.class.getSimpleName();
    private BottomSheetBehavior sheetBehavior;
    private RelativeLayout bottom_sheet;
    private LatLng myUbicacion;
    private TextView tvNombre, tvDireccion, tvTelefono, tvHorario;
    Sucursales sucursales;
    ArrayList<Sucursales> listaSucursales;

    /**
     * Metodo para enviar parametros desde la Activity
     *
     * @param args
     * @return
     */
    public static FragmentGSMapa getInstantce(@Nullable Bundle args) {
        FragmentGSMapa fragmentMapa = new FragmentGSMapa();
        if (args != null) {

            fragmentMapa.setArguments(args);
        }
        return fragmentMapa;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mapa, container, false);

        initUI();
        return view;
    }

    private void initUI() {

        Bundle bundle = getArguments();
        if (bundle != null) {

        }

        listaSucursales = new ArrayList<>();
        Sucursales ins = new Sucursales();
        ins.setNombre("Italika insurgentes");
        ins.setDireccion("Av Insurgentes sur no. 456");
        ins.setHorario("Lunes a Domingo 09:00 - 21:00");
        ins.setTel("55 55 34 54 67");
        ins.setLat(-99.213421);
        ins.setLng(19.436578);
        listaSucursales.add(ins);

        Sucursales periferico = new Sucursales();
        periferico.setNombre("Taller Italika Coyoacan");
        periferico.setDireccion("Periferico Sur no.12");
        periferico.setHorario("Lunes a Domingo 09:00 - 21:00");
        periferico.setTel("55 14 64 58 68");
        ins.setLat(-99.213421);
        ins.setLng(19.436578);
        listaSucursales.add(periferico);

        bottom_sheet = view.findViewById(R.id.bottom_sheet);
        sheetBehavior = BottomSheetBehavior.from(bottom_sheet);// Le notificamos a nuestro bottom sheet que el RelativeLayout, será nuestro lienzo

        tvNombre = view.findViewById(R.id.tvNombre);
        tvTelefono = view.findViewById(R.id.tvTelefono);
        tvDireccion = view.findViewById(R.id.tvDireccion);
        tvHorario = view.findViewById(R.id.tvHorario);

        locationManager = (LocationManager) getContext().getSystemService(Context.LOCATION_SERVICE);
        locationListener = this;

        if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {

            SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);

        } else {

            showMessage("El GPS está apagado");

        }

        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int tipoDeEvento) {
                switch (tipoDeEvento) {
                    case BottomSheetBehavior.STATE_EXPANDED: // El BottomSheet detectó el evento del control expandido

                        if (mMap != null && myUbicacion != null) {
                            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myUbicacion, 15f));
                        }
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED: //El bottomSheet Detectó el evento del control colapsado

                        if (mMap != null && myUbicacion != null) {
                            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myUbicacion, 11f));
                        }
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View view, float v) {

            }
        });
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMarkerClickListener(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            enableMyLocation();

        }

        for (int i = 0; i < listaSucursales.size(); i++) {

            Sucursales item = listaSucursales.get(i); //Creamos e instanciamos nuestro item

            mMap.addMarker(new MarkerOptions()
                            .position(new LatLng(item.getLat(), item.getLng())) //Seteamos las coordenadas
                            //.title("Ubicacion de " + item.getNombre())
                    //.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_uber))//Modificamos el Icono por el icono de Uber//TODO por definir icono
            ).setTag(i); //Creamos un Tag para identificar el Marker usando la posición del item en ArrayList
        }

        sucursales = listaSucursales.get(0);
        setData(sucursales);

    }

    private void enableMyLocation() {

        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_REQUEST_CODE);
        } else {

            mMap.setMyLocationEnabled(true);
            getCurrentLocation();
        }
    }

    @SuppressLint("MissingPermission")
    private void getCurrentLocation() {

        boolean isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        boolean isNewtworEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        if (isGPSEnabled) {

            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, LOCATION_TIME, LOCATION_DISTANCE, locationListener);
            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER); // El LocationManager proporciona a la Clase Location la yltima ubicación conocida
        }

        if (isNewtworEnabled) {

            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, LOCATION_TIME, LOCATION_DISTANCE, locationListener);
            location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

        }

        if (location != null) {
            setZoomMap(location);
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        if (location != null) {
            locationManager.removeUpdates(locationListener);
            this.location = location;
            setZoomMap(location);
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    /**
     * anima el zoom en la ubicación del usuario
     *
     * @param location
     */
    private void setZoomMap(Location location) {

        if (mMap != null) {

            double lat = location.getLatitude();
            double lng = location.getLongitude();

            LatLng myUbicacion = new LatLng(lat, lng);
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(myUbicacion, 15f));


        }
    }


    @Override
    public boolean onMarkerClick(Marker marker) {

        int tag = (int) marker.getTag();
        sucursales = listaSucursales.get(tag);

        if (sucursales != null) {

            setData(sucursales);

        }

        return true;
    }


    private void setData(Sucursales item) { //TODO Falta definir objeto

        //ciAdam.setImageDrawable(ContextCompat.getDrawable(getContext(), adam.getImagen()));
        tvNombre.setText(item.getNombre());
        tvTelefono.setText(item.getTel());
        tvDireccion.setText(item.getDireccion());
        tvHorario.setText(item.getDireccion());

    }
}