/**
 * Created by zeya on 14-9-12.
 */
public class TexiMeter {

    public static final int INITIAL_DISTANCE_KILOMETER = 2;
    public static final float INITIAL_FARE = 6.00f;

    public static final float BASE_FARE_PER_KILOMETER = 1.50f;
    public static final int BASE_DISTANCE_KILOMETER = 8;

    public static final float SPECIAL_FARE_RATE = 1.50f;

    public float fareForDistance(float distanceKilometer) {
        if (distanceKilometer <= 0) {
            return 0;
        }

        return INITIAL_FARE + countBasefare(distanceKilometer) + countSpecialFare(distanceKilometer);
    }

    private float countSpecialFare(float distanceKilometer) {
        if (distanceKilometer > BASE_DISTANCE_KILOMETER) {
            return (distanceKilometer - BASE_DISTANCE_KILOMETER) * BASE_FARE_PER_KILOMETER * SPECIAL_FARE_RATE;
        }
        return 0;
    }

    private float countBasefare(float distanceKilometer) {
        if (distanceKilometer > INITIAL_DISTANCE_KILOMETER) {
             return (Math.min(distanceKilometer, BASE_DISTANCE_KILOMETER) - INITIAL_DISTANCE_KILOMETER) * BASE_FARE_PER_KILOMETER;
        }
        return 0;
    }
}
