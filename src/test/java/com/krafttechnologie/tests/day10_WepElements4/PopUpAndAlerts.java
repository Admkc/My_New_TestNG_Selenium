package com.krafttechnologie.tests.day10_WepElements4;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopUpAndAlerts {
    /**  POP-UPS
     * Yapılarına göre 2 farklı pop up handle etme yolu var.
     * HTML pop Ups
     pop up HTML de ise - yani inspect/incele yapalabiliyorsa normal usullerle LOCATE edilir.

     * Javascript Alerts
     Javascript kaynaklıdır ve js alerts olarak bilinir.-özel bir kütüphane lazım--
     * Inspect/İncele yapılamaz, ( üstünde click vs. olmaz)
     * JS Alerts için Alert class (Seleniumdan) kullanılır


     Alert alert = driver.switchTo().alert();
     alert.accept() --> OK
     alert.dismiss() --> Cancel
     alert.sendKeys("String") --> kutucuğa text gönderme*/


    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void PopUp() throws InterruptedException {
        driver.get("http://primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=73437");

        //click the confirm button
        driver.findElement(By.xpath("(//span[text()='Confirm'])[1]")).click();
        //click 'Yes'
        driver.findElement(By.xpath("(//span[text()='Yes'])[2]")).click();

        Thread.sleep(2000);

        //verify that confirm is accepted
        String expectedMessage="You have accepted";
        WebElement actualMessage = driver.findElement(By.xpath("//p[text()='You have accepted']"));

        Assert.assertEquals(actualMessage.getText(),expectedMessage);



    }

    @Test
    public void jsAlerts() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(1000);

        //e.g.:1 click - Click For JS Alert Button
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        // switch to JS alert pop up
        Alert alert=driver.switchTo().alert();
        Thread.sleep(2000);
        //click OK
        alert.accept();


        //e.g:2 click - Click For JS Confirm
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Thread.sleep(2000);
        //click CANCEL
        alert.dismiss();

        //e.g.:1 click - Click for JS Prompt
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(2000);
        //send keys to JS Prompt
        alert.sendKeys("KraftTech Batch 2 was here");
        Thread.sleep(4000);
        System.out.println("alert.getText() = " + alert.getText());
        alert.accept();

        //Task : verify all result above JS Alerts

    }
}
