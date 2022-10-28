package tests.US_003;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_003_TC_005Order extends US_003_TC_004Billing {
    @Test
    public void test01Order() {
        extentTest = extentReports.createTest("US_003 Vendor olarak, order verebilmeliyim ve orderlarimi sepette görebilmeliyim", "Kullanici order in basarili sekilde alindigi mesajini gorebilmeli");

        test01Billing();
        ReusableMethods.waitFor(5);
        executor.executeScript("arguments[0].scrollIntoView(true);",us_3_4_11_page.placeOrderButton);
        ReusableMethods.jsclick(us_3_4_11_page.placeOrderButton);
        extentTest.info("20-Kulllanici PLACE ORDER Butonuna tiklar");
        ReusableMethods.waitFor(3);
        Assert.assertTrue(us_3_4_11_page.doneOrder.isDisplayed());
        extentTest.info("21-Kullanici Order in gerceklestigini dogrular");
        extentTest.pass("Kullanici order in basarili sekilde alindigi mesajini gorebilmeli");
        Driver.quitDriver();
    }
}
