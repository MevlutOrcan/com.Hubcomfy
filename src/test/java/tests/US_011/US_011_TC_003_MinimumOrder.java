package tests.US_011;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

import java.io.IOException;

public class US_011_TC_003_MinimumOrder extends US_011_TC_001_ToptanUrun {
    @Test
    public void test001MinimumOrder() throws IOException {
        extentTest = extentReports.createTest("Toptan urun gösterme ayarlari", "Kullanici Minimum Order kisminin dolu oldugunu gormeli");

        test01PieceType();

        us_3_4_11_page.minOrderQuantityBox.sendKeys(Keys.CLEAR,"46");
        extentTest.info("12-Kullanici Minimum Order Quantity? Kismini doldurur");

        ReusableMethods.getScreenshotWebElement("toptanUrunGostermeAyarlariTable_MinimumOrder",us_3_4_11_page.toptanUrunGostermeAyarlariTable);
        extentTest.info("13-Kullanici Minimum Order kisminin dolu oldugunu dogrular");

        extentTest.pass("Kullanici Minimum Order kisminin dolu oldugunu gormeli");
    }
}
