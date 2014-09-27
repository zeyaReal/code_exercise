import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RoundTexiMeterTest {
    private RoundTexiMeter texiMeter;

    @Before
    public void setUp() {
        texiMeter = TexiMeterFactory.createRoundTextMeter();
    }

    @Test
    public void test_roundFareForDistance_should_return_20_when_distance_is_10_0_kilometer() throws Exception {
        assertThat(texiMeter.fareFor(10.0f, 0), is(20.0f));
    }

    @Test
    public void test_roundFareForDistance_should_return_17_when_distance_is_9_0_kilometer() throws Exception {
        assertThat(texiMeter.fareFor(9.0f, 0), is(17.0f));
    }


    @Test
    public void test_roundFareForDistanceAndWaitingMinutes_should_return_18_when_distance_is_9_0_kilometer_and_waiting_4_minutes() throws Exception {
        assertThat(texiMeter.fareFor(9.0f, 4), is(18f));
    }

    @Test
    public void test_roundFareForDistanceAndWaitingMinutes_should_return_18_when_distance_is_9_0_kilometer_and_waiting_2_minutes() throws Exception {
        assertThat(texiMeter.fareFor(9.0f, 2), is(18f));
    }

}