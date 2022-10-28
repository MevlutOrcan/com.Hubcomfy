package tests.US_004;

import org.testng.Assert;
import org.testng.annotations.Test;

public class US_004_TC_007ContinueShopping extends US_004_TC_006Coupon {
    @Test
    public void test01ContinueShopping() {
        extentTest = extentReports.createTest("US_003 defaming olarak, View Cart yapılmalı ve stok ürünleri fazla miktar secilebilmeli ve stok fazlasına müsade etmemeli", "Kullanici CONTINUE SHOPPING butonu oldugunu gormeli");
        test01Login();

        Assert.assertTrue(us_3_4_11_page.continueShoppingButton.isDisplayed());
        extentTest.info("14-Kullanici CONTINUE SHOPPING butonu oldugunu dogrular");
        extentTest.pass("Kullanici CONTINUE SHOPPING butonu oldugunu gormeli");

    }
}
