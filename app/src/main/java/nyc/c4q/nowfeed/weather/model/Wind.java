package nyc.c4q.nowfeed.weather.model;

/**
 * Created by jervon.arnoldd on 12/10/17.
 */

public class Wind {
    double speed;
    int deg;
    float gust;

    public float getGust() {
        return gust;
    }

    public double getSpeed() {
        return speed;
    }

    public int getDeg() {
        return deg;
    }
}
