package tests.US_013;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_013_014_015_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;

public class US_013_CouponKodu extends TestBaseRapor {

    US_013_014_015_Page us_013_014_015_page= new US_013_014_015_Page();
    Actions actions = new Actions(Driver.getDriver());
    Select select;
    @Test
    public void loginAndCouponsTabTest() throws InterruptedException {
        extentTest=extentReports.createTest("loginAndCouponsTabTest","Login olabilme ve Coupons Tab a girebilme");
        //1-Kullanici https://hubcomfy.com/ gider
        Driver.getDriver().get(ConfigReader.getProperty("hubcomfyUrl"));
        extentTest.info("Hubcomfy sitesine gidildi");
        ReusableMethods.waitFor(3);
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
        ReusableMethods.waitFor(4);
        actions.sendKeys(Keys.END).perform();
        ReusableMethods.waitFor(3);
        ReusableMethods.jsclick(us_013_014_015_page.myAccountLink);
        extentTest.info("My Account linkine tiklandi");
        //7-Kullanici "Store Manager" sekmesine tiklar
        us_013_014_015_page.storeManagerTab.click();
        extentTest.info("Store Manager sekmesine tiklandi");
        //8-Kullanici "Store Manager" yazisinin gorunurlugunu dogrular
        Assert.assertTrue(us_013_014_015_page.storeManagerText.isDisplayed());
        extentTest.info("Store Manager yazisinin gorunurlugu dogrulandi");
        //9-Kullanici "Coupons"  sekmesine tiklar
        ReusableMethods.waitFor(3);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        us_013_014_015_page.couponsTab.click();
        extentTest.info("Coupons sekmesine tiklandi");
        //10-Kullanici "Coupons Listing" yazisinin gorunurlugunu dogrular
        Assert.assertTrue(us_013_014_015_page.couponsListingText.isDisplayed());
        extentTest.pass("Coupons Listing yazisinin gorunurlugu dogrulandi");

    }
    @Test (dependsOnMethods ="loginAndCouponsTabTest" )
    public void TC_001_CouponCodeTest() throws InterruptedException {
        extentTest=extentReports.createTest("TC_001_CouponCodeTest","Coupon kodu girebilme");
        //11-Kullanici "Add New" butonuna  tiklar
        us_013_014_015_page.addNewButton.click();
        extentTest.info("Add New butonuna  tiklandi");
        //12-Kullanici "Add Coupon" yazisinin gorunurlugunu dogrular
        Assert.assertTrue(us_013_014_015_page.addCouponText.isDisplayed());
        extentTest.info("Add Coupon yazisinin gorunurlugu dogrulandi");
        //13-Kullanici "Code" box a codu girer(code 1234A)
        us_013_014_015_page.codeBox.sendKeys("1234A");
        extentTest.info("Code box a kod girildi");
        //14-Kullanici "Submit" bottonuna tiklar
        actions.sendKeys(Keys.END).perform();
        Thread.sleep(2000);
        ReusableMethods.jsclick(us_013_014_015_page.submitButton);
        extentTest.info("Submit bottonuna tiklandi");
        //15-Kullanici Coupon kodunun gorundugunu dogrular
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.jsclick(us_013_014_015_page.couponsTab);
        ReusableMethods.waitFor(2);
        Assert.assertEquals(us_013_014_015_page.couponCodeData.getText(),"1234A");
        extentTest.pass("Coupon kodunun gorundugu dogrulandi");
        Driver.closeDriver();
    }
    @Test (dependsOnMethods ="loginAndCouponsTabTest" )
    public void TC_002_DescriptionTest() throws InterruptedException {
        extentTest=extentReports.createTest("TC_002_DescriptionTest","Description girebilme");
        //11-Kullanici "Edit" buttonuna tiklar
        ReusableMethods.waitFor(4);
        us_013_014_015_page.editButton.click();
        extentTest.info("Edit buttonuna tiklandi");
        //12-Kullanici "Description"  box a tanimi girer (Description: New Member)
        us_013_014_015_page.descriptionBox.sendKeys("New Member");
        extentTest.info("Description  box a tanim girildi ");
        //13-Kullanici "Submit" bottonuna tiklar
        Thread.sleep(2000);
        us_013_014_015_page.submitButton.click();
        extentTest.info("Submit bottonuna tiklandi");
        //14-Kullanici girdigi descriptionin gorunurlugunu dogrular
        Assert.assertEquals(us_013_014_015_page.newMemberText.getText(), "New Member");
        extentTest.pass("Descriptionin gorunurlugun dogrulandi");

    }

