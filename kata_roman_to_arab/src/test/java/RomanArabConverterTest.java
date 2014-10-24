import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by zeya on 14-10-24.
 */
public class RomanArabConverterTest {

    private RomanArabConverter converter;

    @Before
    public void setUp() {
        converter = new RomanArabConverter();
    }

    @Test
    public void test_convert_I_to_1() throws Exception {
        assertThat(1, is(converter.convert("I")));
    }

    @Test
    public void test_convert_II_to_2() throws Exception {
        assertThat(2, is(converter.convert("II")));
    }
}
