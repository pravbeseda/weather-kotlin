package pravbeseda.simpleweather

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {
    lateinit var openWeatherApi: OpenWeatherApi

    override fun onCreate() {
        super.onCreate()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
            .build()
        openWeatherApi = retrofit.create(OpenWeatherApi::class.java)
    }

    fun getApi() : OpenWeatherApi {
        return openWeatherApi
    }
}