package tests.US_005;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import static tests.US_005.US_005_TC_001_ProductList.ortakStepler;
import static tests.US_005.US_005_TC_001_ProductList.us_005_006_007_page;

public class US_005_TC_004_UrunFotosuEkle extends TestBaseRapor {

    Actions actions = new Actions(Driver.getDriver());


    @Test
    public void TC_004() throws InterruptedException{
        extentTest=extentReports.createTest("US_005_TC_004","Urun fotosu eklenebilmeli");

        ortakStepler();


        ReusableMethods.waitForVisibility(us_005_006_007_page.productsAddNewButton,10);
        ReusableMethods.jsclick(us_005_006_007_page.productsAddNewButton);
        ReusableMethods.waitFor(2);
        extentTest.info("10-Kullanici Add New butonuna tiklar");


        ReusableMethods.jsclick(us_005_006_007_page.imageLogosu);
        ReusableMethods.waitFor(2);
        extentTest.info("11-Kullanici image logosu uzerine tiklar");


        ReusableMethods.jsclick(us_005_006_007_page.mediaLibraryButton);
       Thread.sleep(3000);
        Assert.assertTrue(us_005_006_007_page.eklenenFoto.isDisplayed());
        extentTest.info("12-Kullanici Media Library basligi altinda eklenen fotoyu gorebilmeli");


        us_005_006_007_page.eklenenFoto.click();
        ReusableMethods.waitFor(3);
        extentTest.info("13-Kullanici fotoya tiklar");



        Assert.assertTrue(us_005_006_007_page.fotoUzerindekiTikIsareti.isDisplayed());
        extentTest.info("14-Kullanici fotonun secili oldugunu ustundeki tik'ten dogrulayabillir");


        us_005_006_007_page.chooseImageSelectButton.click();
        ReusableMethods.waitFor(3);
        extentTest.info("15-Kullanici SELECT butonuna basar");


        Assert.assertTrue(us_005_006_007_page.urunFotosuEklemeyiDogrulama.isDisplayed());
        Driver.getDriver().findElement(By.xpath("(//*[@class='media-modal-icon'])[1]")).click();
        extentTest.pass("Kullanici urun fotosu ekler");
        Driver.closeDriver();









    }
}
