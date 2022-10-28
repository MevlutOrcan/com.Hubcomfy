package tests.US_015;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_013_014_015_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_015_LimitlemelerCouponlariGorebilme extends TestBaseRapor {
    US_013_014_015_Page us_013_014_015_page= new US_013_014_015_Page();
    Actions actions = new Actions(Driver.getDriver());
    Select select;
    @Test
    public void loginAndCouponsTabTest() throws InterruptedException {
        extentTest=extentReports.createTest("loginAndCouponsTabTest","Login olabilme ve Coupons Tab a girebilme");
        //1-Kullanici https://hubcomfy.com/ gider
        Driver.getDriver().get(ConfigReader.getProperty("hubcomfyUrl"));
        extentTest.info("Hubcomfy sitesine gidildi");
        //2-Kullanici "Sign In" linkine tiklar
        us_013_014_015_page.signInLink.click();
        extentTest.info("Sign In linkine tiklandi");
        //3-Kullanici  email box a gecerli email girer
        us_013_014_015_page.emailBox.sendKeys("hanifehzrlar@gmail.com");
        extentTest.info("email box a gecerli email girildi");
        //4-Kullanici password box a gecerli password girer
        us_013_014_015_page.passwordBox.sendKeys("abcd1234");
        extentTest.info("password box a gecerli password girildi");
        //5-Kullanici "SIGN IN" butonuna tiklar
        us_013_014_015_page.signInButton.click();
        extentTest.info("SIGN IN butonuna tiklandi");
        //6-Kullanici sayfanin en altina iner "My Account" linkine tiklar
        actions.release(us_013_014_015_page.myAccountLink).perform();
        Thread.sleep(2000);
        us_013_014_015_page.myAccountLink.click();
        extentTest.info("My Account linkine tiklandi");
        //7-Kullanici "Store Manager" sekmesine tiklar
        us_013_014_015_page.storeManagerTab.click();
        extentTest.info("Store Manager sekmesine tiklandi");
        //8-Kullanici "Store Manager" yazisinin gorunurlugunu dogrular
        Assert.assertTrue(us_013_014_015_page.storeManagerText.isDisplayed());
        extentTest.info("Store Manager yazisinin gorunurlugu dogrulandi");
        //9-Kullanici "Coupons"  sekmesine tiklar
        us_013_014_015_page.couponsTab.click();
        extentTest.info("Coupons sekmesine tiklandi");
        //10-Kullanici "Coupons Listing" yazisinin gorunurlugunu dogrular
        Assert.assertTrue(us_013_014_015_page.couponsListingText.isDisplayed());
        extentTest.pass("Coupons Listing yazisinin gorunurlugu dogrulandi");
    }

    @Test (dependsOnMethods ="loginAndCouponsTabTest")
    public void TC_001_UsageLimitPerCouponTest() {
        extentTest=extentReports.createTest("TC_001_UsageLimitPerCouponTest","Usage limit per coupon/kupon basina kullanım limiti eklenebilme");

        //11-Kullanici "Edit" buttonuna tiklar
        us_013_014_015_page.editButton.click();
        extentTest.info("Edit buttonuna tiklandi");
        //12-Kullanici "Limit" sekmesine tiklar
        us_013_014_015_page.limitTab.click();
        extentTest.info("Limit sekmesine  tiklandi");
        //13-Kullanici "Usage limit per coupon" box a kupon basina limit ekler(Data:100)
        us_013_014_015_page.usageLimitPerCouponBox.sendKeys("100");
        extentTest.info("Usage limit per coupon box a kupon basina limit eklendi");
        //14-Kullanici "Submit" bottonuna tiklar
        ReusableMethods.waitFor(2);
        us_013_014_015_page.submitButton.click();
        extentTest.info("Submit bottonuna tiklandi");
        //15-Kullanici "Limit" sekmesine tiklar
        ReusableMethods.waitFor(4);
        us_013_014_015_page.limitTab.click();
        extentTest.info("Limit sekmesine  tiklandi");

        //16-Kullanici "Usage limit per coupon" box a kupon basina limit eklendigini dogrular
        Assert.assertEquals(us_013_014_015_page.usageLimitPerCouponText.getAttribute("value"),"100");
        extentTest.pass("Usage limit per coupon box a kupon basina limit eklendigi dogrulandi");
    }

    @Test (dependsOnMethods ="loginAndCouponsTabTest")
    public void TC_002_LimitUsageToXItemsTest() {
        extentTest=extentReports.createTest("TC_002_LimitUsageToXItemsTest","Limit usage to Xitems/Belli urunlere kupon kullanım limiti uygulama");
        //Kullanici "Coupons"  sekmesine tiklar
        us_013_014_015_page.couponsTab.click();
        extentTest.info("Coupons sekmesine tiklandi");
        //11-Kullanici "Edit" buttonuna tiklar
        us_013_014_015_page.editButton.click();
        extentTest.info("Edit buttonuna tiklandi");
        //12-Kullanici "Limit" sekmesine tiklar
        ReusableMethods.waitFor(4);
        us_013_014_015_page.limitTab.click();
        extentTest.info("Limit sekmesine  tiklandi");
        //13-Kullanici "Limit usage to X items" box a urun sinirlandirmasi girer(Data:3)
        us_013_014_015_page.limitUsageToXItemsBox.sendKeys("3");
        extentTest.info("Limit usage to X items box a urun sinirlandirmasi girdi");
        //14-Kullanici "Submit" bottonuna tiklar
        ReusableMethods.waitFor(2);
        us_013_014_015_page.submitButton.click();
        extentTest.info("Submit bottonuna tiklandi");
        //15-Kullanici "Limit" sekmesine tiklar
        ReusableMethods.waitFor(4);
        us_013_014_015_page.limitTab.click();
        extentTest.info("Limit sekmesine  tiklandi");
        //16-Kullanici "Limit usage to X items" box a kupon basina limit eklendigini dogrular
        Assert.assertEquals(us_013_014_015_page.limitUsageToXItemsText.getAttribute("value"),"3");
        extentTest.pass("Usage limit per coupon box a kupon basina limit eklendigi dogrulandi");

    }

    @Test (dependsOnMethods ="loginAndCouponsTabTest")
    public void TC_003_UsageLimitPerUserTest() {
        extentTest=extentReports.createTest("TC_003_UsageLimitPerUserTest","Usage limit per user/belli kimselere kullanım limiti koy mesela çok kullanan userlara");
        //Kullanici "Coupons"  sekmesine tiklar
        us_013_014_015_page.couponsTab.click();
        extentTest.info("Coupons sekmesine tiklandi");
        //11-Kullanici "Edit" buttonuna tiklar
        us_013_014_015_page.editButton.click();
        extentTest.info("Edit buttonuna tiklandi");
        //12-Kullanici "Limit" sekmesine tiklar
        ReusableMethods.waitFor(4);
        us_013_014_015_page.limitTab.click();
        extentTest.info("Limit sekmesine  tiklandi");
        //13-Kullanici  "Usage limit per user"  box a kullanici basi kullanim sinirini girer(Data:2)
        us_013_014_015_page.usageLimitPerUserBox.sendKeys("2");
        extentTest.info("Usage limit per user  box a kullanici basi kullanim sinirini girdi");
        //14-Kullanici "Submit" bottonuna tiklar
        ReusableMethods.waitFor(2);
        us_013_014_015_page.submitButton.click();
        extentTest.info("Submit bottonuna tiklandi");
        //15-Kullanici "Limit" sekmesine tiklar
        ReusableMethods.waitFor(4);
        us_013_014_015_page.limitTab.click();
        extentTest.info("Limit sekmesine  tiklandi");
        //16-Kullanici  "Usage limit per user"  box a kullanici basi kullanim sinirini girdigini dogrular
        Assert.assertEquals(us_013_014_015_page.usageLimitPerUserText.getAttribute("value"),"2");
        extentTest.pass("Usage limit per user box a kullanici basi kullanim sinirini girdigini dogruladi");
        Driver.closeDriver();
    }
}
