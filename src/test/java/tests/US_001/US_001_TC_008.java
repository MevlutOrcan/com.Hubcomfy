package tests.US_001;

import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_1_10_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_001_TC_008 extends TestBaseRapor {

    US_1_10_Page tC008=new US_1_10_Page();
    @Test
    public void tC008() {
        extentTest=extentReports.createTest("US_001_TC_008","Guclu bir password olusturulmali: kucuk harf, büyük harf, rakam ve special karakter kullanılmalı");
        Driver.getDriver().get("https://www.minuteinbox.com/");
        String eMailHanle=Driver.getDriver().getWindowHandle();
        String eMail=tC008.minutesMail.getText();
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get(ConfigReader.getProperty("hubcomfyUrl"));
        String hubcomfyHandle=Driver.getDriver().getWindowHandle();
        extentTest.info("Kullanici https://hubcomfy.com/ gider");


        tC008.register.click();
        extentTest.info("Kullanici register butonuna tiklar");


        tC008.becomeAVendor.click();
        extentTest.info("Kullanici Become a vendor butonuna tiklar");


        tC008.userEmail.sendKeys(eMail);
        ReusableMethods.waitFor(3);
        tC008.reSendCode.click();
        extentTest.info("Kullanici gecerli bir email girer");


        Driver.getDriver().switchTo().window(eMailHanle);
        ReusableMethods.waitFor(9);
        String code=tC008.eMailCode.getText().replaceAll("\\D","").substring(0,6);
        ReusableMethods.waitFor(3);
        extentTest.info("Kullanici girilen maile gelen code'i alabilmek icin mailine gider");


        Driver.getDriver().switchTo().window(hubcomfyHandle);
        tC008.verificationCode.sendKeys(code);
        ReusableMethods.waitFor(3);
        extentTest.info("Kullanici girdigi mail adresine gelen code 'u Verification Code box'ina girer");


        tC008.password.sendKeys("123Ab*");
        extentTest.info("Kullanici kucuk harf, büyük harf, rakam ve special karakter iceren password girer");


        Assert.assertEquals(tC008.strong.getText(),"Strong");
        extentTest.pass("Kullanici stong text'ini gorur");


        Driver.quitDriver();
    }
}
