package tests.US_010;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.US_1_10_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.ArrayList;
import java.util.List;

public class US_010_TC_002 extends TestBaseRapor {


    US_1_10_Page tC002= new US_1_10_Page();

    @DataProvider
    public static Object[][] aranansize() {
        return new Object[][]{{" ×Small"}, {" ×Medium"}, {" ×Large"}, {" ×Extra Large"}};
    }



    @Test
    public void tC001() {

        extentTest = extentReports.createTest("US_010_TC_002", "Size secenegi; small, medium, large, extra large olmali");
        Driver.getDriver().get(ConfigReader.getProperty("hubcomfyUrl"));
        extentTest.info("Kullanici https://hubcomfy.com/ gider");

        tC002.signIn.click();
        extentTest.info("Kullanici sign In'e tiklar");

        ReusableMethods.waitFor(3);
        tC002.userNameEmail.sendKeys("16project.qa@gmail.com");
        extentTest.info("Kullanici email adresini girer");


        tC002.passwordSignIn.sendKeys("02Team.2022");
        extentTest.info("Kullanici gecerli passwordunu girer");


        tC002.signInButton.click();
        extentTest.info("Kullanici SIGN IN butonuna tiklar");

        ReusableMethods.waitFor(5);

//        ReusableMethods.getActions().release(tC002.myAccount).perform();
        ReusableMethods.getActions().sendKeys(Keys.END);
        ReusableMethods.waitFor(7);
        ReusableMethods.jsclick(tC002.myAccount);
        extentTest.info("Kullanici sayfanin en altina iner ve My Account linkine tiklar");


        ReusableMethods.waitFor(5);
        tC002.storeManager.click();
        extentTest.info("Kullanici Store Manager 'e tiklar");


        ReusableMethods.jsclick(tC002.products);
        extentTest.info("Kullanici Products'a tiklar");

        ReusableMethods.jsclick(tC002.addNew);
        extentTest.info("Kullanici  Add New'e tiklar");

        ReusableMethods.jsclick(tC002.attributes);
        extentTest.info("Kullanici Attributes'e tiklar");
        ReusableMethods.jsclick(tC002.size);
        extentTest.info("Kullanici Size'i secer");
        ReusableMethods.waitFor(3);

        ReusableMethods.jsclick(tC002.selectAllSize);
        extentTest.info("Kullanici SELECT ALL butonuna tiklar");




    }



    @Test(dataProvider = "aranansize",dependsOnMethods = "tC001")
    public void tC002(String size) {

        List<String> sizeStringList=new ArrayList<>();
        for (WebElement w: tC002.allColorAndSize) {
            sizeStringList.add(w.getText());

        }
        ReusableMethods.waitFor(3);


            ReusableMethods.getSoftAssert().assertTrue(sizeStringList.contains(size));

        extentTest.pass("Kullanici istenen size'lari secebildigini dogrular");

        }

    @Test(dependsOnMethods = "tC002")
    public void tC003() {
        Driver.closeDriver();
    }
}



