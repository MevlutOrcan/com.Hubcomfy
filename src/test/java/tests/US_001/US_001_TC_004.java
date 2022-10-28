package tests.US_001;

import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_1_10_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_001_TC_004 extends TestBaseRapor {
    US_1_10_Page tC004 = new US_1_10_Page();

    @Test
    public void tC004() {
        extentTest = extentReports.createTest("US_001_TC_004", "Gecerli bir email olmali");
        Driver.getDriver().get("https://www.minuteinbox.com/");
        extentTest.info("Kullanici https://www.minuteinbox.com/ sayfasina gider");

        String eMail = tC004.minutesMail.getText();
        extentTest.info("Kullanici minuteinbox sayfasindan email alir");

        String eMailHanle = Driver.getDriver().getWindowHandle();
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        extentTest.info("Kullanici yeni tab acar");

        Driver.getDriver().get(ConfigReader.getProperty("hubcomfyUrl"));
        String hubcomfyHandle = Driver.getDriver().getWindowHandle();
        extentTest.info("Kullanici https://hubcomfy.com/ gider");


        tC004.register.click();
        extentTest.info("Kullanici register butonuna tiklar");


        tC004.becomeAVendor.click();
        extentTest.info("Kullanici Become a vendor butonuna tiklar");

        //4-Kullanici gecerli bir email girer
        tC004.userEmail.sendKeys(eMail);
        extentTest.info("Kullanici Become a vendor butonuna tiklar");

        ReusableMethods.waitFor(3);
        tC004.reSendCode.click();
        extentTest.info("Kullanici Re Send Code butonuna tiklar");

        ReusableMethods.waitFor(3);
        Driver.getDriver().switchTo().window(eMailHanle);
        ReusableMethods.waitFor(10);
        extentTest.info("Kullanici https://www.minuteinbox.com/ sayfasina doner");

        String code = tC004.eMailCode.getText().replaceAll("\\D", "").substring(0, 6);
        ReusableMethods.waitFor(3);

        Driver.getDriver().switchTo().window(hubcomfyHandle);
        extentTest.info("Kullanici https://hubcomfy.com/ sayfasina doner");


        tC004.verificationCode.sendKeys(code);
        ReusableMethods.waitFor(3);
        extentTest.info("Kullanici Verification Code girer");

        tC004.password.sendKeys("123Ab*");
        extentTest.info("Kullanici gecerli password girer");

        tC004.confirmPassword.sendKeys("123Ab*");
        extentTest.info("Kullanici gecerli confirm password girer");

        tC004.registerButton.click();
        ReusableMethods.waitFor(3);
        extentTest.info("Kullanici register butonuna tiklar");

        Driver.getDriver().navigate().back();
        ReusableMethods.waitFor(3);
        Assert.assertTrue(tC004.validEMailText.isDisplayed());
        ReusableMethods.waitFor(3);
        extentTest.pass("Kullanici giris yapilabildigini dogrular");


        Driver.quitDriver();

    }
}
