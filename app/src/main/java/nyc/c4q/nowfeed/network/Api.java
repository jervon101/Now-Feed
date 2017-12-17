package nyc.c4q.nowfeed.network;

import nyc.c4q.nowfeed.sports.model.Game;
import nyc.c4q.nowfeed.weather.model.Daily;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by jervon.arnoldd on 12/13/17.
 */

public interface Api {

    String WEATHER_API = "http://api.openweathermap.org/";

    @GET("weather")
    Call<Daily> getWeather(@Query("zip") String zip, @Query("appid") String id);




    String FULL_GAME_API = "https://api.mysportsfeeds.com/";

    @GET("data/2.5/v1.1/pull/nba/2017-2018-regular/full_game_schedule.json")

    Call<Game> getGameSchedule(@Header("Authorization") String user);


}
