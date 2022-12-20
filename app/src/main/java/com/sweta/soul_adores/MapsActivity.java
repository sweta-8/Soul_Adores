package com.sweta.soul_adores;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageStats;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback ,LocationListener{

    private GoogleMap mMap;
    LocationManager lm;
    Location location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        lm=(LocationManager) getSystemService(LOCATION_SERVICE);
        Criteria c = new Criteria();
        String provider =LocationManager.NETWORK_PROVIDER;
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            return;
        }

        location=lm.getLastKnownLocation(provider);
        Toast.makeText(this,"Location "+location,Toast.LENGTH_SHORT).show();
        if(location!=null)
        {
            onLocationChanged(location);
        }
        lm.requestLocationUpdates(provider,20000,100, this);

    }

    @Override
    public void onLocationChanged( Location location) {
            double lat =location.getLatitude();
            double log=location.getLongitude();

            // Add a marker in Sydney and move the camera
            LatLng sydney = new LatLng(lat, log);
            mMap.addMarker(new MarkerOptions().position(sydney).title("My Place"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
            Geocoder geocoder =new Geocoder(this, Locale.ENGLISH);
        try{
            List<Address> list =geocoder.getFromLocation(lat,log,1);
            Address address=list.get(0);
            Toast.makeText(this," "+address.getCountryName()+"\n"+address.getAdminArea()+"\n"+address.getSubAdminArea()+"\n"+address.getSubLocality(),Toast.LENGTH_SHORT).show();


        } catch (Exception e) {

        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled( String provider) {

    }
}