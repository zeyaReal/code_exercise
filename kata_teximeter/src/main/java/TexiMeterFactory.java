/**
 * Created by zeya on 14-9-27.
 */
public class TexiMeterFactory {

    static PreciseTexiMeter createPreciseTextMeter() {
        return new PreciseTexiMeter();
    }

    static RoundTexiMeter createRoundTextMeter() {
        return new RoundTexiMeter(new PreciseTexiMeter());
    }

    public static TexiMeter createTextMeter()
    {
        return createRoundTextMeter();
    }
}
