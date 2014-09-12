/**
 * Created by zeya on 14-9-12.
 */
public class TexiMeter {

    public static final int INITIAL_DISTANCE_KILOMETER = 2;
    public static final float INITIAL_FARE = 6.00f;
    public static final float BASE_FARE_RATE = 1.50f;
    public static final int BASE_DISTANCE_KILOMETER = 8;

    public float fareForDistance(float distanceKilometer) {
        if (distanceKilometer <= 0) {
            return 0;
        }


        float totalFare = INITIAL_FARE;
        if (distanceKilometer <= INITIAL_DISTANCE_KILOMETER) {
            return totalFare;
        }

        float baseFare = 0;
        if (distanceKilometer > INITIAL_DISTANCE_KILOMETER) {
             baseFare = (Math.min(distanceKilometer, BASE_DISTANCE_KILOMETER) - INITIAL_DISTANCE_KILOMETER) * BASE_FARE_RATE;
        }

        float specialFare = 0;
        if (distanceKilometer > BASE_DISTANCE_KILOMETER) {
            specialFare = (distanceKilometer - BASE_DISTANCE_KILOMETER) * BASE_FARE_RATE * 1.50f;
        }

        return totalFare + baseFare + specialFare;
    }
}
