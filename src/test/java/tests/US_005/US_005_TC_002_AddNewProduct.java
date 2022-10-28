package tests.US_005;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import static tests.US_005.US_005_TC_001_ProductList.ortakStepler;
import static tests.US_005.US_005_TC_001_ProductList.us_005_006_007_page;

public class US_005_TC_002_AddNewProduct extends TestBaseRapor {
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void TC_002() throws InterruptedException {

        extentTest = extentReports.createTest("US_005_TC_002", "Yeni urun ekle (Add new); urun icin virtual veya downloadable secenegi olmali");

        ortakStepler();


        ReusableMethods.waitForVisibility(us_005_006_007_page.productsAddNewButton,10);
        us_005_006_007_page.productsAddNewButton.click();
        extentTest.info("10-Kullanici Add New butonuna tiklar");


      actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(us_005_006_007_page.virtualSecenegi.isDisplayed());
        Assert.assertTrue(us_005_006_007_page.downloadableSecenegi.isDisplayed());
        extentTest.pass("11-Kullanici yeni eklenecek urun icin; Virtual ve Downloadable seceneklerini gorup istedigini secer");
        Driver.closeDriver();

    }
}
