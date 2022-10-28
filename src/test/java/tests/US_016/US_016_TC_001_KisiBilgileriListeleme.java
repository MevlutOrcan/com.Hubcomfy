package tests.US_016;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_016_017_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class US_016_TC_001_KisiBilgileriListeleme extends TestBaseRapor {

    @Test
    public void test01() throws InterruptedException, IOException {

        extentTest=extentReports.createTest("Pozitif test", "Kullanici kayitli kisileri listeleyebildi");
        //1-Kullanici https://hubcomfy.com/ gider
        Driver.getDriver().get(ConfigReader.getProperty("hubcomUrl"));
        extentTest.info("1-Kullanici https://hubcomfy.com/ gider ");
        //2-Kullanici sign in butonuna tiklar
        US_016_017_Page hubcom = new US_016_017_Page();
        hubcom.login.click();
        extentTest.info("2-Kullanici sign in butonuna tiklar");
        //3-Kullanici gecerli user name veya email adres girer
        //4-Kullanici gecerli password girer
        //5-Kullanici sign in butonuna tiklar
        hubcom.userEmail.sendKeys(ConfigReader.getProperty("userEmail"));
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("pass")).
                sendKeys(Keys.ENTER).perform();
        Thread.sleep(3000);
        extentTest.info("3-Kullanici gecerli user name veya email adres girer");
        extentTest.info("4-Kullanici gecerli password girer");
        extentTest.info("5-Kullanici sign in butonuna tiklar");
        //6-Kullanici My Account linkine tiklar
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);",hubcom.myAccount);
        ReusableMethods.jsclick(hubcom.myAccount);
        extentTest.info("6-Kullanici My Account linkine tiklar");
        //7-Kullanici Store Manager butonuna tiklar
        hubcom.storeManager.click();
        extentTest.info("7-Kullanici Store Manager butonuna tiklar");
        //8-Kullanici Customers butonuna tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        hubcom.customers.click();
        extentTest.info("8-Kullanici Customers butonuna tiklar");
        ReusableMethods.waitFor(1);
        //9-Kullanici Customersta kayitli kisilerin isim/ kullanıcı adi/ emaili, adresi, harcama miktarı, son siparişleri görmeli
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(hubcom.kisiListesi.isEnabled());
        ReusableMethods.waitFor(1);
        System.out.println("hubcom.kisiListesi.getText() = " + hubcom.kisiListesi.getText());
        extentTest.info("9-Kullanici Customersta kayitli kisilerin " +
                "isim/ kullanıcı adi/ emaili, adresi, harcama miktarı, son siparişlerini gordugunu dogrular");
        ReusableMethods.getScreenshot("KisiListesi");

    }
}
