package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class TestBaseBeforeClassAfterClass {
    /*
    BeforeClass ve AfterClass notasyonlarini kullanirken
    JUnit'teki gibi
    static yapmaya gerek yoktur
     */
    protected WebDriver driver;
    protected Actions actions;
    protected String tarih;

    @BeforeClass(groups = "group1")
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        actions=new Actions(driver);


        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter formater=DateTimeFormatter.ofPattern("YYMMddHHmmss");
        //dosyalari kaydederken noktalar sıkıntı cıkardıgı ıcın;
        //formati sıkıntı cıkarmasın ekran goruntusu uzantısında dıye formatını ıstedıgımız hale getırdık
        tarih= date.format(formater);

    }

    @AfterClass(groups = {"group1" ,"group2"})//bu sekilde iki gruplamayida buraya dahil edebiliriz
    public void tearDown(){
        //driver.quit();
    }
}
