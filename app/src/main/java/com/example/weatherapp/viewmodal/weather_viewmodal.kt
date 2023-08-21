package com.example.weatherapp.viewmodal

import WeatherResponse
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.ApiInterface
import com.example.weatherapp.RetrofitConfig

import com.example.weatherapp.utils.Constants
import kotlinx.coroutines.launch

class weather_viewmodal : ViewModel() {

    val response = MutableLiveData<WeatherResponse>()

    var API = RetrofitConfig().getInstance().create(ApiInterface::class.java)

    fun getData(city:String) {
        try {

            viewModelScope.launch {
                var res = API.getWeather(city, Constants.API_KEY, "metric")
                response.value = res.body()
            }

        } catch (e: Exception) {
            println(e.message)
        }
    }


}