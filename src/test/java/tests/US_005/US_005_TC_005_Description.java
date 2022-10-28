package tests.US_005;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;

import static tests.US_005.US_005_TC_001_ProductList.ortakStepler;
import static tests.US_005.US_005_TC_001_ProductList.us_005_006_007_page;

public class US_005_TC_005_Description extends TestBaseRapor {

    Actions actions = new Actions(Driver.getDriver());


    @Test
    public void TC_005() throws InterruptedException {

        extentTest=extentReports.createTest("US_005_TC_005","Kisa tanımlama ve geniş tanımlama (short description, Description)");

        ortakStepler();


        ReusableMethods.waitForVisibility(us_005_006_007_page.productsAddNewButton,10);
        ReusableMethods.jsclick(us_005_006_007_page.productsAddNewButton);
        ReusableMethods.waitFor(2);
        extentTest.info("10-Kullanici Add New butonuna tiklar");


        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        List<WebElement> iframe = Driver.getDriver().findElements(By.xpath("//iframe"));


        Driver.getDriver().switchTo().frame(iframe.get(1));
        Assert.assertTrue(us_005_006_007_page.descriptionTextBox.isEnabled());
        ReusableMethods.waitFor(3);
        Driver.getDriver().switchTo().defaultContent();
        actions.sendKeys(Keys.PAGE_UP).perform();
        Driver.getDriver().switchTo().frame(iframe.get(0));
        Assert.assertTrue(us_005_006_007_page.shortDescriptionTextBox.isEnabled());
        Driver.getDriver().switchTo().defaultContent();
        extentTest.pass("Kullanici Short Description ve Description text box'larina erisir");
        Driver.closeDriver();
    }
}
