package renastech2.day1_Intro.Day7_Windows_Tabs_Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import renastech2.day1_Intro.Base.TestBase;

import java.util.Set;

public class JavaScriptExamples extends TestBase {
    //this class is inheriting methods from TestBase class (@Before method, @AfterMethod)
    //encapsulation is hiding data using private methods and variables and getting getter and setter methods

    @Test
    public void TC1_HandlingWindowWithJSExecutor(){
        driver.get("https://www.youtube.com");

        // 1- we create javaScriptExecutor object and we cast our webDriver type instance into JavaScriptExecutor
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");
        //2- then we have access to the methods that are coming from JavascriptExecutor interface.
        //js.executeScript(Script,Arguments);

        Set<String> windows = driver.getWindowHandles();

        for (String window : windows){
            driver.switchTo().window(window);
            String currentWindow = driver.getWindowHandle();
            System.out.println("currentWindow = " + currentWindow);
            System.out.println("driver.getTitle() = " + driver.getTitle());
        }

    }

    @Test
    public void scrollDownWithJSExecutor(){
        JavascriptExecutor js =(JavascriptExecutor) driver;
        driver.get("https://demo.guru99.com/test/guru99home/");

        js.executeScript("window.scrollBy(0,1000)");
    }
}