    @Test (dependsOnMethods ="loginAndCouponsTabTest" )
    public void TC_003_DiscountTest() throws InterruptedException {
        extentTest=extentReports.createTest("TC_002_DescriptionTest","Description girebilme");
        //11-Kullanici "Coupons" sekmesine tiklar
        Thread.sleep(2000);
        us_013_014_015_page.couponsTab.click();
        extentTest.info("Coupons sekmesine tiklandi");
        //12-Kullanici "edit buttonuna tiklar
        us_013_014_015_page.editButton.click();
        extentTest.info("Edit buttonuna tiklandi");
        // 13-Kullanici "Discount Type" drop down u secer
        select=new Select(us_013_014_015_page.discountTypeBox);
        List<WebElement> ddList=select.getOptions();
        select.selectByIndex(0);
        extentTest.info("Discount Type drop down u secildi");
        //14-Kullanici "Submit" bottonuna tiklar
        Thread.sleep(2000);
        us_013_014_015_page.submitButton.click();
        extentTest.info("Submit bottonuna tiklandi");
        //15-Kullanici "Discount Type" drop downda sectigi indirim seklinin gorunurlugunu dogrular
        Assert.assertEquals(ddList.get(0).getText(),"Percentage discount");
        extentTest.pass("Discount Type drop downda sectigi indirim seklinin gorunurlugu dogrulandi");

    }

    @Test (dependsOnMethods ="loginAndCouponsTabTest" )
    public void TC_004_CouponAmount() throws InterruptedException {
        extentTest=extentReports.createTest("TC_004_CouponAmount","CouponAmount girebilme");
        //11-Kullanici "Coupons" sekmesine tiklar
        Thread.sleep(2000);
        us_013_014_015_page.couponsTab.click();
        extentTest.info("Coupons sekmesine tiklandi");
        //12-Kullanici "edit buttonuna tiklar
        us_013_014_015_page.editButton.click();
        extentTest.info("Edit buttonuna tiklandi");
        //13-Kullanici "Coupon Amount" box a indirim miktarini girer
        us_013_014_015_page.couponAmountBox.sendKeys(Keys.DELETE,"20");
        extentTest.info("Coupon Amount box a indirim miktari girildi");
        //14-Kullanici "Submit" bottonuna tiklar
        Thread.sleep(2000);
        us_013_014_015_page.submitButton.click();
        extentTest.info("Submit bottonuna tiklandi");
        //15-Kullanici "Coupon Amount" box a indirim miktarinin gorunurlugunu dogrular
        Thread.sleep(2000);
        us_013_014_015_page.couponsTab.click();
        Assert.assertEquals(us_013_014_015_page.couponAmountData.getText(),"20");
        extentTest.pass("Coupon Amount box da indirim miktarinin gorunurlugu dogrulandi");
    }

