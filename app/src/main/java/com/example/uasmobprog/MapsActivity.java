package com.example.uasmobprog;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.uasmobprog.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng CGP_Alpha = new LatLng(-6.193924061113853, 106.78813220277623);
        mMap.addMarker(new MarkerOptions().position(CGP_Alpha).title("CGP Alpha"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(CGP_Alpha));
        LatLng CGP_Beta = new LatLng(-6.20175020412279,  106.78223868546155);
        mMap.addMarker(new MarkerOptions().position(CGP_Beta).title("CGP Beta"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(CGP_Beta));
    }
}