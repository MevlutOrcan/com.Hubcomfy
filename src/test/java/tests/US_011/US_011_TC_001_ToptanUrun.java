package tests.US_011;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_3_4_11_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class US_011_TC_001_ToptanUrun extends TestBaseRapor {
    US_3_4_11_Page us_3_4_11_page = new US_3_4_11_Page();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
    Faker faker = new Faker();

    @Test
    public void test01PieceType() {
        extentTest = extentReports.createTest("Toptan urun gösterme ayarlari", "Kullanici Piece Type kisminda tum secenekleri kulanilabilmeli");
        Driver.getDriver().get(ConfigReader.getProperty("hubcomfyUrl"));
        extentTest.info("1-Kullanici https://hubcomfy.com/ adresine gider");

        us_3_4_11_page.SignInButton.click();
        extentTest.info("2-Kullanici sign in butonuna tiklar");

        us_3_4_11_page.signInEmailBox.sendKeys("mevlutorcan");
        extentTest.info("3-Kullanici gecerli Username girer");

        us_3_4_11_page.passwordBox.sendKeys("Zaq12wsx");
        extentTest.info("4-Kullanici gecerli Password  girer");

        us_3_4_11_page.loginButton.click();
        extentTest.info("5-Kullanici Sign In Butonuna tiklar");
        ReusableMethods.waitFor(3);


        ReusableMethods.waitFor(5);
        executor.executeScript("arguments[0].scrollIntoView(true);", us_3_4_11_page.myAccountButton);

        ReusableMethods.jsclick(us_3_4_11_page.myAccountButton);
        ReusableMethods.jsclick(us_3_4_11_page.myAccountButton);
        extentTest.info("6-Kullanici sayfanin altindaki My Account butonuna tiklar");

        ReusableMethods.jsclick(us_3_4_11_page.storeManagerButton);
        extentTest.info("7-Kullanici Store Manager butonuna tiklar");
        ReusableMethods.jsclick(us_3_4_11_page.productsButton);
        extentTest.info("8-Kullanici Products a tiklar");
        Assert.assertTrue(us_3_4_11_page.onTheProductPage.isDisplayed());
        extentTest.info("9-Kullanici Products page de oldugunu dogrular");

        ReusableMethods.jsclick(us_3_4_11_page.addNewButton);
        extentTest.info("10-Kullanici Add New butonuna tiklar");

        ReusableMethods.jsclick(us_3_4_11_page.toptanUrunGosterme);
        extentTest.info("11-Kullanici Toptan Urun Gosterme Ayarlari Butonuna tiklar");
        System.out.println();

    }

    @Test
    public void test02() throws IOException {
        Select select = new Select(us_3_4_11_page.pieceTypeDD);
        Assert.assertTrue(select.getOptions().get(0).isEnabled());
        Assert.assertTrue(select.getOptions().get(1).isEnabled());
        Assert.assertTrue(select.getOptions().get(2).isEnabled());
        Assert.assertTrue(select.getOptions().get(3).isEnabled());
        extentTest.info("12-Kullanici Piece Type kisminda tum seceneklerin kulanilabilir oldugunu dogrular");
        extentTest.pass("Kullanici Piece Type kisminda tum secenekleri kulanilabilmeli");
    }
    @Test
    public void testClose() {
        Driver.closeDriver();
    }
}
