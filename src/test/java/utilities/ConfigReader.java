package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static Properties properties;

    static {//her method'dan once calıssın dıye static block kullandik
        String path="configuration.properties";
        try {

            FileInputStream fis=new FileInputStream(path);
            properties=new Properties();
            properties.load(fis);//fis'in okudugu bilgileri properties'e yukledi

           } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static String getProperty(String key){

        return properties.getProperty(key);
    /*
    Test methodundan yolladigimiz string key degerini alip;
    Properties class'indan getProperty() method'unu kullanarak
    bu keye ait value'u bize getirir.
    ConfigRead class'indaki getProperty() methodu
    test ile cpnfiguration.properties arasinda kopru gorevi gorur.
     */

    }


}
