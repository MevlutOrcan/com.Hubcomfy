package tests.US_020;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_20_21_22_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;

public class US_020_TC_01_02 extends TestBaseRapor {

    static US_20_21_22_Page hubConfyPage = new US_20_21_22_Page();
    static Actions actions = new Actions(Driver.getDriver());
    static JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();


    @Test
    public static void test_US_020_OrtakKisim() {
        extentTest = extentReports.createTest("US_020","Store manager olarak ürünlerin incelenebilmesi");


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
        ReusableMethods.waitFor(2);
        jse.executeScript("arguments[0].scrollIntoView(true);", hubConfyPage.myAccount);
        ReusableMethods.jsclick(hubConfyPage.myAccount);
        extentTest.info("6- Kullanici sayfanin en altina iner ve My Account'a tiklar");

        //7- Kullanici Store Manager 'a tiklar
        hubConfyPage.storeManager.click();
        extentTest.info("7- Kullanici Store Manager 'a tiklar'");

        //8- Kullanici Reviews'e tiklar
        ReusableMethods.waitFor(2);
        jse.executeScript("arguments[0].scrollIntoView(true);", hubConfyPage.reviews);
        ReusableMethods.jsclick(hubConfyPage.reviews);
        extentTest.info("8- Kullanici Reviews'e tiklar");

        //9- Kullanici Store Manger olarak kullanici bilgisi ve commentlari inceleyebilmek icin "Product reviews" 'e tiklar
        hubConfyPage.productReviews.click();
        extentTest.info("9- Kullanici Store Manger olarak kullanici bilgisi ve commentlari inceleyebilmek icin \"Product reviews\" 'e tiklar ");
    }

    @Test(dependsOnMethods = "test_US_020_OrtakKisim")

    public void test_US_020_TC_001() {
        extentTest = extentReports.createTest("US_020 TC_001", "Kullanici bilgisi ve yazmis oldugu comment gorulmeli");

        //10- Kullanici, kullanici bilgisinin "Author" basligi altinda gorunur oldugunu dogrular
        ReusableMethods.waitFor(2);
        List<WebElement> authorList = hubConfyPage.authors;
        Assert.assertFalse(authorList.isEmpty());

        System.out.println("*** Kullanici Bilgileri ***");

        for (WebElement w : authorList) {
            System.out.println(w.getText());
        }
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        extentTest.info("10- Kullanici, kullanici bilgisinin Author basligi altinda gorunur oldugunu dogrular");

        //11- Kullanici, kullanici yorumunun "Comment" basligi altinda gorunur oldugunu dogrular
        ReusableMethods.waitFor(3);

        System.out.println("========" + "\n" + "*** Kullanici Yorumlari ***");
        List<WebElement> commentList = hubConfyPage.comments;
        Assert.assertFalse(commentList.isEmpty());

        commentList.forEach(t -> System.out.println(t.getText()));
        extentTest.pass("11- Kullanici bilgisi ve yazmis oldugu comment goruldu");

    }

    @Test(dependsOnMethods = "test_US_020_OrtakKisim")
    public void test_US_020_TC_002() {
        extentTest = extentReports.createTest("US_020 TC_002", "Kullanicinin verdigi rate ve comment tarihi gorulmeli");

        //10- Kullanici, kullanicinin verdigi rate'in "Rating" basligi altinda gorunur oldugunu dogrular
        ReusableMethods.waitFor(3);
        List<WebElement> ratingList = hubConfyPage.raiting;
        Assert.assertFalse(ratingList.isEmpty());

        System.out.println("*** Kullanici Rate'leri ***");

        for (WebElement w : ratingList) {
            System.out.println(w.getText());
        }
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        extentTest.info("10- Kullanici, kullanicinin verdigi rate'in \"Rating\" basligi altinda gorunur oldugunu dogrular");


        //11- Kullanici, kullanicinin verdigi comment tarihinin "Dated" basligi altinda  gorunur oldugunu dogrular
        ReusableMethods.waitFor(3);

        System.out.println("===========" + "\n" + "*** Kullanici Yorum Tarihleri ***");
        List<WebElement> commentDateList = hubConfyPage.commentDate;
        Assert.assertFalse(commentDateList.isEmpty());

        commentDateList.forEach(t -> System.out.println(t.getText()));
        extentTest.pass("11- Kullanicinin verdigi rate ve comment tarihi goruldu");

        Driver.closeDriver();
    }
}

//US_020 Ortak Kisim
//1- Kullanici "https://hubcomfy.com/" adresine gider
//2- Kullanici signin butonuna tiklar
//3- Kullanici username veya email girer
//4- Kullanici password girer
//5- Kullanici sign in tiklar
//6- Kullanici sayfanin en altina iner ve My Account'a tiklar
//7- Kullanici Store Manager 'a tiklar
//8- Kullanici Reviews'e tiklar
//==========
//TC001
//9- Kullanici, kullanici bilgisinin "Author" basligi altinda gorunur oldugunu dogrular
//10- Kullanici, kullanici yorumunun "Comment" basligi altinda gorunur oldugunu dogrular
//==========
//TC002
//9- Kullanici Store Manger olarak kullanicinin verdigi rate ve comment tarihlerini inceleyebilmek icin "Product reviews" 'e tiklar
//10- Kullanici, kullanicinin verdigi rate'in "Rating" basligi altinda gorunur oldugunu dogrular
//11- Kullanici, kullanicinin verdigi comment tarihinin "Dated" basligi altinda  gorunur oldugunu dogrular