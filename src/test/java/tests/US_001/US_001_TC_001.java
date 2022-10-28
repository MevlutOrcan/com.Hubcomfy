package tests.US_001;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_1_10_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US_001_TC_001 extends TestBaseRapor {
    US_1_10_Page tC001 = new US_1_10_Page();

    @Test
    public void tC001() {

        extentTest = extentReports.createTest("US_001_TC_001", "Vendor olarak kayıt icin ‘Become a vendor’ butonu ile navigate ediniz");

        Driver.getDriver().get(ConfigReader.getProperty("hubcomfyUrl"));
        extentTest.info("Kullanici https://hubcomfy.com/ gider");


        String expectedUrl = "https://hubcomfy.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
        extentTest.info("Kullanici ana sayfaya gittigini dogrular");


        tC001.register.click();
        extentTest.info("Kullanici register butonuna tiklar");


        tC001.becomeAVendor.click();
        extentTest.info("Kullanici 'Become a vendor' butonuna tiklar");


        Assert.assertTrue(tC001.vendorRegistration.isDisplayed());
        extentTest.pass("Kullanici 'Vendor Registration' yazisinin gorunur oldugunu dogrular");

        Driver.closeDriver();
    }
}
