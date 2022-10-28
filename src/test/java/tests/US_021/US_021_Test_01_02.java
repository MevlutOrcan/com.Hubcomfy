package tests.US_021;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_20_21_22_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_021_Test_01_02 extends TestBaseRapor {

    static US_20_21_22_Page hubConfyPage = new US_20_21_22_Page();
    static Actions actions = new Actions(Driver.getDriver());
    static JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();


    @Test
    public static void testUS_021_OrtakKisim()  {
        extentTest = extentReports.createTest("US_021", "Store manager olarak satis raporlarının incelenmesi");


        //1- Kullanici "https://hubcomfy.com/" adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("hubcomfyUrl"));
        extentTest.info("1- Kullanici https://hubcomfy.com/ adresine gider");

        //2- Kullanici signin butonuna tiklar
        hubConfyPage.signInButtonum.click();
        extentTest.info("2- Kullanici signin butonuna tiklar");

        //3- Kullanici username veya email girer
        hubConfyPage.userNameEmail.sendKeys("kucukayarhasan@gmail.com");
        extentTest.info("3- Kullanici username veya email girer");


        //4- Kullanici password girer
        hubConfyPage.passwordHub.sendKeys("12345qwert");
        extentTest.info("4- Kullanici password girer");

        //5- Kullanici sign in tiklar
        hubConfyPage.signIn.click();
        extentTest.info("5- Kullanici sign in tiklar");

        //6- Kullanici sayfanin en altina iner ve My Account'a tiklar
        ReusableMethods.waitFor(3);
        jse.executeScript("arguments[0].scrollIntoView(true);", hubConfyPage.myAccount);
        ReusableMethods.jsclick(hubConfyPage.myAccount);
        extentTest.info("6- Kullanici sayfanin en altina iner ve My Account'a tiklar");

        //7- Kullanici Store Manager 'a tiklar
        hubConfyPage.storeManager.click();
        extentTest.info("7- Kullanici Store Manager 'a tiklar'");

        //8- Kullanici Reports'e tiklar
        ReusableMethods.waitFor(2);
        jse.executeScript("arguments[0].scrollIntoView(true)",hubConfyPage.reports);
        ReusableMethods.jsclick(hubConfyPage.reports);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        extentTest.info("8- Kullanici Reports'e tiklar");

    }

    @Test (dependsOnMethods = "testUS_021_OrtakKisim")
    public void testUS_021_TC_001() throws InterruptedException {

        extentTest = extentReports.createTest("US_021 TC_001", "Yillik rakamlar, en son ay, icinde bulunulan ay, en son 7 gune ait rakamlar gorulmeli");


        //9- Kullanici "Year" butonuna tiklar
        hubConfyPage.yearReport.click();
        Thread.sleep(3);
        extentTest.info("9- Kullanici \"Year\" butonuna tiklar");

        //10- Kullanici yillik rakamlarin gorunur oldugunu dogrular
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(hubConfyPage.numbersOfYear.isDisplayed());
        extentTest.info("10- Kullanici yillik rakamlarin gorunur oldugunu dogrular");

        //11- Kullanici "Last Month" butonuna tiklar
        hubConfyPage.lastMonth.click();
        Thread.sleep(3);
        extentTest.info("Kullanici \"Last Month\" butonuna tiklar");

        //12- Kullanici en son aydaki rakamlarin gorunur oldugunu dogrular
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(hubConfyPage.numbersOfLastMonth.isDisplayed());
        extentTest.info("12- Kullanici en son aydaki rakamlarin gorunur oldugunu dogrular");

        //13- Kullanici "This Month" butonuna tiklar
        hubConfyPage.thisMonth.click();
        extentTest.info("13- Kullanici \"This Month\" butonuna tiklar");

        //14- Kullanici icinde bulunulan aydaki rakamlarin gorunur oldugunu dogrular
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(hubConfyPage.numbersOfThisMonth.isDisplayed());
        extentTest.info("14- Kullanici icinde bulunulan aydaki rakamlarin gorunur oldugunu dogrular");

        //15- Kullanici "Last 7 Days" butonuna tiklar
        hubConfyPage.last7Days.click();
        extentTest.info("15- Kullanici \"Last 7 Days\" butonuna tiklar");

        //16- Kullanici son 7 gundeki rakamlarin gorunur oldugunu dogrular
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(hubConfyPage.numbersOfLast7Days.isDisplayed());
        extentTest.pass("Yillik rakamlar, en son ay, icinde bulunulan ay, en son 7 gune ait rakamlar goruldu");


    }

    @Test (dependsOnMethods = "testUS_021_TC_001")
    public void testUS_021_TC_002() throws InterruptedException {

        extentTest = extentReports.createTest("US_021 TC_002", " Specific bir tarih araligi secilebilmeli ve bu tarih araligina ait rakamlar incelenebilmeli");

        //9- Kullanici"Choose Date Range" kutusuna tiklar
        hubConfyPage.chooseDateRange.click();
        extentTest.info("9- Kullanici\"Choose Date Range\" kutusuna tiklar");

        //10- Kullanici "Choose Date Range" kutusuna specific bir tarih girer
        //11- Kullanici "Choose Date Range" kutusuna specific bir tarih daha girer

        hubConfyPage.chooseDateRange.sendKeys("2022-05-10 to 2022-12-12",Keys.PAGE_DOWN);
        extentTest.info("10- Kullanici \"Choose Date Range\" kutusuna specific bir tarih girer");

        //12- Kullanici belirledigi bu tarih araligina ait bilgilerin, tabloda gorunur oldugunu dogrular
        Assert.assertTrue(hubConfyPage.customDateAllTable.isDisplayed());
        extentTest.pass("Specific bir tarih araligi secilebildi ve bu tarih araligina ait rakamlar incelenebildi");
        Thread.sleep(3);
        Driver.closeDriver();

    }
}


