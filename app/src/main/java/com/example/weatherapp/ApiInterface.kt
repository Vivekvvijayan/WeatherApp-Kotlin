package com.example.weatherapp


import WeatherResponse

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("data/2.5/weather")
    suspend fun getWeather(@Query("q") city:String,@Query("appid") apiKey:String,@Query("units") unit:String):Response<WeatherResponse>
}