package com.example.weatherapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.utils.setImage
import com.example.weatherapp.viewmodal.weather_viewmodal

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var viewmodel: weather_viewmodal =
            ViewModelProvider(this).get(weather_viewmodal::class.java)
        viewmodel.getData("kochi")
        //getting the data from UI

        findViewById<Button>(R.id.findBtn).setOnClickListener {
            var cityValue = findViewById<EditText>(R.id.cityname).text.toString()
            viewmodel.getData(cityValue)
        }
        //get data from live data
        viewmodel.response.observe(this) { result ->

            result?.let {
                findViewById<TextView>(R.id.temp).text = it.main.temp.toString()+"°C"
                findViewById<TextView>(R.id.city).text = it.name+", "+it.sys.country
                findViewById<TextView>(R.id.humidity).text = it.main.humidity.toString()+" g.m-3"
                findViewById<TextView>(R.id.pressure).text = it.main.pressure.toString()+" Pascal"
                findViewById<TextView>(R.id.condition).text = it.weather[0].description
        }

    }

}



}
