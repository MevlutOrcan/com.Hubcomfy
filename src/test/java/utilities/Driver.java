package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
    private Driver(){   // Default constructor'u devre dısı bırakmak yani SingletonPattern yapmak icin kullanılıyor
        //SingletonPattern(tekli kullanim)  denir.
        // yani Driver class'ından obje olusturarak bu class'a ulasalımasın
        // sadece WebDriver uzerinden ulasılmasını sagladık

    }

    static WebDriver driver;
    /*
    Testlerimizi calistirdigimizda herseferinde yeni driver olusturdugu icin
    her test methodu icin yeni bir sayfa pencere(driver) acar.Eger;
    driver'a bir deger atanmamissa yani driver==null ise;
    bir kere driver'i calistir diyerek bir kere if icini calistiracak .
    Ve driver bir kere calistigi icin ve deger atandigi icin null olmayacak ve direk return edilecek.
    Ve diger testlerimiz ayni pencere(driver) uzerinde calisacaktir.
     */

    public static WebDriver getDriver(){

        if (driver==null) {
            switch (ConfigReader.getProperty("browser")){ //configuration.properties dosyasindak browser'imiza ne atarsak onunla calisir
                /*
         ➢ Driver objesi create etmeden önce farklı tarayıcı
         koşullarını kontrol etmek için switch statement
         kullanıyoruz.
         ➢ Driver Class’i singleton pattern’e uygun dizayn
         ederek tum projede farkli driver uretilmesinin onune
         geceriz
                 */

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));//hic chrome'yi acmadan test yapar
                    break;

                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();

            }


            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        return driver;
    }



    public static void closeDriver(){
        if (driver!=null) { //driver'a deger atanmissa ise close yap
            driver.close();
            driver=null;//Kapandiktan sonra sonraki acmalari garanti altina almak icin driver'i tekrar null yaptik
        }
    }


    public static void quitDriver(){
        if (driver!=null) {
            driver.quit();
            driver = null;
        }
    }

}
