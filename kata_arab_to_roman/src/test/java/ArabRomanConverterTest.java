import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by zeya on 14-10-8.
 */
@RunWith(Parameterized.class)
public class ArabRomanConverterTest {

    private int arabNumber;
    private String romanNumber;

    private ArabRomanConverter converter;

    public ArabRomanConverterTest(int arabNumber, String romanNumber) {
        this.arabNumber = arabNumber;
        this.romanNumber = romanNumber;
    }

    @Parameterized.Parameters
    public static Collection arabToRomanDatas() {
        return Arrays.asList(new Object[][]{
                {1, "I"},
                {2, "II"},
                {3, "III"},
                {4, "IV"},
                {5, "V"},
                {6, "VI"},
                {8, "VIII"},
                {9, "IX"},
                {10, "X"},
                {18, "XVIII"},
                {39, "XXXIX"},
                {40, "XL"},
                {41, "XLI"},
                {50, "L"},
                {89, "LXXXIX"},
                {90, "XC"},
                {100, "C"},
                {399, "CCCXCIX"},
                {400, "CD"},
                {500, "D"},
                {899, "DCCCXCIX"},
                {900, "CM"},
                {1000, "M"},
                {3999, "MMMCMXCIX"}
        });
    }

    @Before
    public void setUp() {
        converter = new ArabRomanConverter();
    }

    @Test
    public void test_arabNumber_to_romanNumber() throws Exception {
        assertThat(converter.convert(this.arabNumber), is(this.romanNumber));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_should_raise_exception_when_input_beyond_4000() throws Exception {
        converter.convert(4000);
    }

}
