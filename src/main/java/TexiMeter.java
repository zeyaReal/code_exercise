/**
 * Created by zeya on 14-9-12.
 */
public class TexiMeter {

    public static final int INITIAL_DISTANCE_KILOMETER = 2;
    public static final float INITIAL_FARE = 6.00f;

    public static final float BASE_FARE_PER_KILOMETER = 1.50f;
    public static final int BASE_DISTANCE_KILOMETER = 8;

    public static final float SPECIAL_FARE_RATE = 1.50f;
    public static final float WAITING_FARE_PER_MINUTES = 0.25f;

    public float fareForDistance(float distanceKilometers) {
        return fareForDistance(distanceKilometers, 0);
    }

    private float fareForDistance(float distanceKilometers, int waitingMinutes) {
        if (distanceKilometers <= 0) {
            return 0;
        }

        float totalFare = INITIAL_FARE;
        totalFare += countBaseFare(distanceKilometers);
        totalFare += countSpecialFare(distanceKilometers);
        totalFare += countWaitingFare(waitingMinutes);

        return totalFare;
    }

    private float countWaitingFare(int waitingMinutes) {
        return waitingMinutes * WAITING_FARE_PER_MINUTES;
    }

    private float countSpecialFare(float distanceKilometers) {
        if (distanceKilometers > BASE_DISTANCE_KILOMETER) {
            return (distanceKilometers - BASE_DISTANCE_KILOMETER) * BASE_FARE_PER_KILOMETER * SPECIAL_FARE_RATE;
        }
        return 0;
    }

    private float countBaseFare(float distanceKilometers) {
        if (distanceKilometers > INITIAL_DISTANCE_KILOMETER) {
            return (Math.min(distanceKilometers, BASE_DISTANCE_KILOMETER) - INITIAL_DISTANCE_KILOMETER) * BASE_FARE_PER_KILOMETER;
        }
        return 0;
    }

    public int roundFareForDistance(float distanceKilometers) {
        return Math.round(fareForDistance(distanceKilometers, 0));
    }

    public float fareForDistanceAndWaitingMinutes(float distanceKilometer, int waitingMinutes) {
        return fareForDistance(distanceKilometer, waitingMinutes);
    }

    public int roundFareForDistanceAndWaitingMinutes(float distanceKilometers, int waitingMinutes) {
        return Math.round(fareForDistance(distanceKilometers, waitingMinutes));
    }
}
