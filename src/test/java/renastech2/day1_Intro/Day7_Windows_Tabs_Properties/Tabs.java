package renastech2.day1_Intro.Day7_Windows_Tabs_Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import renastech2.day1_Intro.Base.TestBase;
import renastech2.day1_Intro.utilities.BrowserUtils;
import renastech2.day1_Intro.utilities.WebDriverUtil;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Tabs extends TestBase {
    //inheritance example to extend my base class to all of my test
    //now we can just create our Test annotation since we have extended base class before and after method now apply
    //here

    @Test
    public void TC1_TabHandle(){
        driver.get("https://renas-practice.herokuapp.com/selenium/elements");
        driver.findElement(By.id("WindowsII")).click();


        String currentWindow= driver.getWindowHandle();//will handle just one window and it being the one you are
        //currently on
        System.out.println("currentWindow = " + currentWindow);
        System.out.println("driver.getTitle() = " + driver.getTitle());
        WebElement openTabButton =driver.findElement(By.id("open-tab"));
        openTabButton.click();

        System.out.println("After clicking tab button driver.getTitle =" + driver.getTitle());
        //in order to get title of new window we need to change driver focus because selenium can only
        //focus on one page

        Set<String> allWindows= driver.getWindowHandles();//this will get all tabs (windows)

        for(String tab : allWindows){
            driver.switchTo().window(tab);
            BrowserUtils.wait(2);
            System.out.println(driver.getTitle());
        }
    }
}
