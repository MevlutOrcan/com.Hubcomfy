package tests.US_006;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

import static tests.US_005.US_005_TC_001_ProductList.ortakStepler;
import static tests.US_005.US_005_TC_001_ProductList.us_005_006_007_page;

public class US_006_TC_005_IndirimliUrunler extends TestBaseRapor {

    Actions actions = new Actions(Driver.getDriver());


    @Test
    public void TC_005() throws InterruptedException, IOException {

        extentTest = extentReports.createTest("US_006_TC_005", "Indirimli Urunler");

        ortakStepler();


        ReusableMethods.waitForVisibility(us_005_006_007_page.productsAddNewButton, 10);
        ReusableMethods.jsclick(us_005_006_007_page.productsAddNewButton);
        ReusableMethods.waitFor(2);
        extentTest.info("10-Kullanici Add New butonuna tiklar");


        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
        String categories = "";
        for (WebElement w:us_005_006_007_page.categoriesList) {
            categories+=" " + w.getText();
        }
        System.out.println(categories);
        Assert.assertFalse(categories.contains("Discount"));
        extentTest.fail("Kullanici Categories kisminda indirimli Urunler'i goremez");
        ReusableMethods.getScreenshot("Indirimli urunler");
        Driver.closeDriver();

    }
}
