package tests.US_018;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.US_2_18_19_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import static tests.US_002.US_002_TC_001_Login.ortakAdimlar;

public class US_018_TC_004_IadeSebebi extends TestBaseRapor {
    US_2_18_19_Page us_page = new US_2_18_19_Page();

    @Test
    public void test01Login() throws InterruptedException {
        extentTest = extentReports.createTest("Ürün tipi ve iade sebebi görülmeli.");

       ortakAdimlar();


        us_page.storeManagerLink.click();
        ReusableMethods.waitFor(3);
        extentTest.info("7-Store Manager  yazısına tıklar");

        ReusableMethods.jsclick(us_page.RefundLink);
        extentTest.info("8-Refund yazısına tıklar");
        ReusableMethods.getActions().sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);

        Assert.assertTrue(us_page.UrunTipi.isDisplayed());
        extentTest.pass("Urun tipi görünür olduğu doğrulanır ");

        Assert.assertTrue(us_page.ReasonSebebi.isDisplayed());
        extentTest.pass("Urun iade sebebi görünür olduğu doğrulanır ");
        Driver.closeDriver();

    }

}
