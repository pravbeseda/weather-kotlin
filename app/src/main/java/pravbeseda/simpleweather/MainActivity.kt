package pravbeseda.simpleweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val tag = "myLogs"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiKey: String = BuildConfig.ApiKey
        (this.application as App).getApi().getWeather("Kaluga", apiKey).enqueue(object: Callback<OpenWeatherData> {
            override fun onFailure(call: Call<OpenWeatherData>?, t: Throwable?) {
                Log.d(tag, "call failed ${t.toString()}")
            }
            override fun onResponse(call: Call<OpenWeatherData>?, response: Response<OpenWeatherData>?) {
                Log.d(tag, "call response ${response?.body().toString()}")
            }

        })
        //Log.d(tag, "response: ${response.body().toString()}")
    }
}
