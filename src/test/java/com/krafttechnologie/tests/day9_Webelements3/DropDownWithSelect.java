package com.krafttechnologie.tests.day9_Webelements3;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownWithSelect {

    /**
     Özel bir webelement. İletişim kurmak zor.
     Select() methodu ile manipüle edilir.
     Eğer ilgili dropdown locate edildiğinde 'tag' olarak 'select' ifadesini görüyorsak Select() classını ve onun sahip olduğu methodları kullanacağız.
     WebElement dropDown = driver.findElement(...);
     Select select = new Select(dropDown);
     select.selectByIndex(INTEGER);
     select.selectByVisibleText(STRING);

     List<WebElement> options = select.getOptions(); --> dropdown menüdeki bütün elementler options içerisinde.

     */

    WebDriver driver;
    @BeforeMethod
    public void setUp(){

        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");

        //1.dropdown i diger elementler gibi locate ediyoruz

        WebElement dropdownElement= driver.findElement(By.cssSelector("#oldSelectMenu"));

        //2.Element i constructor gibi atayarak Selenium classindan bir object olusturuyoruz

        Select selectMenu=new Select(dropdownElement);

        //Secilen ilk elementi test edelim
        String expectedOption="Red";

        String actualOption= selectMenu.getFirstSelectedOption().getText();
        System.out.println("actualOption = " + actualOption);
        Assert.assertEquals(actualOption,expectedOption,"FAIL");

//==========================================================================

        //DropDowndan diger optionlari nasil getiririz?
        //1. Select visibleText kullanacagiz

        Thread.sleep(2000);
        selectMenu.selectByVisibleText("Black");

        expectedOption="Black";
        actualOption=selectMenu.getFirstSelectedOption().getText();
        System.out.println("actualOption = " + actualOption);

        Assert.assertEquals(actualOption,expectedOption,"FAIL");

//======================================================================
        //2.Index kullanarak cagiriyoruz
        Thread.sleep(2000);
        selectMenu.selectByIndex(6);
        expectedOption="White";

        actualOption=selectMenu.getFirstSelectedOption().getText();
        System.out.println("actualOption = " + actualOption);

        Assert.assertEquals(actualOption,expectedOption,"FAIL");
//=============================================================================

        Thread.sleep(2000);
        selectMenu.selectByValue("3");
        expectedOption="Yellow";

        actualOption=selectMenu.getFirstSelectedOption().getText();
        System.out.println("actualOption = " + actualOption);

        Assert.assertEquals(actualOption,expectedOption,"FAIL");
    }
}
