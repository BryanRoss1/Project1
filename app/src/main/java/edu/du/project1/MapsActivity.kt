package edu.du.project1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import edu.du.project1.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker for Ball Arena and move the camera
        // Add markers for DNVR and Casa Bonita 
        val sydney = LatLng(-34.0, 151.0)
        val ballArena = LatLng(39.748920, -105.008400)
        val dnvr = LatLng(39.74045581999332, -104.96001943177163)
        val casaBonita = LatLng(39.74178302084983, -105.0703109648522)

        mMap.addMarker(MarkerOptions().position(ballArena).title("Ball Arena"))
        mMap.addMarker(MarkerOptions().position(dnvr).title("DNVR"))
        mMap.addMarker(MarkerOptions().position(casaBonita).title("Casa Bonita"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ballArena))
    }
}