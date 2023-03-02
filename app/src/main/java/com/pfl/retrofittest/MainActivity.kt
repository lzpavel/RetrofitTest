package com.pfl.retrofittest

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.pfl.retrofittest.AppView.MainView
import com.pfl.retrofittest.WeatherData.WeatherData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {

    val LOG_TAG = "MainActivity"

    private val mainView = MainView()

    val showToast: ((msg: String) -> Unit) = {
         Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            mainView.setContent()
        }
        mainView.onClickButtonUpdate {
            Toast.makeText(this, "Start", Toast.LENGTH_SHORT).show()
            var retrofitServices: RetrofitServices = Common.retrofitService
            retrofitServices.getWeatherData().enqueue(
                object : Callback<WeatherData> {
                    override fun onFailure(call: Call<WeatherData>, t: Throwable) {
                        Log.d(LOG_TAG,"onFailure")
                        showToast.invoke("onFailure")
                    }

                    override fun onResponse(call: Call<WeatherData>, response: Response<WeatherData>) {
                        var weatherData: WeatherData = response.body() as WeatherData
                        Log.d(LOG_TAG, weatherData.toString())
                        showToast.invoke("onResponse")
                    }
                }
            )


        }
    }


}

