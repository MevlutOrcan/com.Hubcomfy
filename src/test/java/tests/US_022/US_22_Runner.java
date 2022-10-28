package tests.US_022;

import org.testng.annotations.Test;

import java.io.IOException;

public class US_22_Runner extends US_022_Test_01_02_03_04 {

    @Test
    public void test_US_022() throws IOException {

        testUS_022_OrtakKisim();
        testUS_022_TC_001();
        testUS_022_TC_002();
        testUS_022_TC_003();
        testUS_022_TC_004();

    }
}
