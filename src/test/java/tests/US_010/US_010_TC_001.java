package tests.US_010;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US_1_10_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.ArrayList;
import java.util.List;

public class US_010_TC_001 extends TestBaseRapor {

    US_1_10_Page tC001 = new US_1_10_Page();

    @Test
    public void tC001() {
        extentTest = extentReports.createTest("US_010_TC_001", "Renk secenegi; beyaz, siyah, yeşil vs tum renkler belirtilmeli");


        Driver.getDriver().get(ConfigReader.getProperty("hubcomfyUrl"));
        extentTest.info("Kullanici https://hubcomfy.com/ gider");

        tC001.signIn.click();
        extentTest.info("Kullanici sign In'e tiklar");

        ReusableMethods.waitFor(3);
        tC001.userNameEmail.sendKeys("16project.qa@gmail.com");
        extentTest.info("Kullanici email adresini girer");

        tC001.passwordSignIn.sendKeys("02Team.2022");
        extentTest.info("Kullanici gecerli passwordunu girer");

        tC001.signInButton.click();
        extentTest.info("Kullanici SIGN IN butonuna tiklar");

        ReusableMethods.getActions().release(tC001.myAccount).perform();
        ReusableMethods.waitFor(5);
        tC001.myAccount.click();
        extentTest.info("Kullanici sayfanin en altina iner ve My Account linkine tiklar");

        ReusableMethods.waitFor(5);
        tC001.storeManager.click();
        extentTest.info("Kullanici Store Manager 'e tiklar");

        tC001.products.click();
        extentTest.info("Kullanici Products'a tiklar");

        tC001.addNew.click();
        extentTest.info("Kullanici  Add New'e tiklar");

        tC001.attributes.click();
        extentTest.info("Kullanici Attributes'e tiklar");
    }

    @Test(dependsOnMethods = "tC001")
    public void tC002() {
        tC001.color.click();
        extentTest.info("Kullanici Color'u secer");


        tC001.colorBox.click();
        ReusableMethods.waitFor(5);

        List<String> colorStringList = new ArrayList<>();
        for (WebElement w : tC001.allColorList) {
            colorStringList.add(w.getText());

        }
        colorStringList.add("Black");

        tC001.selectAllColor.click();
        extentTest.info("Kullanici SelectAll butonuna tiklar");

        tC001.allColorAndSize.forEach(t -> System.out.println(t.getText()));

        Assert.assertEquals(colorStringList.size(), tC001.allColorAndSize.size());
        extentTest.pass("Kullanici tum renkleri secebildigini dogrular");
    }

    @Test(dependsOnMethods = "tC002")
    public void tC003() {
        Driver.closeDriver();
    }
}


