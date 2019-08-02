package pravbeseda.simpleweather

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherApi {
    @GET("weather")
    fun getWeather(@Query("q") q: String, @Query("appId") appId: String): Call<OpenWeatherData>
}