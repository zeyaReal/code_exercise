import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by zeya on 14-10-8.
 */
public class ArabRomanConverterTest {
    @Test
    public void test_should_return_I_when_input_1() throws Exception {
        ArabRomanConverter converter = new ArabRomanConverter();
        assertThat(converter.convert(1), is("I"));
    }

    @Test
    public void test_should_return_II_when_input_2() throws Exception {
        ArabRomanConverter converter = new ArabRomanConverter();
        assertThat(converter.convert(2), is("II"));
    }
}
