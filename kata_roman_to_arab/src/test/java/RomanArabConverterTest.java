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
                {"III", 3}
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
