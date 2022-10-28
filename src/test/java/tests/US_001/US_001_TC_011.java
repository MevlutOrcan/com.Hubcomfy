package tests.US_001;

import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_1_10_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_001_TC_011 extends TestBaseRapor {

    US_1_10_Page tC011 = new US_1_10_Page();

    @Test
    public void tC011() {
        extentTest = extentReports.createTest("US_001_TC_011", "Email uzerinden account onaylanmalı");

        Driver.getDriver().get("https://www.minuteinbox.com/");
        String eMailHanle = Driver.getDriver().getWindowHandle();
        String eMail = tC011.minutesMail.getText();
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get(ConfigReader.getProperty("hubcomfyUrl"));
        String hubcomfyHandle = Driver.getDriver().getWindowHandle();
        extentTest.info("Kullanici https://hubcomfy.com/ gider");


        tC011.register.click();
        extentTest.info("Kullanici register butonuna tiklar");


        tC011.becomeAVendor.click();
        extentTest.info("Kullanici Become a vendor butonuna tiklar");


        tC011.userEmail.sendKeys(eMail);
        ReusableMethods.waitFor(3);
        tC011.reSendCode.click();
        extentTest.info("Kullanici gecerli bir email girer");


        Driver.getDriver().switchTo().window(eMailHanle);
        ReusableMethods.waitFor(9);
        String code = tC011.eMailCode.getText().replaceAll("\\D", "").substring(0, 6);
        ReusableMethods.waitFor(3);
        extentTest.info("Kullanici girilen maile gelen code'i alabilmek icin mailine gider");


        Driver.getDriver().switchTo().window(hubcomfyHandle);
        tC011.verificationCode.sendKeys(code);
        ReusableMethods.waitFor(3);
        extentTest.info("Kullanici girdigi mail adresine gelen code 'u Verification Code box'ina girer");


        String sifre = "123Ab*";
        tC011.password.sendKeys(sifre);
        extentTest.info("Kullanici gecerli password girer");


        tC011.confirmPassword.sendKeys(sifre);
        extentTest.info("Kullanici confirm password kısmına passworda girdigi sifreyi girer");

        ReusableMethods.waitFor(3);
        ReusableMethods.jsclick(tC011.registerButton);
        extentTest.info("Kullanici register butonuna tiklar");


        ReusableMethods.waitFor(6);
        Assert.assertTrue(tC011.welcomeToHubcomfy.isDisplayed());
        extentTest.pass("Kullanici sayfaya vendor olarak giris yapabildigini dogrular");

        Driver.quitDriver();
    }
}
