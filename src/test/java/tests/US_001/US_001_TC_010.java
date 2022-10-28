package tests.US_001;

import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_1_10_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_001_TC_010 extends TestBaseRapor {

    US_1_10_Page tC010=new US_1_10_Page();
    @Test
    public void tC010() {
        extentTest=extentReports.createTest("US_001_TC_010","Password ayni sekilde tekrar kullanılmalı(negatif test)");

        Driver.getDriver().get("https://www.minuteinbox.com/");
        String eMailHanle=Driver.getDriver().getWindowHandle();
        String eMail=tC010.minutesMail.getText();
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get(ConfigReader.getProperty("hubcomfyUrl"));
        String hubcomfyHandle=Driver.getDriver().getWindowHandle();
        extentTest.info("Kullanici https://hubcomfy.com/ gider");


        tC010.register.click();
        extentTest.info("Kullanici register butonuna tiklar");


        tC010.becomeAVendor.click();
        extentTest.info("Kullanici Become a vendor butonuna tiklar");


        tC010.userEmail.sendKeys(eMail);
        ReusableMethods.waitFor(3);
        tC010.reSendCode.click();
        extentTest.info("Kullanici gecerli bir email girer");

        Driver.getDriver().switchTo().window(eMailHanle);
        ReusableMethods.waitFor(9);
        String code=tC010.eMailCode.getText().replaceAll("\\D","").substring(0,6);
        ReusableMethods.waitFor(3);
        extentTest.info("Kullanici girilen maile gelen code'i alabilmek icin mailine gider");

        Driver.getDriver().switchTo().window(hubcomfyHandle);
        tC010.verificationCode.sendKeys(code);
        ReusableMethods.waitFor(3);
        extentTest.info("Kullanici girdigi mail adresine gelen code 'u Verification Code box'ina girer");

        String sifre="123Ab*";
        String farkliSifre="1234Ab**";
        tC010.password.sendKeys(sifre);
        extentTest.info("Kullanici gecerli password girer");

        tC010.confirmPassword.sendKeys(farkliSifre);
        extentTest.info("Kullanici confirm password kısmına passworda girdigi sifreyi girer");

        tC010.registerButton.click();
        extentTest.info("Kullanici register butonuna tiklar");

        Assert.assertEquals(tC010.confirmPasswordErrorText.getText(),"Password and Confirm-password are not same.");
        extentTest.pass("Kullanici giris yapilamadigini dogrular");
        Driver.quitDriver();


    }
}
