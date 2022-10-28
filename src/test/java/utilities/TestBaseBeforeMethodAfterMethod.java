package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class TestBaseBeforeMethodAfterMethod {
    //abstract yapmamizin sebebi bu classdan obje olusturulmasının onune gecmek icin kullanilir
    // ama sart degildir olmasa da olur

   protected WebDriver driver;
   protected Actions actions;
   protected String tarih;

   /*
   TestNG framework'unde @Before ve @After notasyonlari yerine
   @BeforeMethod ve @AfterMethodkullanilir
   calisma prensibi JUnit'deki Before,After ile aynidir.
    */
    @BeforeMethod(groups = "group1")
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        actions=new Actions(driver);


        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter formater=DateTimeFormatter.ofPattern("YY/MM/dd/HH:mm:ss");
        //dosyalari kaydederken noktalar sıkıntı cıkardıgı ıcın;
        //formati sıkıntı cıkarmasın ekran goruntusu uzantısında dıye formatını ıstedıgımız hale getırdık
        tarih= date.format(formater);

    }

    @AfterMethod(groups = "group1")
    public void tearDown(){
        //driver.quit();
    }


}
