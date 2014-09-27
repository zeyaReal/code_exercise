import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TexiMeterFactoryTest {

    @Test
    public void test_createTexiMeter_should_return_roundTexiMeter() throws Exception {
        //XXX isA应该怎么用？
//        assertThat(TexiMeterFactory.createTextMeter(), Matchers.isA(RoundTexiMeter.class));
        assertTrue(TexiMeterFactory.createTextMeter() instanceof  RoundTexiMeter);
    }
}