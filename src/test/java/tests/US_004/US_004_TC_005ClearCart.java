package tests.US_004;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

public class US_004_TC_005ClearCart extends US_004_TC_004StokFazlasi {
    @Test
    public void testClear() {
        extentTest = extentReports.createTest("US_003 defaming olarak, View Cart yapılmalı ve stok ürünleri fazla miktar secilebilmeli ve stok fazlasına müsade etmemeli", "Kullanici cart in temimlendigini gormeli");
        test01Login();
        String firstsubToTal = us_3_4_11_page.subtotal.getText();
        ReusableMethods.jsclick(us_3_4_11_page.plusButton);
        extentTest.info("16-Kullanici urun yanindaki arti butonuna tiklar");

        ReusableMethods.jsclick(us_3_4_11_page.clearCartButton);
        extentTest.info("17-Kullanici clear cart buttonuna tiklar");
        Assert.assertTrue(us_3_4_11_page.cartClearedtext.isDisplayed());
        extentTest.info("18-Kullanici cart in bosaltildiginis dogrular");
        extentTest.pass("Kullanici cart in temimlendigini gormeli");

    }
}
