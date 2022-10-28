package tests.US_005;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.US_005_006_007_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;

public class US_005_TC_001_ProductList extends TestBaseRapor {
    public static US_005_006_007_Page us_005_006_007_page = new US_005_006_007_Page();
    static private Actions actions = new Actions(Driver.getDriver());
    static private SoftAssert softAssert = new SoftAssert();

    public static void ortakStepler() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("hubcomfyUrl"));
        extentTest.info("1-Kullanici https://hubcomfy.com/ sayfasina gider");


        us_005_006_007_page.HomesignInButton.click();
        Thread.sleep(2000);
        extentTest.info("2-Kullanici sign in butonuna tiklar");


        us_005_006_007_page.userNameTextBox.sendKeys("hasan");
        extentTest.info("3-Kullanici gecerli user name veya email adres girer");


        us_005_006_007_page.passwordTextBox.sendKeys("Team02.Batch81");
        extentTest.info("4-Kullanici gecerli password girer");


        us_005_006_007_page.kullaniciGirisSignIn.click();
        Thread.sleep(2000);
        extentTest.info("5-Kullanici sign in butonuna tiklar");


        actions.sendKeys(Keys.END).perform();
        Thread.sleep(2000);
        extentTest.info("6-Kullanici sayfanin en altina iner");


        ReusableMethods.jsclick(us_005_006_007_page.myAccountLink);
        extentTest.info("7-Kullanici My Account linkine tiklar");


        us_005_006_007_page.storeManagerLink.click();
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        extentTest.info("8-Kullanici Store Manager butonuna tiklar");


        ReusableMethods.jsclick(us_005_006_007_page.productsLink);
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        extentTest.info("9-Kullanici Products butonuna tiklar");

    }


    @Test
    public void TC_001() throws InterruptedException {

        extentTest = extentReports.createTest("US_005_TC_001", "Productsta urun listemi görmeliyim; status, stock, price, date basliklarini icermeli");

        ortakStepler();


        List<WebElement> productsTitles = us_005_006_007_page.urunListesiBasliklari;
        String urunlerinBAsliklari = "";
        for (WebElement w : productsTitles) {
            urunlerinBAsliklari += " " + w.getText();
        }

        Assert.assertTrue(urunlerinBAsliklari.contains("Status"));
        Assert.assertTrue(urunlerinBAsliklari.contains("Stock"));
        Assert.assertTrue(urunlerinBAsliklari.contains("Price"));
        Assert.assertTrue(urunlerinBAsliklari.contains("Date"));
        extentTest.pass("10-Kullanici Productsta urun listesini gorebilmeli; status, stock, price, date gorur");
        Driver.closeDriver();
    }
}
