package tests.US_003;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_003_TC_003Checkout extends US_003_TC_002_5addetUrun {


    @Test
    public void test01checkOut() {
        extentTest = extentReports.createTest("US_003 Vendor olarak, order verebilmeliyim ve orderlarimi sepette görebilmeliyim", "Kullanici Checkout sayfasini gormeli");

        test01Login();


        for (int i = 0; i < us_3_4_11_page.productsInTheShopPage.size(); i++) {

            actions.moveToElement(us_3_4_11_page.productsInTheShopPage.get(i));
            ReusableMethods.waitFor(5);

            ReusableMethods.jsclick(us_3_4_11_page.productsInTheShopPage.get(i));
            ReusableMethods.waitFor(5);
            extentTest.info("10-Kullanici stokda olan bir urune tiklar");


            if (us_3_4_11_page.addToCartButtonList.size() == 1) {
                extentTest.info("11-Kullanici gelen sayfada ADD TO CART butonunun gorundugunu dogrular");
                actions.sendKeys(Keys.PAGE_DOWN);
                ReusableMethods.jsclick(us_3_4_11_page.addToCartButton);
                extentTest.info("12-Kullanici ADD TO CART butonuna tiklar");

                us_3_4_11_page.viewCartButtonInAProductPage.click();
                extentTest.info("13-Kullanici VIEW CART butonuna tiklar");
                break;
            } else {
                Driver.getDriver().navigate().back();
                extentTest.info("13-Kullanici  geri tusuyla Shop sayfasina doner");
            }
        }
        executor.executeScript("arguments[0].scrollIntoView(true);", us_3_4_11_page.proceedToCheckoutButton);
        ReusableMethods.waitFor(3);
        us_3_4_11_page.proceedToCheckoutButton.click();
        extentTest.info("14-Kullanici PROCEED TO CHECKOUT butonuna tiklar");
        ReusableMethods.waitFor(3);
        Assert.assertTrue(us_3_4_11_page.billingDetailText.isDisplayed());
        extentTest.info("15-Kullanici Checkout sayfasina gectigini dogrular");
        extentTest.pass("Kullanici Checkout sayfasini gormeli");

    }
}
