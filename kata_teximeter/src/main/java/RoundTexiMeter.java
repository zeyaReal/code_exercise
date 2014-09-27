/**
 * Created by zeya on 14-9-27.
 */
class RoundTexiMeter implements  TexiMeter {
    private TexiMeter texiMeter;

    public RoundTexiMeter(TexiMeter texiMeter){

        this.texiMeter = texiMeter;
    }

    @Override
    public float fareFor(float distanceKilometer, int waitingMinutes) {
        return Math.round(this.texiMeter.fareFor(distanceKilometer, waitingMinutes));
    }
}
