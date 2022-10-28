package tests.US_001;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_1_10_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US_001_TC_002 extends TestBaseRapor {
    US_1_10_Page tC002=new US_1_10_Page();
    @Test
    public void tc002() {

        extentTest=extentReports.createTest("US_001_TC_002","Registration sayfasında uc özellik olmalı; email, password, confirm password");


        Driver.getDriver().get(ConfigReader.getProperty("hubcomfyUrl"));
        extentTest.info("Kullanici https://hubcomfy.com/ gider");


        tC002.register.click();
        extentTest.info("Kullanici register butonuna tiklar");


        tC002.becomeAVendor.click();
        extentTest.info("Kullanici 'Become a vendor' butonuna tiklar");


        Assert.assertTrue(tC002.userEmail.isDisplayed());
        extentTest.info("Kullanici 'Vendor Registration' sayfasinda email box'inin oldugunu dogrular");


        Assert.assertTrue(tC002.password.isDisplayed());
        extentTest.info("Kullanici 'Vendor Registration' sayfasinda  password box'inin oldugunu dogrular");


        Assert.assertTrue(tC002.confirmPassword.isDisplayed());
        extentTest.pass("Kullanici 'Vendor Registration' sayfasinda confirm password box'inin oldugunu dogrular");
        Driver.closeDriver();
    }
}
