import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by zeya on 14-10-8.
 */
public class ArabRomanConverterTest {

    private ArabRomanConverter converter;

    @Before
    public void setUp() {
        converter = new ArabRomanConverter();
    }

    @Test
    public void test_should_return_I_when_input_1() throws Exception {
        assertThat(converter.convert(1), is("I"));
    }

    @Test
    public void test_should_return_II_when_input_2() throws Exception {
        assertThat(converter.convert(2), is("II"));
    }

    @Test
    public void test_should_return_III_when_input_3() throws Exception {
        assertThat(converter.convert(3), is("III"));
    }

    @Test
    public void test_should_return_V_when_input_5() throws Exception {
        assertThat(converter.convert(5), is("V"));
    }

    @Test
    public void test_should_return_IV_when_input_4() throws Exception {
        assertThat(converter.convert(4), is("IV"));
    }

    @Test
    public void test_should_return_VI_when_input_6() throws Exception {
        assertThat(converter.convert(6), is("VI"));
    }

    @Test
    public void test_should_return_VIII_when_input_8() throws Exception {
        assertThat(converter.convert(8), is("VIII"));
    }

    @Test
    public void test_should_return_IX_when_input_9() throws Exception {
        assertThat(converter.convert(9), is("IX"));
    }



}
