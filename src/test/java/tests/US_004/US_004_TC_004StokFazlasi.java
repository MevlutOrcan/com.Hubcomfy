package tests.US_004;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class US_004_TC_004StokFazlasi extends US_004_TC_001_StokLimitTest {

    @Test
    public void test01StokFazlasi() throws IOException {
        extentTest = extentReports.createTest("US_003 defaming olarak, View Cart yapılmalı ve stok ürünleri fazla miktar secilebilmeli ve stok fazlasına müsade etmemeli", "Kullanici stok fazlasi urun ekleyememeli");
        Driver.getDriver().get(ConfigReader.getProperty("hubcomfyUrl"));
        extentTest.info("1-Kullanici https://hubcomfy.com/ adresine gider");

        us_3_4_11_page.SignInButton.click();
        extentTest.info("2-Kullanici sign in butonuna tiklar");

        us_3_4_11_page.signInEmailBox.sendKeys(ConfigReader.getProperty("email"));
        extentTest.info("3-Kullanici gecerli Username girer");

        us_3_4_11_page.passwordBox.sendKeys(ConfigReader.getProperty("password"));
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
        us_3_4_11_page.searchBox.sendKeys("selenium");
        ReusableMethods.waitFor(3);
        actions.sendKeys(Keys.DOWN,Keys.ENTER).perform();
        ReusableMethods.jsclick(us_3_4_11_page.addToCartButton);
        String stockAmount=us_3_4_11_page.stockAmount.getText().replaceAll("[^0-9]","");
        ReusableMethods.jsclick(us_3_4_11_page.viewCartButtonInAProductPage);
        int stockAmountNumber=Integer.parseInt(stockAmount);
        int stockOver=stockAmountNumber+3;
        for (int i = 0; i < stockOver; i++) {
            ReusableMethods.jsclick(us_3_4_11_page.plusButton);
        }
        extentTest.info("14-Kullanici  urunun yanindaki + tusuna tiklayarak stok sayisindan fazla urun adetine getirmeye calisir");

ReusableMethods.getScreenshotWebElement("nonOverStock",us_3_4_11_page.tableOnCartPage);
        extentTest.info("15-Kullanici urun talep adedinin stok sayisindan fazla olamadigini dogrular");
        extentTest.pass("Kullanici stok fazlasi urun ekleyememeli");
    }
}
