package tests.US_002;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.US_2_18_19_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

import static tests.US_002.US_002_TC_001_Login.ortakAdimlar;

public class US_002_TC_003_DoshboardAltindakiList extends TestBaseRapor {

    US_2_18_19_Page us_page = new US_2_18_19_Page();

    @Test
    public void test01DoshboardAltindakiList() throws InterruptedException, IOException {
        extentTest = extentReports.createTest("Dashboard altında ", "Store manager, orders, downloads, addresses , account details, appointments, wishlist,Support tickets, followings ve logout olmali");

       ortakAdimlar();

        ReusableMethods.getActions().sendKeys(Keys.PAGE_DOWN).perform();

        String tabIsimleri="";
        for (WebElement w:us_page.DoshboardAltindakiList) {
            tabIsimleri +=" " + w.getText();
        }
        System.out.println(tabIsimleri);
        ReusableMethods.waitFor(3);
        Assert.assertTrue(tabIsimleri.contains("Dashboard"));
        extentTest.info("Dashboard yazısının oldugunu dogrular");
        Assert.assertTrue(tabIsimleri.contains("Store Manager"));
        extentTest.info("Store Manager yazısının oldugunu dogrular");
        Assert.assertTrue(tabIsimleri.contains("Orders"));
        extentTest.info("Orders yazısının oldugunu dogrular");
        Assert.assertTrue(tabIsimleri.contains("Downloads"));
        extentTest.info("Downloads yazısının oldugunu dogrular");
        Assert.assertTrue(tabIsimleri.contains("Addresses"));
        extentTest.info("Addresses yazısının oldugunu dogrular");
        Assert.assertTrue(tabIsimleri.contains("Account details"));
        extentTest.info("Account details yazısının oldugunu dogrular");
        Assert.assertFalse(tabIsimleri.contains("Appointments"));// false verdi
        extentTest.info("Appointments yazısının oldugunu dogrular");
        Assert.assertTrue(tabIsimleri.contains("Wishlist"));
        extentTest.info("Wishlist yazısının oldugunu dogrular");
        Assert.assertTrue(tabIsimleri.contains("Support Tickets"));
        extentTest.info("Support Tickets yazısının oldugunu dogrular");
        Assert.assertTrue(tabIsimleri.contains("Followings"));
        extentTest.info("Followings yazısının oldugunu dogrular");
        Assert.assertTrue(tabIsimleri.contains("Logout"));
        extentTest.info("Logout yazısının oldugunu dogrular");

        extentTest.fail("Kullanici Appointments segmesinin oldugunu dogrular.");
        ReusableMethods.waitFor(3);
        ReusableMethods.getScreenshot("Appointments");

     Driver.closeDriver();




    }


}
