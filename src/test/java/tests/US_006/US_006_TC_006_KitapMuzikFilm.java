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

public class US_006_TC_006_KitapMuzikFilm extends TestBaseRapor {

    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void TC_006() throws InterruptedException {

        extentTest = extentReports.createTest("US_006_TC_006", "Kitap & Mzik & Film");

        ortakStepler();


        ReusableMethods.waitForVisibility(us_005_006_007_page.productsAddNewButton, 10);
        ReusableMethods.jsclick(us_005_006_007_page.productsAddNewButton);
        ReusableMethods.waitFor(2);
        extentTest.info("10-Kullanici Add New butonuna tiklar");


        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
        us_005_006_007_page.categoriesBooksMusicFilmDropDown.click();
        Assert.assertTrue(us_005_006_007_page.categoriesBooksMusicFilmDropDown.isEnabled());
        extentTest.info("Kullanici Categories kisminda Kitap & müzik &Film (Books & Music & Film) drop down secenegine basip alt listeyi gorur");
        Driver.closeDriver();
    }
}
