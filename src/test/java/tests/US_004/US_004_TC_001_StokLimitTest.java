package tests.US_004;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_3_4_11_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_004_TC_001_StokLimitTest extends TestBaseRapor {
    US_3_4_11_Page us_3_4_11_page = new US_3_4_11_Page();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
    Faker faker = new Faker();

    @Test
    public void test01Login() {
        extentTest = extentReports.createTest("US_003 defaming olarak, View Cart yapılmalı ve stok ürünleri fazla miktar secilebilmeli ve stok fazlasına müsade etmemeli", "Login TestGecerli Kullanici adi ve Passord Ile Giris Yapildi");
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

        us_3_4_11_page.ordersButton.click();
        extentTest.info("7-Kullanici sayfanin solundaki Orders Butonuna tiklar");
        ReusableMethods.waitForVisibility(us_3_4_11_page.goShopButton, 5);


        ReusableMethods.jsclick(us_3_4_11_page.goShopButton);
        extentTest.info("8-Kullanici BROWSE PRODUCTS veya GO SHOP butonuna tiklar");

        Assert.assertNotEquals(us_3_4_11_page.productsInTheShopPage.size(), 0);
        extentTest.info("9-Kullanici ekrana urunlerin geldigini dogrular");

        extentTest.pass("Shop sayfasinda urunler gorunmeli");

        String productName="";
        for (int i = 0; i < us_3_4_11_page.productsInTheShopPage.size(); i++) {

            actions.moveToElement(us_3_4_11_page.productsInTheShopPage.get(i));
            ReusableMethods.waitFor(5);
            productName=us_3_4_11_page.productsInTheShopPage.get(i).getText();

            ReusableMethods.jsclick(us_3_4_11_page.productsInTheShopPage.get(i));
            ReusableMethods.waitFor(5);
            extentTest.info("10-Kullanici stokda olan bir urune tiklar");


            if (us_3_4_11_page.addToCartButtonList.size()==1) {
                extentTest.info("11-Kullanici gelen sayfada ADD TO CART butonunun gorundugunu dogrular");
                actions.sendKeys(Keys.PAGE_DOWN);
                ReusableMethods.jsclick(us_3_4_11_page.addToCartButton);
                extentTest.info("12-Kullanici ADD TO CART butonuna tiklar");

                us_3_4_11_page.viewCartButtonInAProductPage.click();
                extentTest.info("13-Kullanici VIEW CART butonuna tiklar");
                for (WebElement w:us_3_4_11_page.productsNamesInTheShopPage
                     ) {
                    Assert.assertTrue(w.getText().contains(productName));
                    extentTest.info("14-Kullanici  tiklanan urunun sepet icinde oldugunu dogrular");
                    extentTest.pass("15-Kullanici  tiklanan urunun sepet icinde oldugunu gormeli");

                    break;
                }
                break;
            } else {
                Driver.getDriver().navigate().back();
                extentTest.info("13-Kullanici  geri tusuyla Shop sayfasina doner");
            }
        }

    }
}
