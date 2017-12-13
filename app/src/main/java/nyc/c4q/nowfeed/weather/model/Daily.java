package nyc.c4q.nowfeed.weather.model;

/**
 * Created by jervon.arnoldd on 11/23/17.
 */

public class Daily {

    Coord coord;
    Weather[] weather;
    String base;
    Main main;
    int visibility;
    Wind wind;
    Clouds clouds;
    long dt;
    Sys sys;
    int id;
    String name;
    int cod;

    public Coord getCoord() {
        return coord;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public String getBase() {
        return base;
    }

    public Main getMain() {
        return main;
    }

    public int getVisibility() {
        return visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public long getDt() {
        return dt;
    }

    public Sys getSys() {
        return sys;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCod() {
        return cod;
    }
}



