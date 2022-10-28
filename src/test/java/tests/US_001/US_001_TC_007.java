package tests.US_001;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_1_10_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_001_TC_007 extends TestBaseRapor {

    US_1_10_Page tC007 = new US_1_10_Page();

    @Test
    public void tC007() {
        extentTest = extentReports.createTest("US_001_TC_007", "Email unique olmali(negatif test)");


        Driver.getDriver().get(ConfigReader.getProperty("hubcomfyUrl"));
        extentTest.info("Kullanici https://hubcomfy.com/ gider");


        tC007.register.click();
        extentTest.info("Kullanici register butonuna tiklar");


        tC007.becomeAVendor.click();
        extentTest.info("Kullanici Become a vendor butonuna tiklar");


        tC007.userEmail.sendKeys("yelizerdogan1988@gmail.com");
        extentTest.info("Kullanici uniqe olmayan bir email girer");


        tC007.verificationCode.sendKeys("497259");
        ReusableMethods.waitFor(3);
        extentTest.info("Kullanici girdigi mail adresine gelen code 'u Verification Code box'ina girer");

        tC007.password.sendKeys("123Ab*");
        extentTest.info("Kullanici gecerli password girer");

        tC007.confirmPassword.sendKeys("123Ab*");
        extentTest.info("Kullanici gecerli confirm password girer");

        tC007.registerButton.click();
        extentTest.info("Kullanici register butonuna tiklar");

        Assert.assertEquals(tC007.alreadyExists.getText(), "This Email already exists. Please login to the site and apply as vendor.");
        extentTest.pass("Kullanici uniqe olmayan email ile vendor olarak giris yapamadigini dogrular");

        Driver.closeDriver();
    }
}
