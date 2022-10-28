package tests.US_011;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

import java.io.IOException;

public class US_011_TC_002_UnitPerPiece extends US_011_TC_001_ToptanUrun {

    @Test
    public void test02UnitPerPiece() throws IOException {
        extentTest = extentReports.createTest("Toptan urun gösterme ayarlari", "Kullanici Units per piece kisminin dolu oldugunu gormeli");

        test01PieceType();
        us_3_4_11_page.unitPerPieceBox.sendKeys(Keys.DELETE, "22");
        extentTest.info("12-Kullanici Units per piece kismini doldurur");
        ReusableMethods.getScreenshotWebElement("toptanUrunGostermeAyarlariTable_UnitsPerPiece", us_3_4_11_page.toptanUrunGostermeAyarlariTable);
        extentTest.info("13- Kullanici Units per piece kisminin doldurulabilir oldugunu dogrular");

        extentTest.pass("Kullanici Units per piece kisminin dolu oldugunu gormeli");


    }
}
