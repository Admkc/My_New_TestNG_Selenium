package com.krafttechnologie.tests.day14_properties_Singleton;

import com.krafttechnologie.utilities.Driver;
import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Singleton {
    /**
     * Singleton desgin pattern çalışma zamanında yalnızca 1 object yaratılmasını garanti eden tasarım desenidir
     * Kullanımına ihtiyaç duyulan durum şudur :
     -- Birden çok sınıfın aynı instance’ı kullanması gerekmektedir.
     -- Tüm uygulama için yalnızca bir nesne olması gerekmektedir.
     --Sadece bir nesne olduğu (unique) garanti edilmelidir.

     * Singleton bir nesnenin sadece bir örneğinin olduğundan emin olmak ve bu nesneye ihtiyacınız olduğunda
     kodunuzda her yerde aynı (ve tek örneğin) çağırılmasını sağlamak için kullanılır.
     *Bu kalıp, bir sistem içerisinde yalnızca bir nesne kullanılmak istendiğinde çok yararlı olabilmektedir.
     Singleton tasarım kalıbı bir programın yaşam sürecinde belirli bir nesneden sadece bir örneğin olmasını garanti altına alır.

     Singleton pattern kullanmanın faydaları:
     -Bir instance‘a kontrollü erişim sağlanır.
     -Global değişkenler yaratmaktan kaçınırız.
     */

    //singleton class will have private constructor
    // it means other classes can NOT create an object of this class

    private Singleton(){

    }

    private  static String str;

    public static String getInstance(){

        if (str==null){
            System.out.println("str is null, assigning a value to it");
            str="chrome";
        }else{
            System.out.println("it has value, just returning it");
        }

        return  str;

    }

    @Test
    public void test2(){

//        WebDriver driver1 = WebDriverFactory.getDriver("chrome");
//        WebDriver driver2 = WebDriverFactory.getDriver("chrome");

        WebDriver driver1= Driver.get();  // driver1 run first and now driver not null
        WebDriver driver2= Driver.get();


        driver1.get("https://www.google.com.tr/?hl=tr");
        driver2.findElement(By.name("q")).sendKeys("bla bla");


    }





}
