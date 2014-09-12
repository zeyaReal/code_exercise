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


}
