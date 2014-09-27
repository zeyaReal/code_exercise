
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by zeya on 14-9-12.
 */
public class PreciseTexiMeterTest {

    private PreciseTexiMeter texiMeter;

    @Before
    public void setUp() {
        texiMeter = TexiMeterFactory.createPreciseTextMeter();
    }

    @Test
    public void test_fareFor_should_return_0_when_distance_is_0_kilometer() throws Exception {
        assertThat(texiMeter.fareFor(0f, 0), is(0f));
    }

    @Test
    public void test_fareForDistance_should_return_6_when_distance_is_1_8_kilometer() throws Exception {
        assertThat(texiMeter.fareFor(1.8f, 0), is(6.00f));
    }

    @Test
    public void test_fareFor_should_return_6_when_distance_is_2_0_kilometer() throws Exception {
        assertThat(texiMeter.fareFor(2.0f, 0), is(6.00f));
    }

    @Test
    public void test_fareForDistance_should_return_9_when_distance_is_4_0_kilometer() throws Exception {
        assertThat(texiMeter.fareFor(4.0f, 0), is(9.00f));
    }

    @Test
    public void test_fareFor_should_return_15_when_distance_is_8_0_kilometer() throws Exception {
        assertThat(texiMeter.fareFor(8.0f,0), is(15.00f));
    }

    @Test
    public void test_fareFor_should_return_17_25_when_distance_is_9_0_kilometer() throws Exception {
        assertThat(texiMeter.fareFor(9.0f, 0), is(17.25f));
    }

    @Test
    public void test_fareFor_should_return_19_5_when_distance_is_10_0_kilometer() throws Exception {
        assertThat(texiMeter.fareFor(10.0f, 0), is(19.50f));
    }

    @Test
    public void test_fareFor_should_return_17_75_when_distance_is_9_0_kilometer_and_waiting_2_minutes() throws Exception {
        assertThat(texiMeter.fareFor(9.0f, 2), is(17.75f));
    }

    @Test
    public void test_fareFor_should_return_18_25_when_distance_is_9_0_kilometer_and_waiting_4_minutes() throws Exception {
        assertThat(texiMeter.fareFor(9.0f, 4), is(18.25f));
    }
}
