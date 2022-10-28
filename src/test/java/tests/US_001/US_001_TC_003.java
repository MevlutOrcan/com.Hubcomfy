package tests.US_001;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_1_10_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US_001_TC_003 extends TestBaseRapor{
    US_1_10_Page tC003=new US_1_10_Page();
    @Test
    public void tc003(){

        extentTest=extentReports.createTest("US_001_TC_003","Email bos birakilamaz ");


        Driver.getDriver().get(ConfigReader.getProperty("hubcomfyUrl"));
        extentTest.info("Kullanici https://hubcomfy.com/ gider");


        tC003.register.click();
        extentTest.info("Kullanici register butonuna tiklar");


        tC003.becomeAVendor.click();
        extentTest.info("Kullanici 'Become a vendor' butonuna tiklar");


        tC003.userEmail.click();
        tC003.password.click();
        extentTest.info("Kullanici email box'a giris yapmadan password box'a tiklar");


        Assert.assertTrue(tC003.emailBosHatasi.isDisplayed());
        extentTest.pass("Kullanici email bos birakilmaz hatasini aldigini dogrular");
        Driver.closeDriver();
    }
}
