package tests.US_008;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_8_9_12_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;

public class US_008_ManageStock extends TestBaseRapor {
    JavascriptExecutor executer = (JavascriptExecutor) Driver.getDriver();
    US_8_9_12_Page US_8_9_12 = new US_8_9_12_Page();

    Actions actions = new Actions(Driver.getDriver());



    @Test
    public void ortakAdimlar() {


        extentTest = extentReports.createTest("US_008_TC_001", "Manage Stock, Stok yönetimi / Order yonetimi");

        //1-Kullanici https://hubcomfy.com/ sayfasina gider
        Driver.getDriver().get( ConfigReader.getProperty("hubcomfyUrl"));
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

        //9-Kullanici product butonunu tiklar
        US_8_9_12.Products.click();
        extentTest.info("Kullanici product butonunu tiklar");

        //10-Kullanici addnew butonunu tiklar
        US_8_9_12.addNewProduct.click();
        extentTest.info("Kullanici addnew butonunu tiklar");

        //11-Kullanici sayfanin en altina iner
        executer.executeScript("arguments[0].scrollIntoView(true);", US_8_9_12.inventoryButton);
        actions.sendKeys(Keys.PAGE_DOWN);
        extentTest.info("Kullanici sayfanin en altina iner");

        //12-Kullanıcı Inventory butonunun oldugunu dogrular
        Assert.assertTrue(US_8_9_12.inventoryButton.isDisplayed());
        extentTest.info("Kullanıcı Inventory butonunun oldugunu dogrular");

        //13-Kullanıcı SKU butonuna urun kodu girer
        US_8_9_12.SKUButton.sendKeys("Code10");
        extentTest.info("Kullanıcı SKU butonuna urun kodu girer");

    }

    @Test(dependsOnMethods = "ortakAdimlar")
    public void testCase1() {



        //14-Kulanici stock status den dropdown secer
        Select select = new Select(US_8_9_12.stockStatus);
        select.selectByVisibleText("In stock");
        List<WebElement> stocks = select.getOptions();
        Assert.assertEquals(stocks.get(0).getText(), "In stock");
        extentTest.info("Kulanici stock status den dropdown secer");
    }

    @Test(dependsOnMethods = "ortakAdimlar")
    public void testCase2() {

          ReusableMethods.waitFor(5);
        // 14-Kullanici manage stock butonunu tiklar
         actions.sendKeys(Keys.TAB,Keys.SPACE).perform();

         ReusableMethods.waitFor(5);

        // 15-Kullanici Stock Qty butonuna urun adedi girer

      actions.sendKeys(Keys.TAB,Keys.DELETE,"100").perform();

        //16-Kullanici Allow Backorders dropdown u secer
        actions.sendKeys(Keys.TAB).perform();

        Select select = new Select (US_8_9_12.allowBackorders);

        List<WebElement>allow = select.getOptions();
        allow.forEach(t-> System.out.println(t.getText()));


        select.selectByIndex(1);
        Assert.assertEquals(allow.get(1).getText(),"Allow, but notify customer");
        System.out.println(allow.get(1).getText());
        Driver.closeDriver();

    }


}

