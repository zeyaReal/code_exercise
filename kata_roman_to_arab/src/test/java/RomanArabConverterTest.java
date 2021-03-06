import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by zeya on 14-10-24.
 */
@RunWith(Parameterized.class)
public class RomanArabConverterTest {

    private RomanArabConverter converter;
    private String romanNumber;
    private int arabNumber;

    public RomanArabConverterTest(String romanNumber, int arabNumber) {
        this.romanNumber = romanNumber;
        this.arabNumber = arabNumber;
    }

    @Parameterized.Parameters
    public static Collection romanToArabDCatas() {
        return Arrays.asList(new Object[][]{
                {"I",   1},
                {"II",  2},
                {"III", 3},
                {"IV",  4},
                {"V",   5},
                {"VI",  6},
                {"VIII",8},
                {"IX",  9},
                {"X",  10},
                {"XVIII",18},
                {"XXXIX",39},
                {"XL", 40},
                {"XLI",41},
                {"L", 50},
                {"LXXXIX", 89},
                {"XC", 90},
                {"C", 100},
                {"CCCXCIX", 399},
                {"CD", 400},
                {"D", 500},
                {"DCCCXCIX", 899},
                {"CM",900},
                {"M", 1000},
                {"MMMCMXCIX", 3999}
        });
    }

    @Before
    public void setUp() {
        converter = new RomanArabConverter();
    }

    @Test
    public void test_convert_romanNumber_to_ArabNumber() throws Exception {
        assertThat(this.arabNumber, is(converter.convert(this.romanNumber)));
    }
}
