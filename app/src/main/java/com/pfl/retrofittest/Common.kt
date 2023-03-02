package com.pfl.retrofittest

object Common {
    //private val BASE_URL = "http://api.weatherapi.com/v1/current.json?key=3522714f17104302898123440231201&q=Moscow&aqi=no"
    //private val BASE_URL = "https://a5c4c4e6-94e5-4d0f-b4e0-af4bbd990e47.mock.pstmn.io/"
    private val BASE_URL = "http://api.weatherapi.com/v1/"
    val retrofitService: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}