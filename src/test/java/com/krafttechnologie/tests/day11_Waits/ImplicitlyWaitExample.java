package com.krafttechnologie.tests.day11_Waits;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitlyWaitExample {
    /**

     /**
     * Dynamic Wait
     Selenium --> NoSuchelementException'ın şifası, bir defa yazılır,
     implicitly wait her find element öncesi calısır.

     *bir objeye ulaşmaya çalışırken bu obje eğer sayfada henüz yüklenmemişse WebDriver’a Dom’a
     sorgu yapması için bir zaman vererek bulmasını sağlarız.

     *İmplicit wait  tüm objelere uygulanır ve belirtilen süre içerisinde bu objeyi aramaya devam eder,
     bulunmasını istediğimiz obje için ExpectedConditions belitmek zorunda DEGİLİZ.

     *web sürücüsüne “No Such Element Exception” oluşturmadan önce belirli bir süre beklemesini söylemek için kullanılır
     * driver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS)


     --web element process gerceklestikten sonra görülür
     --before methotta calisir
     */


    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();

    }

    @Test
    public void test1(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.cssSelector("#checkbox-example>button")).click();



        WebElement message = driver.findElement(By.id("message"));
        Assert.assertEquals(message.getText(),"It's gone!");



    }


}
