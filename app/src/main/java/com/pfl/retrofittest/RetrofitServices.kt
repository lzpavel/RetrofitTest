package com.pfl.retrofittest

import com.pfl.retrofittest.WeatherData.WeatherData
import retrofit2.Call
import retrofit2.http.*

interface RetrofitServices {

    //@GET("current.json?key=3522714f17104302898123440231201&q=Moscow&aqi=no")
    //@GET("http://api.weatherapi.com/v1/current.json?key=3522714f17104302898123440231201&q=Moscow&aqi=no")
    @GET("test1")
    fun getTestData(): Call<TestData>

    @GET("current.json?key=3522714f17104302898123440231201&q=Moscow&aqi=no")
    fun getWeatherData(): Call<WeatherData>
}