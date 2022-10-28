package tests.US_020;

import org.testng.annotations.Test;

public class US_020_Runner extends US_020_TC_01_02 {

    @Test
    public void test_US_020() {

        test_US_020_OrtakKisim();
        test_US_020_TC_001();
        test_US_020_TC_002();
    }
}
