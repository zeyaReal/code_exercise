/**
 * Created by zeya on 14-9-12.
 */
public class TexiMeter {

    public float fareForDistance(float distanceKilometer) {
        if (distanceKilometer <= 0) {
            return 0;
        }
        if (distanceKilometer <= 2) {
            return 6;
        }
        return 6 + (distanceKilometer - 2) * 1.50f;
    }
}
