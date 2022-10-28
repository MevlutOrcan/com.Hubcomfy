package tests.US_009;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.css.model.RuleUsage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_8_9_12_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;
import java.util.List;

public class US_009_ShippingOpsiyonu extends TestBaseRapor{

    US_8_9_12_Page US_8_9_12 = new US_8_9_12_Page();

    JavascriptExecutor executer = (JavascriptExecutor) Driver.getDriver();

    Actions actions = new Actions(Driver.getDriver());



 @Test
    public void ortakAdimlar() {
        extentTest = extentReports.createTest("US_009_TC_001", "Shipping opsiyonu");

        //1-Kullanici https://hubcomfy.com/ sayfasina gider
        Driver.getDriver().get(ConfigReader.getProperty("hubcomfyUrl"));
        extentTest.info("Kullanici https://hubcomfy.com/ sayfasina gider");

        //2-Kullanici signin butonunu tiklar

        US_8_9_12.signInButton.click();
        extentTest.info("Kullanici signin butonunu tiklar");


        //3-Kullanici email box a gecerli email girer

        US_8_9_12.emailBox.sendKeys("hubcalisma06.35@gmail.com");
        extentTest.info("Kullanici email box a gecerli email girer");

        //4-Kullanici  password box a gecerli password girer

        US_8_9_12.passwordBox.sendKeys("06Esra35Sevket");
        extentTest.info("Kullanici  password box a gecerli password girer");

        //5-Kullanici SIGNIN butonunu tiklar
        US_8_9_12.loginButton.click();
        extentTest.info("Kullanici SIGNIN butonunu tiklar");

        ReusableMethods.waitFor(5);

        //6-Kullanici sayfanin en altina iner
        executer.executeScript("arguments[0].scrollIntoView(true);", US_8_9_12.myaccountButton);
        extentTest.info("Kullanici sayfanin en altina iner");

        //7-Kullanici myaccount butonunu tiklar
        ReusableMethods.jsclick(US_8_9_12.myaccountButton);
        extentTest.info("Kullanici myaccount butonunu tiklar");

        //8-Kullanici  storemanager  butonunu tiklar
        US_8_9_12.storeManager.click();
        extentTest.info("Kullanici  storemanager  butonunu tiklar");

     ReusableMethods.waitFor(3);
        //9-Kullanici product butonunu tiklar
        ReusableMethods.jsclick(US_8_9_12.Products);
        extentTest.info("Kullanici product butonunu tiklar");

        //10-Kullanici addnew butonunu tiklar
        US_8_9_12.addNewProduct.click();
        extentTest.info("Kullanici addnew butonunu tiklar");

        //11-Kullanici sayfanin en altina iner
        executer.executeScript("arguments[0].scrollIntoView(true);", US_8_9_12.inventoryButton);
        actions.sendKeys(Keys.PAGE_DOWN);
        extentTest.info("Kullanici sayfanin en altina iner");

        //12-Kullanici Shipping butonunu tiklar

        ReusableMethods.jsclick(US_8_9_12.shipping);
        extentTest.info("12-Kullanici shipping butonunu tiklar");

    }
        @Test (dependsOnMethods = "ortakAdimlar")
        public void testCase1() {


            //13-Kullanici Weight butonundan urun agirligi girer
        US_8_9_12.weight.sendKeys("1");
        extentTest.info("13-Kullanici Weight butonundan urun agirligi girer");
        //14-Kullanici Dimensions sekmesinden length butonuna deger girer

        US_8_9_12.lenghtBox.sendKeys("10");
        extentTest.info("14-Kullanici Dimensions sekmesinden length butonuna deger girer");

        //15-Kullanici Dimensions sekmesinden widht butonuna deger girer
        US_8_9_12.widhtBox.sendKeys("10");
        extentTest.info("15-Kullanici Dimensions sekmesinden widht butonuna deger girer");

        //16-Kullanici Diemensions sekmesinden height butonuna deger girer
        US_8_9_12.heightBox.sendKeys("2");
        extentTest.info("16-Kullanici Diemensions sekmesinden height butonuna deger girer");
    }

    @Test (dependsOnMethods = "ortakAdimlar")
    public void testCase2() throws IOException {

        //13-Kullanici Processing Time dropdown dan birini secer
        ReusableMethods.waitFor(5);
        Select select = new Select(US_8_9_12.processingTime);
        List<WebElement> times= select.getOptions();
        select.selectByIndex(1);

        Assert.assertEquals(times.get(1).getText(), "1 business day");

       //14-Kullanici hacim girebilmeli
      String expecetedResult="Volume";
      Assert.assertNotEquals(US_8_9_12.shippingClass.isDisplayed(),expecetedResult);
      ReusableMethods.getScreenshot("Volume");
        extentTest.info("14-Kullanici hacim girebilmeli");
        extentTest.fail("14-Kullanici hacim giremedi");
        Driver.closeDriver();

    }


}
