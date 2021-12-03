package com.example.gastles

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.gastles.databinding.ActivityMainBinding
import org.osmdroid.config.Configuration.getInstance
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getInstance().load(this, getSharedPreferences("osm_config", Context.MODE_PRIVATE))

        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))

        setContentView(binding.root)

        setupMaps()
    }

    private fun setupMaps()
    {




        binding.map.apply {
            setTileSource(TileSourceFactory.MAPNIK)

            val locationOverlay = MyLocationNewOverlay(GpsMyLocationProvider(this@MainActivity), this)
            locationOverlay.enableMyLocation()
            overlays.add(locationOverlay)

            setMultiTouchControls(true)

            controller.apply {
                setZoom(20.0)
                val startPoint = GeoPoint(51.58567, 4.79428)
                setCenter(startPoint)
            }

        }
    }

}