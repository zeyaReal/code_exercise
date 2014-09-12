/**
 * Created by zeya on 14-9-12.
 */
public class TexiMeter {

    public static final int INITIAL_DISTANCE_KILOMETER = 2;
    public static final float INITIAL_FARE = 6.00f;
    public static final float BASE_FARE_RATE = 1.50f;

    public float fareForDistance(float distanceKilometer) {
        if (distanceKilometer <= 0) {
            return 0;
        }
        if (distanceKilometer <= INITIAL_DISTANCE_KILOMETER) {
            return INITIAL_FARE;
        }

        if (distanceKilometer <= 8) {
            return INITIAL_FARE + (distanceKilometer - INITIAL_DISTANCE_KILOMETER) * BASE_FARE_RATE;
        }

        return INITIAL_FARE + ( 8 - INITIAL_DISTANCE_KILOMETER ) * BASE_FARE_RATE + (distanceKilometer - 8) * BASE_FARE_RATE * 1.50f;
    }
}
