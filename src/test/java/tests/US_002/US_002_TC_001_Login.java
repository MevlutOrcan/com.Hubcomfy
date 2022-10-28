package tests.US_002;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.US_2_18_19_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_002_TC_001_Login extends TestBaseRapor {

    static public US_2_18_19_Page us_page = new US_2_18_19_Page();
    public static void ortakAdimlar(){
        Driver.getDriver().get(ConfigReader.getProperty("hubcomfyUrl"));
        extentTest.info("1-Kullanici https://hubcomfy.com/ adresine gider");
        ReusableMethods.waitFor(3);
        us_page.SignInButton.click();
        extentTest.info("2-Kullanici sign in butonuna tiklar");
        ReusableMethods.waitFor(3);
        us_page.emailBox.sendKeys("kevserharmanci3842@gmail.com");
        extentTest.info("3-Kullanici gecerli email girer");
        ReusableMethods.waitFor(3);
        us_page.passwordBox.sendKeys("3541Kevser.");
        extentTest.info("4-Kullanici gecerli Password  girer");
        ReusableMethods.waitFor(3);
        us_page.loginButton.click();
        extentTest.info("5-Kullanici Sign In Butonuna tiklar");
        ReusableMethods.waitFor(3);
        ReusableMethods.jsclick(us_page.myAccountButton);
        extentTest.info("6-Kullanici My Account butonuna tiklar");
        ReusableMethods.waitFor(3);
        Assert.assertTrue(us_page.myAccountText.isDisplayed());

        extentTest.pass("7-Kullanici MyAccount sayfasina gittigini dogrular.");

    }

    @Test
    public void test01Login() throws InterruptedException {
        extentTest = extentReports.createTest("US_003 Vendor olarak, ", "gecerli email ve şifre girilmeli ve sistemde My Accout görünmeli");
       ortakAdimlar();
       Driver.closeDriver();
    }
    @Test
    public void test002LoginNegatifInvalidPass() {
        extentTest=extentReports.createTest("HubcomfyLoginPozitifTest", "Gecerli Kullanici adi ve Passord Ile Giris Yapildi");
        Driver.getDriver().get(ConfigReader.getProperty("hubcomfyUrl"));
        extentTest.info("1-Kullanici https://hubcomfy.com/ adresine gider");
        us_page.SignInButton.click();
        extentTest.info("2-Kullanici sign in butonuna tiklar");
        us_page.emailBox.sendKeys("mevlutorcan");
        extentTest.info("3-Kullanici gecerli Username girer");
        us_page.passwordBox.sendKeys("fdswervcxz");
        extentTest.info("4-Kullanici gecerli Password  girer");
        us_page.loginButton.click();
        extentTest.info("5-Kullanici Sign In Butonuna tiklar");
        Assert.assertTrue(us_page.invalidWrongText.isDisplayed());
        Driver.closeDriver();

    }
    @Test
    public void test003LoginNegatifInvalidEmail() {
        extentTest=extentReports.createTest("HubcomfyLoginPozitifTest", "Gecerli Kullanici adi ve Passord Ile Giris Yapildi");
        Driver.getDriver().get(ConfigReader.getProperty("hubcomfyUrl"));
        extentTest.info("1-Kullanici https://hubcomfy.com/ adresine gider");
        us_page.SignInButton.click();
        extentTest.info("2-Kullanici sign in butonuna tiklar");
        us_page.emailBox.sendKeys("aoksdmosan");
        extentTest.info("3-Kullanici gecerli Username girer");
        us_page.passwordBox.sendKeys("Zaq12wsx");
        extentTest.info("4-Kullanici gecerli Password  girer");
        us_page.loginButton.click();
        extentTest.info("5-Kullanici Sign In Butonuna tiklar");
        Assert.assertTrue(us_page.invalidWrongText.isDisplayed());
        Driver.closeDriver();

    }
    @Test
    public void test004LoginNegatifInvalidEmailPass() {
        extentTest=extentReports.createTest("HubcomfyLoginPozitifTest", "Gecerli Kullanici adi ve Passord Ile Giris Yapildi");
        Driver.getDriver().get(ConfigReader.getProperty("hubcomfyUrl"));
        extentTest.info("1-Kullanici https://hubcomfy.com/ adresine gider");
        us_page.SignInButton.click();
        extentTest.info("2-Kullanici sign in butonuna tiklar");
        us_page.emailBox.sendKeys("qasddfvvvb");
        extentTest.info("3-Kullanici gecerli Username girer");
        us_page.passwordBox.sendKeys("fdswervcxz");
        extentTest.info("4-Kullanici gecerli Password  girer");
        us_page.loginButton.click();
        extentTest.info("5-Kullanici Sign In Butonuna tiklar");
        Assert.assertTrue(us_page.invalidWrongText.isDisplayed());
        Driver.closeDriver();

    }

}
