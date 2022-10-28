package tests.US_001;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_1_10_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_001_TC_005 extends TestBaseRapor {
    US_1_10_Page tC005=new US_1_10_Page();
    @Test
    public void tC005() {
        extentTest=extentReports.createTest("US_001_TC_005","Gecerli bir email olmali(negatif test)");

        Driver.getDriver().get(ConfigReader.getProperty("hubcomfyUrl"));
        extentTest.info("Kullanici https://hubcomfy.com/ gider");

        tC005.register.click();
        extentTest.info("Kullanici register butonuna tiklar");

        tC005.becomeAVendor.click();
        extentTest.info("Kullanici Become a vendor butonuna tiklar");

        tC005.userEmail.sendKeys("yelizgmail.com");
        extentTest.info("Kullanici gecersiz bir email girer");
        ReusableMethods.waitFor(3);

        tC005.password.click();
        extentTest.info("Kullanici password box'ina tiklar");

        ReusableMethods.waitFor(3);
        Assert.assertTrue(tC005.inValidEMailText.isDisplayed());
        extentTest.pass("Kullanici gecersiz email ile giris yapamadigini dogrular");

        Driver.closeDriver();
    }
}
