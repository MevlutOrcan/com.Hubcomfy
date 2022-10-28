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

import static tests.US_002.US_002_TC_001_Login.ortakAdimlar;

public class US_002_TC_002_MyAccountAltindakiOrdersList extends TestBaseRapor  {

    US_2_18_19_Page us_page = new US_2_18_19_Page();

    @Test
    public void test02Login() throws InterruptedException {
        extentTest = extentReports.createTest("US_003 Vendor olarak, ", "Orders, Downloads, addresses, account details,whislist ve Logout gorulmeli");

      ortakAdimlar();
        ReusableMethods.getActions().sendKeys(Keys.PAGE_DOWN).perform();

        String buttonIsimleri="";
        for (WebElement w:us_page.MyAccountAltindakiOrdersList) {
            buttonIsimleri+=" " + w.getText();
        }
        System.out.println(buttonIsimleri);
        ReusableMethods.waitFor(3);
        Assert.assertTrue(buttonIsimleri.contains("ORDERS"));
        extentTest.info("ORDERS yazısının görünürlügünü dogrular");
        Assert.assertTrue(buttonIsimleri.contains("DOWNLOADS"));
        extentTest.info("DOWNLOADS yazısının görünürlügünü dogrular");
        Assert.assertTrue(buttonIsimleri.contains("ADDRESSES"));
        extentTest.info("ADDRESSES yazısının görünürlügünü dogrular");
        Assert.assertTrue(buttonIsimleri.contains("ACCOUNT DETAILS"));
        extentTest.info("ACCOUNT DETAILS yazısının görünürlügünü dogrular");
        Assert.assertTrue(buttonIsimleri.contains("WISHLIST"));
        extentTest.info("WISHLIST yazısının görünürlügünü dogrular");
        Assert.assertTrue(buttonIsimleri.contains("LOGOUT"));
        extentTest.pass("LOGOUT yazısının görünürlügünü dogrular");
        Driver.closeDriver();




    }
}
