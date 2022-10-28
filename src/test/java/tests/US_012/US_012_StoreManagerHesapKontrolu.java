package tests.US_012;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_8_9_12_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;


public class US_012_StoreManagerHesapKontrolu extends TestBaseRapor {

    US_8_9_12_Page US_8_9_12 = new US_8_9_12_Page();

    JavascriptExecutor executer = (JavascriptExecutor) Driver.getDriver();

    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void ortakAdimlar() {


        extentTest = extentReports.createTest("US_012",
                "Store manager olarak hesabıma gidince tum portal a access elde etmeliyim");


        //1-Kullanici https://hubcomfy.com/ sayfasina gider
        Driver.getDriver().get(ConfigReader.getProperty("hubcomfyUrl"));
        extentTest.info("1-Kullanici https://hubcomfy.com/ sayfasina gider");

        //2-Kullanici signin butonunu tiklar

        US_8_9_12.signInButton.click();
        extentTest.info("2-Kullanici signin butonunu tiklar");


        //3-Kullanici email box a gecerli email girer

        US_8_9_12.emailBox.sendKeys("hubcalisma06.35@gmail.com");
        extentTest.info("3-Kullanici email box a gecerli email girer");

        //4-Kullanici  password box a gecerli password girer

        US_8_9_12.passwordBox.sendKeys("06Esra35Sevket");
        extentTest.info("4-Kullanici  password box a gecerli password girer");

        //5-Kullanici SIGNIN butonunu tiklar
        US_8_9_12.loginButton.click();
        extentTest.info("5-Kullanici SIGNIN butonunu tiklar");

        ReusableMethods.waitFor(5);

        //6-Kullanici sayfanin en altina iner
        executer.executeScript("arguments[0].scrollIntoView(true);", US_8_9_12.myaccountButton);
        extentTest.info("6-Kullanici sayfanin en altina iner");

        //7-Kullanici myaccount butonunu tiklar
        ReusableMethods.jsclick(US_8_9_12.myaccountButton);
        extentTest.info("7-Kullanici myaccount butonunu tiklar");
    }

    @Test(dependsOnMethods = "ortakAdimlar")
    public void testCase1() {

        //8-Kullanici orders  butonunu tiklar

        US_8_9_12.orders.click();
        extentTest.info("8-Kullanici orders  butonunu tiklar");

        //9-Kullanici orders textinin gorunurlugunu dogrular
        Assert.assertTrue(US_8_9_12.ordersText.isDisplayed());
        extentTest.info("9-Kullanici orders textinin gorunurlugunu dogrular");

        //10-Kullanici listenin gorunurlugunu dogrular
        Assert.assertTrue(US_8_9_12.ordersTable.isDisplayed());
        System.out.println(US_8_9_12.ordersTable.getText());
        extentTest.info("10-Kullanici listenin gorunurlugunu dogrular");


    }

    @Test(dependsOnMethods = "ortakAdimlar")
    public void testCase2() throws IOException {
        //8-Kullanici downloads butonunu tiklar
        US_8_9_12.downloads.click();
        extentTest.info("8-Kullanici downloads butonunu tiklar");

        //9-Kullanici downloads textinin gorunurlugunu dogrular
        Assert.assertTrue(US_8_9_12.downloadsText.isDisplayed());
        extentTest.info("9-Kullanici downloads textinin gorunurlugunu dogrular");

        //10-Kullanici downloads listesini gorur
        String expectedResult = "downloadsList";
        Assert.assertNotEquals(US_8_9_12.bulunamayan, "downloadsList");
        extentTest.info("10-Kullanici \"No downloads available yet\" textinin gorunurlugunu dogrular");
        ReusableMethods.getScreenshot("indirimliUrunlerListesi");

    }

    @Test(dependsOnMethods = "ortakAdimlar")
    public void testCase3() {
        //8-Kullanici addresses butonunu tiklar

        US_8_9_12.addresses.click();
        extentTest.info("8-Kullanici addresses butonunu tiklar");

        //9- Kullanici adresses textinin gorunurlugunu dogrular

        Assert.assertTrue(US_8_9_12.addressesText.isDisplayed());
        extentTest.info("9- Kullanici adresses textinin gorunurlugunu dogrular");

        //10-Kullanici Billing Address in gorunurlugunu dogrular
        Assert.assertTrue(US_8_9_12.billingAddress.isDisplayed());

        //11-Kullanici Shipping Address in gorunurlugunu dogrular
        Assert.assertTrue(US_8_9_12.shippingAdress.isDisplayed());

    }

    @Test(dependsOnMethods = "ortakAdimlar")
    public void testCase4() throws IOException {
        //8-Kullanici account details butonunu tiklar

        ReusableMethods.jsclick(US_8_9_12.accountDetails);
        extentTest.info("8-Kullanici account details butonunu tiklar");

        //9-Kullanici account details text inin gorunurlugunu dogrular

        Assert.assertTrue(US_8_9_12.accountDetailsText.isDisplayed());
        extentTest.info("9-Kullanici account details text inin gorunurlugunu dogrular");

        //10- Kullanici first name in gorunurlugunu dogrular

        Assert.assertTrue(US_8_9_12.accountFirstName.isDisplayed());
        extentTest.info("10- Kullanici first name in gorunurlugunu dogrular");

        //11-Kullanici last name in gorunurlugunu dogrular
        Assert.assertTrue(US_8_9_12.accountLastName.isDisplayed());
        extentTest.info("11-Kullanici last name in gorunurlugunu dogrular");

        //12-Kullanici  display name in gorunurlugunu dogrular
        Assert.assertTrue(US_8_9_12.accountDisplayName.isDisplayed());
        extentTest.info("12-Kullanici  display name in gorunurlugunu dogrular");

        //13-Kullanici email addressin  gorunurlugunu dogrular
        Assert.assertTrue(US_8_9_12.accountEmail.isDisplayed());
        extentTest.info("13-Kullanici email addressin  gorunurlugunu dogrular");

        //14-Kullanici email adress box a gecerli farkli bir email girer

        US_8_9_12.accountDisplayName.click();
        actions.sendKeys(Keys.TAB, Keys.DELETE, "hubcalisma@gmail.com").perform();

        //15-Kullanici "Account details changed successfully" Textinin gorunurlugunu dogrular.
        US_8_9_12.passwordChange.sendKeys("06Esra35Sevket");
        actions.sendKeys(Keys.TAB, "080921Es*."
                , Keys.TAB, "080921Es*.", Keys.TAB, Keys.ENTER).perform();

        ReusableMethods.getScreenshot("kaybolanMesaj");


        /////***************

        Driver.getDriver().navigate().refresh();
        ReusableMethods.getScreenshot("Succesfly");
        US_8_9_12.accountDisplayName.click();
        actions.sendKeys(Keys.TAB, Keys.DELETE, "hubcalisma06.35@gmail.com").perform();

        US_8_9_12.passwordChange.sendKeys("080921Es*.");
        actions.sendKeys(Keys.TAB, "06Esra35Sevket", Keys.TAB, "06Esra35Sevket", Keys.TAB, Keys.ENTER).perform();

        Driver.closeDriver();

    }

}