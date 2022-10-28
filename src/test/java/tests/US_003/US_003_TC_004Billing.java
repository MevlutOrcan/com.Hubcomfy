package tests.US_003;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

public class US_003_TC_004Billing extends US_003_TC_003Checkout {

    @Test
    public void test01Billing() {
        extentTest = extentReports.createTest("US_003 Vendor olarak, order verebilmeliyim ve orderlarimi sepette görebilmeliyim", "Kulanici BILLING DETAILS altindaki kutucuklarin dolu oldugunu gormeli");

        test01checkOut();
        us_3_4_11_page.billingFirstName.clear();
        us_3_4_11_page.billingFirstName.sendKeys(faker.name().firstName());
        us_3_4_11_page.lastNameBox.clear();
        us_3_4_11_page.lastNameBox.sendKeys(faker.name().lastName());
        us_3_4_11_page.companyBox.clear();
        us_3_4_11_page.companyBox.sendKeys(faker.company().name());
        ReusableMethods.waitFor(3);
        Select select = new Select(us_3_4_11_page.countrySelect);
        select.selectByVisibleText("Turkey");
        ReusableMethods.waitFor(7);
        executor.executeScript("arguments[0].scrollIntoView(true);", us_3_4_11_page.adress1Box);

        us_3_4_11_page.adress1Box.clear();
        us_3_4_11_page.adress1Box.sendKeys(faker.address().secondaryAddress());
        us_3_4_11_page.zipBox.clear();
        us_3_4_11_page.zipBox.sendKeys(faker.address().zipCode());
        us_3_4_11_page.cityBox.sendKeys(faker.address().city());

        select = new Select(us_3_4_11_page.citySelect);
        select.selectByVisibleText("Kahramanmaraş");

        actions.release(us_3_4_11_page.phonePhone);
        us_3_4_11_page.phonePhone.clear();
        us_3_4_11_page.phonePhone.sendKeys("01233233443");
        extentTest.info("16-Kulanici BILLING DETAILS altindaki tum bilgileri doldurur");
        extentTest.pass("Kulanici BILLING DETAILS altindaki kutucuklarin dolu oldugunu gormeli");


    }
}
