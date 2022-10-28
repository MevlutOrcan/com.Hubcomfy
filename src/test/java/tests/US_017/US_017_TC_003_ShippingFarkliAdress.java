package tests.US_017;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.US_016_017_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class US_017_TC_003_ShippingFarkliAdress extends TestBaseRapor {

    @Test
    public void test01() throws InterruptedException, IOException {
        extentTest = extentReports.createTest("Pozitif test", "Kullanici Adress Billing kismina;" +
                " isim, soy isim, şirket ismi, tel, adres1 ve adres iki (optional), ülke, sehir, posta kodu girebildi");
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
        jse.executeScript("arguments[0].scrollIntoView(true);", hubcom.myAccount);
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
        hubcom.addNew.click();
        extentTest.info("9-Kullanici Add New butonuna tiklar");

        Faker faker = new Faker();
        actions.click(hubcom.Username).sendKeys(faker.name().username(), Keys.TAB)
                .sendKeys(faker.internet().emailAddress(), Keys.TAB)
                .sendKeys(faker.name().firstName(), Keys.TAB, faker.name().lastName(), Keys.TAB, faker.name().firstName(), Keys.TAB)
                .sendKeys(faker.name().lastName(), Keys.TAB,faker.company().name(), Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone(), Keys.TAB)
                .sendKeys(faker.address().fullAddress(), Keys.TAB)
                .sendKeys(faker.address().fullAddress(), Keys.TAB, Keys.ENTER, "France", Keys.ENTER, Keys.TAB)
                .sendKeys(faker.address().city(), Keys.TAB, faker.address().state(), Keys.TAB)
                .sendKeys(faker.address().zipCode()).perform();
        ReusableMethods.waitFor(1);
        ReusableMethods.getScreenshot("BillingBilgileri");
        extentTest.info("10-Kullanici yeni eklenecek kisinin kullanıcı adini, emailini, ismini, soyismini girer");
        extentTest.info("11-Kullanici Adress Shipping kisminda; same as billing yanindaki kutucuga tiklar");

        ReusableMethods.jsclick(hubcom.sameAsBilling);
        ReusableMethods.waitFor(1);

        actions.click(hubcom.sameAsBilling).sendKeys( Keys.TAB, faker.name().firstName(), Keys.TAB)
                .sendKeys(faker.name().lastName(), Keys.TAB,faker.company().name(), Keys.TAB)
                .sendKeys(faker.address().fullAddress(), Keys.TAB)
                .sendKeys(faker.address().fullAddress(), Keys.TAB, Keys.ENTER, "Malta", Keys.ENTER, Keys.TAB)
                .sendKeys(faker.address().city(), Keys.TAB, faker.address().state(), Keys.TAB)
                .sendKeys(faker.address().zipCode(), Keys.TAB, Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        ReusableMethods.getScreenshot("ShippingBilgileri");

        extentTest.info("12-Kullanici billing adresteki bilgilerden farkli bilgileri ekler");




    }
}
