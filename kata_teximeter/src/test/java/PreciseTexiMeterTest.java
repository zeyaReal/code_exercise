
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by zeya on 14-9-12.
 */
@RunWith(Parameterized.class)
public class PreciseTexiMeterTest {

    private PreciseTexiMeter texiMeter;

    private float distanceKilometers;
    private int waitingMinutes;
    private float fareResult;

    public PreciseTexiMeterTest(float distanceKilometers, int waitingMinutes, float fareResult) {

        this.distanceKilometers = distanceKilometers;
        this.waitingMinutes = waitingMinutes;
        this.fareResult = fareResult;
    }

    @Before
    public void setUp() {
        texiMeter = TexiMeterFactory.createPreciseTextMeter();
    }

    @Parameterized.Parameters
    public static Collection prepareData() {
        Object[][] object = new Object[][]{
                prepare_fareFor_should_return_0_when_distance_is_0_kilometer(),
                prepare_fareFor_should_return_6_when_distance_is_1_8_kilometer(),
                prepare_fareFor_should_return_6_when_distance_is_2_0_kilometer(),
                prepare_fareFor_should_return_9_when_distance_is_4_0_kilometer(),
                prepare_fareFor_should_return_15_when_distance_is_8_0_kilometer(),
                prepare_fareFor_should_return_17_25_when_distance_is_9_0_kilometer(),
                prepare_fareFor_should_return_19_5_when_distance_is_10_0_kilometer(),
                prepare_fareFor_should_return_17_75_when_distance_is_9_0_kilometer_and_waiting_2_minutes(),
                prepare_fareFor_should_return_18_25_when_distance_is_9_0_kilometer_and_waiting_4_minutes()
        };
        return Arrays.asList(object);
    }

    @Test
    public void test_fareFor_should_return_fare_with_distanceKilometers_waitingMinutes() throws Exception {
        assertThat(texiMeter.fareFor(this.distanceKilometers, this.waitingMinutes), is(this.fareResult));
    }

    static Object[] prepare_fareFor_should_return_0_when_distance_is_0_kilometer() {
        return new Object[]{0f, 0, 0f};
    }

    static Object[] prepare_fareFor_should_return_6_when_distance_is_1_8_kilometer() {
        return new Object[]{1.8f, 0, 6.000f};
    }

    static Object[] prepare_fareFor_should_return_6_when_distance_is_2_0_kilometer() {
        return new Object[]{2.0f, 0, 6.00f};
    }

    static Object[] prepare_fareFor_should_return_9_when_distance_is_4_0_kilometer() {
        return new Object[]{4.0f, 0, 9.00f};
    }

    static Object[] prepare_fareFor_should_return_15_when_distance_is_8_0_kilometer() {
        return new Object[]{8.0f, 0, 15.00f};
    }

    static Object[] prepare_fareFor_should_return_17_25_when_distance_is_9_0_kilometer() {
        return new Object[]{9.0f, 0, 17.25f};
    }

    static Object[] prepare_fareFor_should_return_19_5_when_distance_is_10_0_kilometer() {
        return new Object[]{10.0f, 0, 19.50f};
    }

    static Object[] prepare_fareFor_should_return_17_75_when_distance_is_9_0_kilometer_and_waiting_2_minutes() {
        return new Object[]{9.0f, 2, 17.75f};
    }

    static Object[] prepare_fareFor_should_return_18_25_when_distance_is_9_0_kilometer_and_waiting_4_minutes() {
        return new Object[]{9.0f, 4, 18.25f};
    }
}
