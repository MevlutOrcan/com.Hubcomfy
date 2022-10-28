package tests.US_014;

import org.openqa.selenium.By;
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

public class US_014_Restrictions extends TestBaseRapor {
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

    @Test (dependsOnMethods = "loginAndCouponsTabTest")
    public void TC_001_MinimumSpendTest() throws InterruptedException {
        extentTest=extentReports.createTest("TC_001_MinimumSpendTest","Minimum Spend box a spend girebilme");
        //11-Kullanici "Edit" buttonuna tiklar
        us_013_014_015_page.editButton.click();
        extentTest.info("Edit buttonuna tiklandi");
        //12-Kullanici "Minimum spend" box a minimum spend girer (data: 1)
        String spend="1";
        us_013_014_015_page.minimumSpendBox.sendKeys(spend);
        extentTest.info("Minimum spend box a minimum spend girildi");

        //13-Kullanici "Submit" bottonuna tiklar
        Thread.sleep(2000);
        us_013_014_015_page.submitButton.click();
        extentTest.info("Submit bottonuna tiklandi");

        //14-Kullanici "Minimum spend" box a minimum spend girildigini dogrular
        WebElement beklenenSpend=Driver.getDriver().findElement(By.xpath("//input[@value='"+spend+"']"));
        Assert.assertTrue(beklenenSpend.isDisplayed());
        extentTest.pass("Minimum spend box a minimum spend girildigi dogrulandi");

    }

    @Test (dependsOnMethods ="loginAndCouponsTabTest")
    public void TC_002_MaximumSpendTest() throws InterruptedException {
        extentTest=extentReports.createTest("TC002_MaximumSpendTest","MaximumSpend box a spend girebilme");
        //Kullanici "Coupons"  sekmesine tiklar
        ReusableMethods.waitFor(3);
        us_013_014_015_page.couponsTab.click();
        extentTest.info("Coupons sekmesine tiklandi");
        //11-Kullanici "Edit" buttonuna tiklar
        us_013_014_015_page.editButton.click();
        extentTest.info("Edit buttonuna tiklandi");
        //12-Kullanici "Maximum spend" box a maximum spend girer
        String spend="5";
        us_013_014_015_page.maximumSpendBox.sendKeys(spend);
        extentTest.info("Maxsimum spend box a maxsimum spend girildi");
        //13-Kullanici "Submit" bottonuna tiklar
        Thread.sleep(2000);
        us_013_014_015_page.submitButton.click();
        extentTest.info("Submit bottonuna tiklandi");

        //14-Kullanici "Maxsimum spend" box a minimum spend girildigini dogrular
        WebElement beklenenSpend=Driver.getDriver().findElement(By.xpath("//input[@value='"+spend+"']"));
        Assert.assertTrue(beklenenSpend.isDisplayed());
        extentTest.pass("Maxsimum spend box a maxsimum spend girildigi dogrulandi");

    }

    @Test (dependsOnMethods ="loginAndCouponsTabTest" )
    public void TC_003_IndividualUseOnly() throws InterruptedException {
        extentTest=extentReports.createTest("TC_003_IndividualUseOnly","Individual Use Only Check Box Tiklama");
        //Kullanici "Coupons"  sekmesine tiklar
        us_013_014_015_page.couponsTab.click();
        extentTest.info("Coupons sekmesine tiklandi");
        //11-Kullanici "Edit" buttonuna tiklar
        us_013_014_015_page.editButton.click();
        extentTest.info("Edit buttonuna tiklandi");
        //12-Kullanici "Individual use only" kutucugunu isaretler
        us_013_014_015_page.individualUseOnlyCheckbox.click();
        extentTest.info("Individual use only kutucugunu isaretlendi");
        //13-Kullanici "Submit" bottonuna tiklar
        Thread.sleep(2000);
        us_013_014_015_page.submitButton.click();
        extentTest.info("Submit bottonuna tiklandi");

        //14-Kullanici "Individual use only" kutucugunu isaretledigigni dogrular
        Assert.assertTrue(us_013_014_015_page.individualUseOnlyCheckbox.isSelected());
        extentTest.pass("Individual use only kutucugunun isaretlendigi dogrulandi");

    }

    @Test (dependsOnMethods ="loginAndCouponsTabTest" )
    public void TC_004_ExcludeSaleItemsTest() throws InterruptedException {
        extentTest=extentReports.createTest("TC_004_ExcludeSaleItemsTest","Exclude sale items Check Box Tiklama");
        //Kullanici "Coupons"  sekmesine tiklar
        ReusableMethods.waitFor(2);
        us_013_014_015_page.couponsTab.click();
        extentTest.info("Coupons sekmesine tiklandi");
        //11-Kullanici "Edit" buttonuna tiklar
        us_013_014_015_page.editButton.click();
        extentTest.info("Edit buttonuna tiklandi");
        //12-Kullanici "Exclude sale items" kutucugunu isaretler
        us_013_014_015_page.excludeSaleItemsCheckbox.click();
        extentTest.info("Exclude sale items kutucugunu isaretlendi");
        //13-Kullanici "Submit" bottonuna tiklar
        Thread.sleep(2000);
        us_013_014_015_page.submitButton.click();
        extentTest.info("Submit bottonuna tiklandi");
        //14-Kullanici "Exclude sale items" kutucugunu isaretledigigni dogrular
        Assert.assertTrue(us_013_014_015_page.excludeSaleItemsCheckbox.isSelected());
        extentTest.pass("Exclude sale items kutucugunun isaretlendigi dogrulandi");
    }

    @Test (dependsOnMethods ="loginAndCouponsTabTest" )
    public void TC_005_ExcludeCategoriesTest () throws InterruptedException {
        extentTest=extentReports.createTest("TC_004_ExcludeSaleItemsTest","Exclude sale items Check Box Tiklama");
        //Kullanici "Coupons"  sekmesine tiklar
        ReusableMethods.waitFor(2);
        us_013_014_015_page.couponsTab.click();
        extentTest.info("Coupons sekmesine tiklandi");
        //11-Kullanici "Edit" buttonuna tiklar
        ReusableMethods.waitFor(2);
        us_013_014_015_page.editButton.click();
        extentTest.info("Edit buttonuna tiklandi");
        //12-Kullanici "Exclude categories" drop down dan secim yapar (Data: Ring)
        us_013_014_015_page.excludeCategoriesBox.click();
        us_013_014_015_page.ring.click();
        us_013_014_015_page.excludeCategoriesBox.click();
        us_013_014_015_page.accessories.click();
        extentTest.info("Ring and Accessories secildi");
        //13-Kullanici "Submit" bottonuna tiklar
        Thread.sleep(2000);
        us_013_014_015_page.submitButton.click();
        extentTest.info("Submit bottonuna tiklandi");
        //14-Kullanici "Exclude categories" den secim yapdigini dogrular
        us_013_014_015_page.excludeCategoriesSelects.stream().map(WebElement::getText).forEach(System.out::println);
        Assert.assertEquals(us_013_014_015_page.excludeCategoriesSelects.size(), 2);
        extentTest.pass("Exclude categories den secim yapildigi dogrulandi");
        Driver.closeDriver();

    }
}
