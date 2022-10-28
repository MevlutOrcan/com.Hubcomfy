package tests.US_006;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import static tests.US_005.US_005_TC_001_ProductList.ortakStepler;
import static tests.US_005.US_005_TC_001_ProductList.us_005_006_007_page;

public class US_006_TC_004_EvVeYasam extends TestBaseRapor {

    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void TC_004() throws InterruptedException {

        extentTest = extentReports.createTest("US_006_TC_004", "Ev ve Yasam");

        ortakStepler();


        ReusableMethods.waitForVisibility(us_005_006_007_page.productsAddNewButton, 10);
        ReusableMethods.jsclick(us_005_006_007_page.productsAddNewButton);
        ReusableMethods.waitFor(2);
        extentTest.info("10-Kullanici Add New butonuna tiklar");


        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
        actions.release(us_005_006_007_page.categoriesHomeAndGardenDropDown).perform();
        us_005_006_007_page.categoriesHomeAndGardenDropDown.click();
        Assert.assertTrue(us_005_006_007_page.categoriesHomeAndGardenDropDown.isEnabled());
        extentTest.info("Kullanici Categories kisminda Home & Garden () drop down secenegine basip alt listeyi gorur");
        Driver.closeDriver();
    }
}
