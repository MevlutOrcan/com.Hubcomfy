package tests.US_004;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

public class US_004_TC_009Paying extends US_004_TC_008Total {
    @Test
    public void test01Paying() {
        extentTest = extentReports.createTest("US_003 defaming olarak, View Cart yapılmalı ve stok ürünleri fazla miktar secilebilmeli ve stok fazlasına müsade etmemeli", "Kullanici odeme sayfasinda oldugunu gormeli");
        test01Login();

        ReusableMethods.jsclick(us_3_4_11_page.proceedToCheckoutButton);
        extentTest.info("13-Kullanici PROCEED TO CHECKOUT butonuna tiklar");
        ReusableMethods.jsclick(us_3_4_11_page.billingFirstName);
        extentTest.info("14-Kullanici BILLING DETAILS altindaki tum bilgileri doldurur");
        Assert.assertTrue(us_3_4_11_page.billingDetailText.isDisplayed());
        extentTest.info("15-Kullanici odeme sayfasinda oldugunu dogrular");
        extentTest.pass("Kullanici odeme sayfasinda oldugunu gormeli");
    }
}
