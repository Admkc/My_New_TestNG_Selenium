package com.krafttechnologie.tests.day10_WepElements4;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
    /**
     Selenyumda Tab ve Windows arasında fark yoktur.
     Varsayılan olarak selenyum bir HTML sayfasını kontrol eder
     Sayfayı ilk açtığımızda sadece o sayfayı işaret eder.
     Yeni Tab/Window açıldığında hala eski/current/mevcut Window üzerinde işleme
     devam eder
     Yeni Window ile herhangi bir enjeksiyon yapmak için yeni Window a geçilmelidir.

     driver.getWindowHandle())**; -→ current/geçerli window a ait unique/benzersiz bir
     kod döndürür. —> Unique identifier for window

     driver.getWindowHandles()**; — > tüm açık windows a ait ID leri döndürür. (Set of
     String ile—> Set<String>)

     MULTIPLE WINDOWS
     getWindowHandle();
     getWindowHandles();
     driver.switchTo().window(windowHandle);
     */
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        // driver.close();
        driver.quit();
    }

    @Test
    public void twoWindows() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/windows");

        String titleBeforeClick = driver.getTitle();
        System.out.println("titleBeforeClick = " + titleBeforeClick);


        WebElement click_here = driver.findElement(By.linkText("Click Here"));
        click_here.click();
        Thread.sleep(2000);

        //String titleAfterClick=driver.getTitle();
        //System.out.println("titleAfterClick = " + titleAfterClick);

        String currentTab = driver.getWindowHandle(); // title The Internet and has ID --> CDwindow-86FF1E88C72D706A5C38610F849D5408
        System.out.println("currentTab = " + currentTab);

        Set<String> windowHandles = driver.getWindowHandles();

        for (String tab : windowHandles) { // go and check one by one

            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
            }
        }

        System.out.println("driver.getTitle() = " + driver.getTitle());

    }

    @Test
    public void multipleWindows() {
        driver.get("https://the-internet.herokuapp.com/windows");

        System.out.println("driver.getTitle() = " + driver.getTitle());

        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());

        WebElement click_here = driver.findElement(By.linkText("Click Here"));
        click_here.click();
        click_here.click();
        click_here.click();
        click_here.click();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String tab : windowHandles) {
            driver.switchTo().window(tab);
            //if(driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/windows/new")){
            if (driver.getTitle().equals("New Window")) {
                //stop on this now
                break;
            }
        }
        System.out.println("after click = " + driver.getTitle());
    }
}
