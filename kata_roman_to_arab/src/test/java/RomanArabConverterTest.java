import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by zeya on 14-10-24.
 */
public class RomanArabConverterTest {

    @Test
    public void test_convert_I_to_1() throws Exception {
        RomanArabConverter converter = new RomanArabConverter();
        assertThat(1, is(converter.convert("I")));
    }
}
