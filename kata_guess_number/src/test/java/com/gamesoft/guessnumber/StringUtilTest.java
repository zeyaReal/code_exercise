package com.gamesoft.guessnumber;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;

/**
 * Created by zeya on 14-9-27.
 */
public class StringUtilTest {
    @Test
    public void test_should_return_int_array_1_5_6_7when_input__1__5_6___7__string() throws Exception {
        assertThat(StringUtil.convertToIntArray(" 1   5 6    7 "), equalTo(new int[]{1,5,6,7}));
    }

    @Test
    public void test_should_return_int_array_1_5_when_input_2__5_string() throws Exception {
        assertThat(StringUtil.convertToIntArray(" 2  5"), equalTo(new int[]{2,5}));
    }


    @Test(expected = IllegalArgumentException.class)
    public void test_should_raise_exception_when_input_nonnumeric_string() throws Exception {
        StringUtil.convertToIntArray(" c1 ");
    }

}
