package tests.US_001;

import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_1_10_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_001_TC_006 extends TestBaseRapor {

    US_1_10_Page tC006 = new US_1_10_Page();

    @Test
    public void tC006() {
        extentTest = extentReports.createTest("US_001_TC_006", "Email unique olmali");

        Driver.getDriver().get("https://www.minuteinbox.com/");
        String eMailHanle = Driver.getDriver().getWindowHandle();
        String eMail = tC006.minutesMail.getText();
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get(ConfigReader.getProperty("hubcomfyUrl"));
        String hubcomfyHandle = Driver.getDriver().getWindowHandle();
        extentTest.info("Kullanici https://hubcomfy.com/ gider");


        tC006.register.click();
        extentTest.info("Kullanici register butonuna tiklar");


        tC006.becomeAVendor.click();
        extentTest.info("Kullanici Become a vendor butonuna tiklar");


        tC006.userEmail.sendKeys(eMail);
        ReusableMethods.waitFor(3);
        tC006.reSendCode.click();
        extentTest.info("Kullanici uniqe bir email girer");


        Driver.getDriver().switchTo().window(eMailHanle);
        ReusableMethods.waitFor(9);
        String code = tC006.eMailCode.getText().replaceAll("\\D", "").substring(0, 6);
        ReusableMethods.waitFor(3);
        extentTest.info("Kullanici girilen maile gelen code'i alabilmek icin mailine gider");

        Driver.getDriver().switchTo().window(hubcomfyHandle);
        tC006.verificationCode.sendKeys(code);
        ReusableMethods.waitFor(3);
        extentTest.info("Kullanici girdigi mail adresine gelen code 'u Verification Code box'ina girer");

        tC006.password.sendKeys("123Ab*");
        extentTest.info("Kullanici gecerli password girer");

        tC006.confirmPassword.sendKeys("123Ab*");
        extentTest.info("Kullanici gecerli confirm password girer");

        tC006.registerButton.click();
        ReusableMethods.waitFor(3);
        extentTest.info("Kullanici register butonuna tiklar");

        Driver.getDriver().navigate().back();
        ReusableMethods.waitFor(3);
        Assert.assertTrue(tC006.validEMailText.isDisplayed());
        ReusableMethods.waitFor(3);
        extentTest.pass("Kullanici giris yapilabildigini dogrular");
        Driver.quitDriver();
    }
}
