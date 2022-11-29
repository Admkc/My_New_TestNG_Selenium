package com.krafttechnologie.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    /**
     **
     ConfiguratinReader classi icerisindeki getProperty(String Key) methodu sayesinde
     configuration.properties file daki keylere ulasıp ,deger olarak atanan value ları kullanmamıza imkan saglıyor.
     *Classta olusturdugumuz static blok clas calısır calısmaz devreye girerek configuration.properties dosyasını okuyup
     orada yazılanları bu classta olusturdugumuz properties objesine load eder.
     Böylece getProperty(String key) methodu istenen key degerine ait value yu bulur.
     *getProperty(String key) static oldugundan test metodunda kullanmak icin OOP konseptine göre static metoda class ismi ile ulasılır.
     */


    private static Properties properties;

    static {

        try {
            // what file to read
            String path = "configuration.properties";
            // read the file into java, finds the file using the string path
            FileInputStream input = new FileInputStream(path);
            // properties --> class that store properties in key / value format
            properties = new Properties();
            // the values from the file input is loaded / fed in to the properties object
            properties.load(input);

            input.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static String get(String keyName){
        return properties.getProperty(keyName);
    }


}
