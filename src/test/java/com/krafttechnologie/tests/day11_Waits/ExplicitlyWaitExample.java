package com.krafttechnologie.tests.day11_Waits;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitlyWaitExample {

    /**
     * dinamic wait
     *  --> Selenium --> Element spesific (hedefteki her bir element için ayrı ayrı oluşturulur)
     her ihtiyacın olduğunda çağır
     koşul sağlanana veya süre bitene kadar bekler
     farklı koşulları bekler (interactible,visible,invisible,text,clicible vb.)

     *Bir sonraki adım çalışmadan önce belirtilen şartın gerçekleşmesi için beklemeyi sağlayan kod parçasıdır.

     * bizim erişmek istediğimiz öğeye uygulanır. Belirli obje  ve koşul gereklidir.
     Bulunmasını istediğimiz obje için ExpectedConditions belitmeliyiz

     *Timesout excepsion verir

     WebDriverWait webDriverWait = new WebDriverWait(driver, 7);
     webDriverWait.until(ExpectedConditions.visibilityOf(SPESİFİK WEB ELEMENT))
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
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.cssSelector("#start>button")).click();

        //**** How to wait explicitly *****

        // Create an explicitly object wait
        WebDriverWait wait=new WebDriverWait(driver,15);


        WebElement hello = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        // it will wait up to 15 seconds until hello element is visible
        wait.until(ExpectedConditions.visibilityOf(hello));

        System.out.println("hello.getText() = " + hello.getText());

        Assert.assertEquals(hello.getText(),"Hello World!");


    }

    @Test
    public void test2(){

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//button[text()='Enable']")).click();

        WebDriverWait wait=new WebDriverWait(driver,10);


       // driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Batch 2 was here");


        WebElement inputBox = driver.findElement(By.xpath("//input[@type='text']"));

        wait.until(ExpectedConditions.elementToBeClickable(inputBox));

        inputBox.sendKeys("Batch 2 was here");

        WebElement message = driver.findElement(By.xpath("//p[@id='message']"));

        Assert.assertEquals(message.getText(),"It's enabled!");

    }



}
