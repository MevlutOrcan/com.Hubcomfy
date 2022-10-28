package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class CrossDriver {
    private CrossDriver(){   // Default constructor'u devre dısı bırakmak yani SingletonPattern yapmak icin kullanılıyor
        //SingletonPattern(tekli kullanim)  denir.
        // yani Driver class'ından obje olusturarak bu class'a ulasalımasın
        // sadece WebDriver uzerinden ulasılmasını sagladık

    }

    static WebDriver driver;


    public static WebDriver getDriver(String browser){
        //Eger browser'a bir deger atmamis ise properties dosyasindaki  browser calisssin demek
        browser=browser==null ? ConfigReader.getProperty("browser") : browser;

        /*Testlerimizi xml file'dan farkli browserlar ile calistirabilmek icin getDriver()
         method'una parametre atamamiz gerekir.*/

        if (driver==null) {
            switch (browser){
                /*
             CroossBrowser icin bizim gonderdigimiz browser uzerinden calismasi icin
         buraya parametre olarak girdigimiz degeri yazdik.
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
