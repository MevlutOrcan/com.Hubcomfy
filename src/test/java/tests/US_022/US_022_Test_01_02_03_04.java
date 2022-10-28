package tests.US_022;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_20_21_22_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class US_022_Test_01_02_03_04 extends TestBaseRapor {

    static US_20_21_22_Page hubConfyPage = new US_20_21_22_Page();
    static Actions actions = new Actions(Driver.getDriver());
    static JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void testUS_022_OrtakKisim() {

        extentTest = extentReports.createTest("US_022", "Indirimli ürünler listeleme ve sıralama");

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
      // 7- Home linkine tiklayarak ana sayfaya gider
        ReusableMethods.waitFor(3);
        hubConfyPage.homeMyAccount.click();
        extentTest.info("7- Home linkine tiklayarak ana sayfaya gider");

      // 8- Kullanici tum urunleri gorebilmek icin Shop Now linkinin gorunur oldugunu dogrular
        Assert.assertTrue(hubConfyPage.shopNowLink.isDisplayed());
        extentTest.info("8- Kullanici indirimli urunleri gorebilmek icin Shop Now linkinin gorunur oldugunu dogrular");

      // 9- Kullanici tum urunleri gorebilmek icin "Shop Now" linkine tiklar
        hubConfyPage.shopNowLink.click();
        extentTest.info("9- Kullanici tum urunleri gorebilmek icin \"Shop Now\" linkine tiklar");

    }

    @Test (dependsOnMethods = "testUS_022_OrtakKisim")
    public void testUS_022_TC_001() {
        extentTest = extentReports.createTest("US_022_TC_001", "Tum urunleri gorebilmek icin Shop Now linki olmali ve tiklandiginda, o kategorinin ana sayfalarına götürmeli");

        // 10- Kullanici Shop Now linkine tikladiginda, tum urunlerin oldugu sayfanin gurunur oldugunu dogrular
        String tumUrunlerSayfasi = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(tumUrunlerSayfasi,"https://hubcomfy.com/shop/");
        extentTest.pass("Tum urunleri gorebilmek icin Shop Now linki oldugu goruldu ve tiklandiginda, o kategorinin ana sayfalarına gidilebildi");
    }

    @Test (dependsOnMethods = "testUS_022_OrtakKisim")
    public void testUS_022_TC_002() throws IOException {
        extentTest = extentReports.createTest("US_022_TC_002", "Sort By'a ait acilir kutudan, İndirimli Ürünler ile ilgili siralamalar yapilabilmeli");

        // 10- Kullanici Sort By'a ait acilir kutuyu gordugunu dogrular
        Assert.assertTrue(hubConfyPage.sortByLink.isDisplayed());
        extentTest.info("10- Kullanici Sort By'a ait acilir kutuyu gordugunu dogrular");

        // 11- Kullanici Sort By'a ait acilir kutudan "indirimli urunler" secenegini secerek indirimli urunleri siralar
        hubConfyPage.sortByLink.click();

        String expectedUrunler = "Indirimli Urunler";
        List<String> tumUrunler = new ArrayList<>();
        List<WebElement> tumUrunlerList = hubConfyPage.sortByUrunlerList;

        for (WebElement w:tumUrunlerList) {
            tumUrunler.add(w.getText());
        }
        System.out.println("*** Sort By DropDownBox List: ***"+"\n"+"========");
        tumUrunlerList.forEach(t-> System.out.println(t.getText()));

        Assert.assertFalse(tumUrunler.contains(expectedUrunler));

        extentTest.info("11- Kullanici Sort By'a ait acilir kutudan \"indirimli urunler\" secenegini secerek indirimli urunleri siralar");

      // 12- Kullanici Sort By'a ait acilir kutudan secim yapmadan, "Default sorting" seceneginin default secenek olarak gorundugunu dogrular
        Assert.assertTrue(hubConfyPage.sortBy_DefaultSorting.isDisplayed());
        extentTest.info("12- Kullanici Sort By'a ait acilir kutudan secim yapmadan, \"Default sorting\" seceneginin default secenek olarak gorundugunu dogrular");

      // 13- Kullanici Sort By'a ait acilir kutudan "Default sorting" secenegini tikladiginda default(varsayilan) urunlerin listelendigini dogrular
        ReusableMethods.waitFor(3);
        hubConfyPage.sortBy_DefaultSorting.click();
        ReusableMethods.waitFor(1);
        List<WebElement> defaultProductList = hubConfyPage.productDetailsHomePageList;
        System.out.println("*** Default Sorting Product List: ***"+"\n"+"=================");
        defaultProductList.forEach(t-> System.out.println(t.getText()));

        ReusableMethods.waitFor(1);
        ReusableMethods.getScreenshot("defaultUrunlerList");
        extentTest.info("13- Kullanici Sort By'a ait acilir kutudan \"Default sorting\" secenegini tikladiginda default(varsayilan) urunlerin listelendigini dogrular");

      // 14- Kullanici Sort By'a ait acilir kutudan "sort by popularity" secenegini tikladiginda en cok incelenen urunlerin listelendigini dogrular
        ReusableMethods.waitFor(3);
        hubConfyPage.sortBy_SortByPopularity.click();
        ReusableMethods.waitFor(1);
        List<WebElement> sortByPopularityProductList = hubConfyPage.productDetailsHomePageList;
        System.out.println("*** Sort By Popularity Product List: ***"+"\n"+"=================");
        sortByPopularityProductList.forEach(t-> System.out.println(t.getText()));

        ReusableMethods.waitFor(1);
        ReusableMethods.getScreenshot("sortByPopularityUrunlerList");
        extentTest.info("14- Kullanici Sort By'a ait acilir kutudan \"sort by popularity\" secenegini tikladiginda en cok incelenen urunlerin listelendigini dogrular");

      // 15-Kullanici Sort By'a ait acilir kutudan "sort by average rating" secenegini tikladiginda en cok en cok oy alan urunlerin listelendigini dogrular
        ReusableMethods.waitFor(3);
        hubConfyPage.sortBy_SortByAverageRating.click();
        ReusableMethods.waitFor(1);
        List<WebElement> sortByAverageRatingProductList = hubConfyPage.productDetailsHomePageList;
        System.out.println("*** Sort By Average Rating Product List: ***"+"\n"+"=================");
        sortByAverageRatingProductList.forEach(t-> System.out.println(t.getText()));

        ReusableMethods.waitFor(1);
        ReusableMethods.getScreenshot("sortByAverageRatingUrunlerList");
        extentTest.info("15-Kullanici Sort By'a ait acilir kutudan \"sort by average rating\" secenegini tikladiginda en cok en cok oy alan urunlerin listelendigini dogrular");

      // 16- Kullanici Sort By'a ait acilir kutudan "sort by latest" secenegini tikladiginda en yeniye gore urunlerin listelendigini dogrular
        ReusableMethods.waitFor(3);
        hubConfyPage.sortBy_SortByLatest.click();
        ReusableMethods.waitFor(1);
        List<WebElement> sortByLatestProductList = hubConfyPage.productDetailsHomePageList;
        System.out.println("*** Sort By Latest Product List: ***"+"\n"+"=================");
        sortByLatestProductList.forEach(t-> System.out.println(t.getText()));

        ReusableMethods.waitFor(1);
        ReusableMethods.getScreenshot("sortByLatestUrunlerList");
        extentTest.info("16- Kullanici Sort By'a ait acilir kutudan \"sort by latest\" secenegini tikladiginda en yeniye gore urunlerin listelendigini dogrular");

      // 17- Kullanici Sort By'a ait acilir kutudan "Sort by price: low to high" secenegini tikladiginda urunlerin dusuk fiyattan yuksek fiyata listelendigini dogrular
        ReusableMethods.waitFor(3);
        hubConfyPage.sortBy_PriceLowToHigh.click();
        ReusableMethods.waitFor(1);
        List<WebElement> lowToHighProductList = hubConfyPage.productDetailsHomePageList;
        System.out.println("*** Sort By Price: Low to High Product List: ***"+"\n"+"=================");
        lowToHighProductList.forEach(t-> System.out.println(t.getText()));

        ReusableMethods.waitFor(1);
        ReusableMethods.getScreenshot("lowToHighUrunlerList");
        extentTest.info("17- Kullanici Sort By'a ait acilir kutudan \"Sort by price: low to high\" secenegini tikladiginda urunlerin dusuk fiyattan yuksek fiyata listelendigini dogrular");

      // 18- Kullanici Sort By'a ait acilir kutudan "Sort by price: high to low" secenegini tikladiginda urunlerin yuksek fiyattan dusuk fiyata listelendigini dogrular
        ReusableMethods.waitFor(3);
        hubConfyPage.sortBy_PriceHighToLow.click();
        ReusableMethods.waitFor(1);
        List<WebElement> highToLowProductList = hubConfyPage.productDetailsHomePageList;
        System.out.println("*** Sort By Price: High to Low Product List: ***"+"\n"+"=================");
        highToLowProductList.forEach(t-> System.out.println(t.getText()));

        ReusableMethods.waitFor(1);
        ReusableMethods.getScreenshot("highToLowUrunlerList");
        extentTest.info("18- Kullanici Sort By'a ait acilir kutudan \"Sort by price: high to low\" secenegini tikladiginda urunlerin yuksek fiyattan dusuk fiyata listelendigini dogrular");

        extentTest.fail(" Sort By'a ait acilir kutuda, İndirimli Ürunler secenegi yok. Diger secenekler secildiginde de indirimli urunler degil tum urunler listelenmekte");

    }

    @Test (dependsOnMethods = "testUS_022_OrtakKisim")
    public void testUS_022_TC_003() {
        ReusableMethods.waitFor(3);
        Driver.getDriver().navigate().refresh();
        extentTest = extentReports.createTest("US_022 TC_003", " Sort By'a ait acilir kutudan, fiyatlar kucukten buyuge siralanabilmeli");


      //  10- Kullanici Sort By'a ait acilir kutudan fiyata gore, dusukten yuksege siralama yapmak icin "Sort by price: low to high" seceneginin gorunur oldugunu dogrular
        hubConfyPage.sortBy_PriceLowToHigh.click();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(hubConfyPage.sortBy_PriceLowToHigh.isDisplayed());
        extentTest.info("11- Kullanici Sort By'a ait acilir kutudan fiyata gore, dusukten yuksege siralama yapmak icin \"Sort by price: low to high\" seceneginin gorunur oldugunu dogrular");

      //  11- Kullanici Sort By'a ait acilir kutudan fiyata gore siralama yapmak icin "Sort by price: low to high" secenegine tiklar
        ReusableMethods.waitFor(1);
        hubConfyPage.sortBy_PriceLowToHigh.click();
        extentTest.info("12- Kullanici Sort By'a ait acilir kutudan fiyata gore siralama yapmak icin \"Sort by price: low to high\" secenegine tiklar");

      //  12- Kullanici Sort By'a ait acilir kutudan fiyata gore siralama yapmak icin "Sort by price: low to high" secenegine tikladiginda fiyatlarin kucukten buyuge siralandigini dogrular
        ReusableMethods.waitFor(1);
        List<WebElement> lowToHighProductPriceList = hubConfyPage.productPricesHomePageList;
        System.out.println("*** Sort By Price: Low to High Product Price List: ***"+"\n"+"=================");
        lowToHighProductPriceList.forEach(t-> System.out.println(t.getText()));
        extentTest.info("13- Kullanici Sort By'a ait acilir kutudan fiyata gore siralama yapmak icin \"Sort by price: low to high\" secenegine tikladiginda fiyatlarin kucukten buyuge siralandigini dogrular");

        extentTest.pass("Sort By'a ait acilir kutudan, fiyatlar kucukten buyuge siralandi");

    }

    @Test (dependsOnMethods = "testUS_022_OrtakKisim")
    public void testUS_022_TC_004() {
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitFor(3);
        extentTest = extentReports.createTest("US_022 TC_004", "Sort By'a ait acilir kutudan, fiyatlar buyukten kucuge siralanabilmeli");

       // 10- Kullanici Sort By'a ait acilir kutudan fiyata gore, yuksekten dusuge siralama yapmak icin "Sort by price:  high to low" seceneginin gorunur oldugunu dogrular
        hubConfyPage.sortBy_PriceHighToLow.click();
        ReusableMethods.waitFor(1);
       Assert.assertTrue(hubConfyPage.sortBy_PriceHighToLow.isDisplayed());
        extentTest.info("11- Kullanici Sort By'a ait acilir kutudan fiyata gore, yuksekten dusuge siralama yapmak icin \"Sort by price:  high to low\" seceneginin gorunur oldugunu dogrular");

        // 11- Kullanici Sort By'a ait acilir kutudan fiyata gore siralama yapmak icin "Sort by price: high to low" secenegine tiklar
       hubConfyPage.sortBy_PriceHighToLow.click();
       extentTest.info("12- Kullanici Sort By'a ait acilir kutudan fiyata gore siralama yapmak icin \"Sort by price: high to low\" secenegine tiklar");

        // 12- Kullanici Sort By'a ait acilir kutudan fiyata gore siralama yapmak icin "Sort by price: high to low" secenegine tikladiginda fiyatlarin buyukten kucuge siralandigini dogrular
        ReusableMethods.waitFor(1);
        List<WebElement> highToLowProductPriceList = hubConfyPage.productPricesHomePageList;
        System.out.println("*** Sort By Price: High to Low Product Price List: ***"+"\n"+"=================");
        highToLowProductPriceList.forEach(t-> System.out.println(t.getText()));
        extentTest.info("13- Kullanici Sort By'a ait acilir kutudan fiyata gore siralama yapmak icin \"Sort by price: high to low\" secenegine tikladiginda fiyatlarin buyukten kucuge siralandigini dogrular");

        extentTest.pass("Sort By'a ait acilir kutudan, fiyatlar buyukten kucuge siralandi");

        Driver.closeDriver();
    }
}
