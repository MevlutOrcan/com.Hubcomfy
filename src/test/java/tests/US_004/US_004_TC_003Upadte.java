package tests.US_004;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

import java.io.IOException;

public class US_004_TC_003Upadte extends US_004_TC_001_StokLimitTest {
    @Test
    public void test01Update() throws IOException {
        extentTest = extentReports.createTest("US_003 defaming olarak, View Cart yapılmalı ve stok ürünleri fazla miktar secilebilmeli ve stok fazlasına müsade etmemeli", "Kullanici fiyat Toplaminin guncellendgini gormeli");
        test01Login();
        String firstsubToTal = us_3_4_11_page.subtotal.getText();
        ReusableMethods.jsclick(us_3_4_11_page.plusButton);
        extentTest.info("16-Kullanici urun yanindaki arti butonuna tiklar");

        ReusableMethods.getScreenshotWebElement("Increased Amount", us_3_4_11_page.tableOnCartPage);
        extentTest.info("17-Kullanici urun adedinin arttigini dogrular");


        ReusableMethods.jsclick(us_3_4_11_page.updateCartButton);
        extentTest.info("16-Kullanici UPDATE CART butonuna basar");
        ReusableMethods.waitForVisibility(us_3_4_11_page.cartUpdatedText, 9);
        Assert.assertNotEquals(us_3_4_11_page.subtotal.getText(), firstsubToTal);
        extentTest.info("17-Kullanici fiyat  toplamlarinin guncellendigini dogrular");
        extentTest.pass("Kullanici fiyat Toplaminin guncellendgini gormeli");
    }
}
