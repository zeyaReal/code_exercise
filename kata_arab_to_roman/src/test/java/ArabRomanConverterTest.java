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

    @Test
    public void test_should_return_X_when_input_10() throws Exception {
        assertThat(converter.convert(10), is("X"));
    }

    @Test
    public void test_should_return_XVIII_when_input_18() throws Exception {
        assertThat(converter.convert(18), is("XVIII"));
    }

    @Test
    public void test_should_return_XXXIX_when_input_39() throws Exception {
        assertThat(converter.convert(39), is("XXXIX"));
    }

    @Test
    public void test_should_return_XL_when_input_40() throws Exception {
        assertThat(converter.convert(40), is("XL"));
    }

    @Test
    public void test_should_return_XLI_when_input_41() throws Exception {
        assertThat(converter.convert(41), is("XLI"));
    }

    @Test
    public void test_should_return_XLIV_when_input_44() throws Exception {
        assertThat(converter.convert(44), is("XLIV"));
    }

    @Test
    public void test_should_return_L_when_input_50() throws Exception {
        assertThat(converter.convert(50), is("L"));
    }

    @Test
    public void test_should_return_LXXXIX_when_input_89() throws Exception {
        assertThat(converter.convert(89), is("LXXXIX"));
    }

    @Test
    public void test_should_return_XC_when_input_90() throws Exception {
        assertThat(converter.convert(90), is("XC"));
    }

    @Test
    public void test_should_return_C_when_input_100() throws Exception {
        assertThat(converter.convert(100), is("C"));
    }

    @Test
    public void test_should_return_CCCXCIX_when_input_399() throws Exception {
        assertThat(converter.convert(399), is("CCCXCIX"));
    }

    @Test
    public void test_should_return_CD_when_input_400() throws Exception {
        assertThat(converter.convert(400), is("CD"));
    }

    @Test
    public void test_should_return_D_when_input_500() throws Exception {
        assertThat(converter.convert(500), is("D"));
    }

    @Test
    public void test_should_return_DCCCXCIX_when_input_899() throws Exception {
        assertThat(converter.convert(899), is("DCCCXCIX"));
    }

    @Test
    public void test_should_return_CM_when_input_900() throws Exception {
        assertThat(converter.convert(900), is("CM"));
    }

    @Test
    public void test_should_return_M_when_input_1000() throws Exception {
        assertThat(converter.convert(1000), is("M"));
    }

}
