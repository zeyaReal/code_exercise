import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by zeya on 14-9-1.
 */
public class PrimeTest {

    @Test
    public void test_should_return_2_when_input_2() {
        assertThat(Prime.factor(2), is(Arrays.asList(2)));
    }

    @Test
    public void test_should_return_3_when_input_3() {
        assertThat(Prime.factor(3), is(Arrays.asList(3)));
    }

    @Test
    public void test_should_return_2_2_when_input_4() {
        assertThat(Prime.factor(4), is(Arrays.asList(2, 2)));
    }

    @Test
    public void test_should_return_2_3_when_input_6() throws Exception {

        assertThat(Prime.factor(6), is(Arrays.asList(2, 3)));
    }

    @Test
    public void test_should_return_2_2_2_when_input_8() throws Exception {
        assertThat(Prime.factor(8), is(Arrays.asList(2, 2, 2)));
    }

    @Test
    public void test_should_return_3_3_when_input_9() throws Exception {
        assertThat(Prime.factor(9), is(Arrays.asList(3, 3)));
    }

    @Test
    public void test_should_return_2_7_7_11_23_when_input_24794() throws Exception {
        assertThat(Prime.factor(24794), is(Arrays.asList(2, 7, 7, 11, 23)));
    }
}
