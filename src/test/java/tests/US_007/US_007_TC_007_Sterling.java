package tests.US_007;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import static tests.US_005.US_005_TC_001_ProductList.ortakStepler;
import static tests.US_005.US_005_TC_001_ProductList.us_005_006_007_page;

public class US_007_TC_007_Sterling extends TestBaseRapor {

    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void TC_007() throws InterruptedException {

        extentTest = extentReports.createTest("US_007_TC_007", "Sterling");

        ortakStepler();


        ReusableMethods.waitForVisibility(us_005_006_007_page.productsAddNewButton, 10);
        ReusableMethods.jsclick(us_005_006_007_page.productsAddNewButton);
        ReusableMethods.waitFor(2);
        extentTest.info("10-Kullanici Add New butonuna tiklar");


        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
        us_005_006_007_page.brandsSterling.click();
        Assert.assertTrue(us_005_006_007_page.brandsSterling.isEnabled());
        extentTest.pass("11-Kullanici Product brands basligi altinda Sterling drop down listeyi acip secer");
        Driver.closeDriver();
    }

}
