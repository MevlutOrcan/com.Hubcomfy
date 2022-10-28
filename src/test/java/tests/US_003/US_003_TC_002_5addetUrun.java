package tests.US_003;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_003_TC_002_5addetUrun extends US_003_TC_001_OrderTestShopping {


    @Test @Ignore
    public void test01_5addetUrun() {
        extentTest = extentReports.createTest("US_003 Vendor olarak, order verebilmeliyim ve orderlarimi sepette görebilmeliyim", "Kullanici CART ta 5 adet urun oldugu gormeli");
        test01Login();




        for (int i = 0; i < us_3_4_11_page.productsInTheShopPage.size(); i++) {


            ReusableMethods.waitFor(3);
            actions.moveToElement(us_3_4_11_page.productsInTheShopPage.get(0)).perform();
            ReusableMethods.waitFor(5);

            ReusableMethods.jsclick(us_3_4_11_page.productsInTheShopPage.get(0));
            ReusableMethods.waitFor(5);

            extentTest.info("10-Kullanici stokda olan bir urune tiklar");
            ReusableMethods.waitFor(3);
            if (us_3_4_11_page.addToCartButtonList.size()==1) {
                extentTest.info("11-Kullanici gelen sayfada ADD TO CART butonunun gorundugunu dogrular");
                actions.sendKeys(Keys.PAGE_DOWN);
                ReusableMethods.jsclick(us_3_4_11_page.addToCartButton);
                extentTest.info("12-Kullanici ADD TO CART butonuna tiklar");

                us_3_4_11_page.viewCartButtonInAProductPage.click();
                extentTest.info("13-Kullanici VIEW CART butonuna tiklar");
                ReusableMethods.jsclick(us_3_4_11_page.continueShoppingButton);


            } else {
                Driver.getDriver().navigate().back();
                extentTest.info("13-Kullanici  geri tusuyla Shop sayfasina doner");

            }
            if (us_3_4_11_page.productSizeInTheCart.getText().equals("5")) break;
            extentTest.info("15-Kullanici CART ta 5 adet urun gorene kadar ayni isleme devam eder devam eder");


        }

        Assert.assertEquals(us_3_4_11_page.productSizeInTheCart.getText(),"5");
        extentTest.info("16-Kullanici CART ta 5 adet urun oldugu dogrular");

        extentTest.pass("Kullanici CART ta 5 adet urun oldugu gormeli");
    }
}
