package renastech2.day1_Intro.Day7_Windows_Tabs_Properties;

import com.sun.java.swing.plaf.windows.resources.windows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import renastech2.day1_Intro.Base.TestBase;
import renastech2.day1_Intro.utilities.BrowserUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Windows extends TestBase {

    @Test
    public void TC1_MultiWindow(){
        driver.get("https://renas-practice.herokuapp.com/selenium/elements");
        driver.findElement(By.id("WindowsII")).click();

        System.out.println("before clicking on new window = " + driver.getTitle());

        WebElement openWindowButton = driver.findElement(By.xpath("//button[@id='open-window']"));
        openWindowButton.click();
        //after clicking on button for new window now you have to change your selenium focus on your new window
        System.out.println("after clicking on new window = " + driver.getTitle());

        Set<String> allWindows = driver.getWindowHandles();//to store all windows or tabs you currently have.

        List<String> windowList = new ArrayList<>();//Array size is fixed so thats why we went with list
        for (String window : allWindows){
            windowList.add(window);
            driver.switchTo().window(window);
            System.out.println("after switch = " + driver.getTitle());
        }

        driver.switchTo().window(windowList.get(1));
        System.out.println("after switch = " + driver.getTitle());

        //you can make your x-path more unique by adding an and condition if you are having trouble making it unique
        //EX: //span[.='Contact' and @locator='value'] you could also use or and they follow same rules as java
        //if its "and" both need to be true if its "or" just one needs to be true
        //(//span[.='Contact'])[1] this is also a way to make it unique if you have multiple results for one locator
        //contains works best when id's are dynamic and has some static parts.

        driver.findElement(By.xpath("(//span[.='Contact'])[1]")).click();

    }
    @AfterMethod
    public void closing2(){
        BrowserUtils.wait(2);
        driver.quit();
    }
}
