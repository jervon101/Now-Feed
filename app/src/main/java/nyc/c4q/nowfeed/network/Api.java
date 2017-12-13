package nyc.c4q.nowfeed.network;

import nyc.c4q.nowfeed.weather.model.Daily;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jervon.arnoldd on 12/13/17.
 */

public interface Api {

    String WEATHER_API = "http://api.openweathermap.org/data/2.5/";

    @GET("weather")
    Call<Daily> getWeather(@Query("zip")String zip, @Query("appid")String id);



}
