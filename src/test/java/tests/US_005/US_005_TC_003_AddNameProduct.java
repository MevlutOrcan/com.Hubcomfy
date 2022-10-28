package tests.US_005;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import static tests.US_005.US_005_TC_001_ProductList.ortakStepler;
import static tests.US_005.US_005_TC_001_ProductList.us_005_006_007_page;

public class US_005_TC_003_AddNameProduct extends TestBaseRapor {

    Actions actions = new Actions(Driver.getDriver());


    @Test
    public void TC_003() throws InterruptedException {

        extentTest=extentReports.createTest("US_005_TC_003","Urun ismi ekle; product title, satis miktarı");

        ortakStepler();


        ReusableMethods.waitForVisibility(us_005_006_007_page.productsAddNewButton,10);
        us_005_006_007_page.productsAddNewButton.click();
        ReusableMethods.waitFor(4);
        extentTest.info("10-Kullanici Add New butonuna tiklar");


        us_005_006_007_page.productTitle.sendKeys("urun ismi");
        extentTest.info("11-Kullanici Product Title Text box i ile urune isim ekler");


        us_005_006_007_page.priceTextBox.sendKeys("20");
        Assert.assertTrue(us_005_006_007_page.priceTextBox.isEnabled());
        us_005_006_007_page.salePriceTextBox.sendKeys("40");
        Assert.assertTrue(us_005_006_007_page.salePriceTextBox.isEnabled());
        extentTest.pass("12-Kullanici Price ve Sale Price text box i ile satis miktari belirler");
        Driver.closeDriver();




    }
}
