package tests.US_004;

import org.testng.Assert;
import org.testng.annotations.Test;

public class US_004_TC_006Coupon extends US_004_TC_005ClearCart {
    @Test
    public void test01Coupon() {
        extentTest = extentReports.createTest("US_003 defaming olarak, View Cart yapılmalı ve stok ürünleri fazla miktar secilebilmeli ve stok fazlasına müsade etmemeli", "Kullanici VIEW CART sayfasinda COUPON secenegi oldugunu gormeli");
        test01Login();

        Assert.assertTrue(us_3_4_11_page.couponDiscountText.isDisplayed());
        extentTest.info("13-Kullanici VIEW CART sayfasinda COUPON secenegi oldugunu dogrular");
        extentTest.pass("Kullanici VIEW CART sayfasinda COUPON secenegi oldugunu gormeli");

    }
}
