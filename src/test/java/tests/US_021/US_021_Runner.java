package tests.US_021;

import org.testng.annotations.Test;

public class US_021_Runner extends US_021_Test_01_02 {

     @Test
     public void test_US_021() throws InterruptedException {

          testUS_021_OrtakKisim();
          testUS_021_TC_001();
          testUS_021_TC_002();
     }
}
