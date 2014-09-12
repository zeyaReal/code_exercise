import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by zeya on 14-9-12.
 */
public class TexiMeterTest {

    @Test
    public void test_fareForDistance_should_return_0_when_distance_is_0_kilometer() throws Exception {
        TexiMeter texiMeter = new TexiMeter();
        assertThat(texiMeter.fareForDistance(0f), is(0f));
    }

    @Test
    public void test_fareForDistance_should_return_6_when_distance_is_1_8_kilometer() throws Exception {
        TexiMeter texiMeter = new TexiMeter();
        assertThat(texiMeter.fareForDistance(1.8f), is(6.00f));
    }

    @Test
    public void test_fareForDistance_should_return_6_when_distance_is_2_0_kilometer() throws Exception {
        TexiMeter texiMeter = new TexiMeter();
        assertThat(texiMeter.fareForDistance(2.0f), is(6.00f));
    }

    @Test
    public void test_fareForDistance_should_return_9_when_distance_is_4_0_kilometer() throws Exception {
        TexiMeter texiMeter = new TexiMeter();
        assertThat(texiMeter.fareForDistance(4.0f), is(9.00f));
    }

    @Test
    public void test_fareForDistance_should_return_15_when_distance_is_8_0_kilometer() throws Exception {
        TexiMeter texiMeter = new TexiMeter();
        assertThat(texiMeter.fareForDistance(8.0f), is(15.00f));
    }

    @Test
    public void test_fareForDistance_should_return_17_25_when_distance_is_9_0_kilometer() throws Exception {
        TexiMeter texiMeter = new TexiMeter();
        assertThat(texiMeter.fareForDistance(9.0f), is(17.25f));
    }

    @Test
    public void test_fareForDistance_should_return_19_5_when_distance_is_10_0_kilometer() throws Exception {
        TexiMeter texiMeter = new TexiMeter();
        assertThat(texiMeter.fareForDistance(10.0f), is(19.50f));
    }

    @Test
    public void test_roundFareForDistance_should_return_20_when_distance_is_10_0_kilometer() throws Exception {
        TexiMeter texiMeter = new TexiMeter();
        assertThat(texiMeter.roundFareForDistance(10.0f), is(20));
    }

    @Test
    public void test_roundFareForDistance_should_return_17_when_distance_is_9_0_kilometer() throws Exception {
        TexiMeter texiMeter = new TexiMeter();
        assertThat(texiMeter.roundFareForDistance(9.0f), is(17));
    }

    @Test
    public void test_fareForDistanceAndWaitingMinutes_should_return_17_75_when_distance_is_9_0_kilometer_and_waiting_2_minutes() throws Exception {
        TexiMeter texiMeter = new TexiMeter();
        assertThat(texiMeter.fareForDistanceAndWaitingMinutes(9.0f, 2), is(17.75f));
    }

    @Test
    public void test_fareForDistanceAndWaitingMinutes_should_return_17_50_when_distance_is_9_0_kilometer_and_waiting_4_minutes() throws Exception {
        TexiMeter texiMeter = new TexiMeter();
        assertThat(texiMeter.fareForDistanceAndWaitingMinutes(9.0f, 4), is(18.25f));
    }


}