    @Test (dependsOnMethods ="loginAndCouponsTabTest" )
    public void TC_005_CouponExpiryDateTest() throws InterruptedException {
        extentTest=extentReports.createTest("TC_005_CouponExpiryDateTest","CouponExpiryDate girebilme");
        //11-Kullanici "Coupons" sekmesine tiklar
        Thread.sleep(2000);
        us_013_014_015_page.couponsTab.click();
        extentTest.info("Coupons sekmesine tiklandi");
        //12-Kullanici "edit buttonuna tiklar
        us_013_014_015_page.editButton.click();
        extentTest.info("Edit buttonuna tiklandi");
        //13-Kullanici "Coupon expiry date" box a kupon son kullanma tarihini girer(date: 20022-12-01)
        String date="2022-12-01";
        us_013_014_015_page.expiryDateBox.sendKeys(date);
        extentTest.info("Coupon expiry date box a kupon son kullanma tarihini girildi");
        //14-Kullanici "Submit" bottonuna tiklar
        Thread.sleep(2000);
        us_013_014_015_page.submitButton.click();
        extentTest.info("Submit bottonuna tiklandi");
        //15-Kullanici "Coupon expiry date" boxda kupon son kullanma tarihinin gorunurlugunu dogrular
        WebElement beklenenDate=Driver.getDriver().findElement(By.xpath("//input[@value='"+date+"']"));
        Assert.assertTrue(beklenenDate.isDisplayed());
        extentTest.pass("Coupon expiry date boxda kupon son kullanma tarihinin gorunurlugu dogrulandi");
    }
    @Test (dependsOnMethods ="loginAndCouponsTabTest" )
    public void TC_006_FreeShippingTest() throws InterruptedException {
        extentTest=extentReports.createTest("TC_006_FreeShippingTest","Allow free shipping kutucugu isaretleyebilme");
        //11-Kullanici "Coupons" sekmesine tiklar
        Thread.sleep(2000);
        us_013_014_015_page.couponsTab.click();
        extentTest.info("Coupons sekmesine tiklandi");
        //12-Kullanici "edit buttonuna tiklar
        us_013_014_015_page.editButton.click();
        extentTest.info("Edit buttonuna tiklandi");
        //13-Kullanici "Allow free shipping" kutucugunu isaretler
        us_013_014_015_page.allowFreeShippingCheckBox.click();
        extentTest.info("Allow free shipping kutucugu isaretlendi");
        //14-Kullanici "Submit" bottonuna tiklar
        Thread.sleep(2000);
        us_013_014_015_page.submitButton.click();
        extentTest.info("Submit bottonuna tiklandi");
        //15-Kullanici "Allow free shipping" kutucugunun isaretlendigini dogrular
        Assert.assertTrue(us_013_014_015_page.allowFreeShippingCheckBox.isSelected());
        extentTest.pass("Allow free shipping kutucugunun isaretlendigi dogrulandi");
    }

    @Test (dependsOnMethods ="loginAndCouponsTabTest")
    public void TC_007_ShowOnStoreTest() throws InterruptedException {
        extentTest=extentReports.createTest("TC_007_ShowOnStoreTest","ShowOnStoreTest kutucugu isaretleyebilme");
        //11-Kullanici "Coupons" sekmesine tiklar
        Thread.sleep(2000);
        us_013_014_015_page.couponsTab.click();
        extentTest.info("Coupons sekmesine tiklandi");
        //12-Kullanici "edit buttonuna tiklar
        us_013_014_015_page.editButton.click();
        extentTest.info("Edit buttonuna tiklandi");
        //13-Kullanici "Show on store" kutucugunu isaretler
        us_013_014_015_page.showOnStoreCheckbox.click();
        extentTest.info("Show on store kutucugu isaretlendi");
        //14-Kullanici "Submit" bottonuna tiklar
        Thread.sleep(2000);
        us_013_014_015_page.submitButton.click();
        extentTest.info("Submit bottonuna tiklandi");
        //15-Kullanici "Show on store" kutucugunun isaretlendigini dogrular
        Assert.assertTrue(us_013_014_015_page.showOnStoreCheckbox.isSelected());
        extentTest.pass("Show on store kutucugunun isaretlendigi dogrulandi");
        Driver.closeDriver();

    }


}
