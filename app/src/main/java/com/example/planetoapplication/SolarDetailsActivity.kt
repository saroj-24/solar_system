package com.example.planetoapplication

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.planetoapplication.databinding.ActivitySolarDetailsBinding

class SolarDetailsActivity : AppCompatActivity() {
    private lateinit var obj:PlanetData
    private var planetImg:Int?=null
    lateinit  var binding:ActivitySolarDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySolarDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.decorView.apply { systemUiVisibility=
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN }
        obj =intent.getParcelableExtra("planet")!!
        planetImg = intent.getIntExtra("planetImage",-1)
        setData(obj,planetImg!!)


    }
    private fun setData(obj:PlanetData,planetImg:Int)
    {
           binding.titleInfo.text = obj.title
           binding.galaxyInfo.text = obj.galaxy
           binding.gravityInfo.text = obj.gravity +" m/s"
           binding.distanceInfo.text = obj.distance +" mm of km"
           binding.overviewInfo.text = obj.overview
           binding.planetInfoImg.setImageResource(planetImg)
    }
}