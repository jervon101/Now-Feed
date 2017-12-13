package nyc.c4q.nowfeed.weather.model;

/**
 * Created by jervon.arnoldd on 12/10/17.
 */

public class Weather {
    int id;
    String main;
    String description;
    String icon;

    public int getId() {
        return id;
    }

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }
}
