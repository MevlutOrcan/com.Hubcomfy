package tests.US_004;

import org.testng.annotations.Test;
import utilities.ReusableMethods;

public class US_004_TC_008Total extends US_004_TC_007ContinueShopping {
    @Test
    public void test01Total() {
        extentTest = extentReports.createTest("US_003 defaming olarak, View Cart yapılmalı ve stok ürünleri fazla miktar secilebilmeli ve stok fazlasına müsade etmemeli", "Kullanici Total Rakamin guncel oldugunu gormeli");
        test01Login();

        extentTest.info("13-Kullanici ekranin sag tarafinda Shipping bilgileri oldugunu dogrular");
        ReusableMethods.jsclick(us_3_4_11_page.updateTotalsButton);
        extentTest.info("14-Kullanici UPDATE TOTALS butonuna tiklar");

        extentTest.pass("Kullanici Total Rakamin guncel oldugunu gormeli");

    }
}
