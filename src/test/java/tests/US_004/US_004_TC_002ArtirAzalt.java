package tests.US_004;

import org.testng.annotations.Test;
import utilities.ReusableMethods;

import java.io.IOException;

public class US_004_TC_002ArtirAzalt extends US_004_TC_001_StokLimitTest {
    @Test
    public void testArtirAzalt() throws IOException {
        extentTest = extentReports.createTest("US_003 defaming olarak, View Cart yapılmalı ve stok ürünleri fazla miktar secilebilmeli ve stok fazlasına müsade etmemeli", "Kullanici urun adedinin arttigini ve azaldigini gormeli");

        test01Login();

       ReusableMethods.getScreenshotWebElement("Fisrt Quantity",us_3_4_11_page.tableOnCartPage);

        ReusableMethods.jsclick(us_3_4_11_page.plusButton);
        ReusableMethods.jsclick(us_3_4_11_page.plusButton);
        ReusableMethods.jsclick(us_3_4_11_page.plusButton);
        ReusableMethods.jsclick(us_3_4_11_page.plusButton);
        extentTest.info("16-Kullanici urun yanindaki arti butonuna tiklar");

        ReusableMethods.getScreenshotWebElement("Increased Amount",us_3_4_11_page.tableOnCartPage);

        extentTest.info("17-Kullanici urun adedinin arttigini dogrular");
        us_3_4_11_page.updateCartButton.click();
        ReusableMethods.jsclick(us_3_4_11_page.minusButton);
        ReusableMethods.jsclick(us_3_4_11_page.minusButton);
        extentTest.info("18-Kullanici urun yanindaki eksi butonuna tiklar");


        ReusableMethods.getScreenshotWebElement("Decreased Amount",us_3_4_11_page.tableOnCartPage);
        extentTest.info("19-Kullanici urun adedinin azaldigini dogrular");

        extentTest.pass("Kullanici urun adedinin arttigini ve azaldigini gormeli");


    }
}
