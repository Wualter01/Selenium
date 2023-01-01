package renastech2.day1_Intro.Day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import renastech2.day1_Intro.utilities.BrowserUtils;
import renastech2.day1_Intro.utilities.WebDriverUtil;

import java.util.concurrent.TimeUnit;

public class IFrames {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.hyrtutorials.com/p/frames-practice.html");

    }

    @Test
    public void Iframes(){
        //in order to interact with iframes we will need to switch driver focus to iframes
        /*driver.findElement(By.id("FramesII")).click();
        BrowserUtils.wait(2);
        WebElement iFrame = driver.findElement(By.xpath("//iframe[@class='mat-elevation-z4']//.."));

         */
        driver.switchTo().frame("frm1");
        WebElement dropDownBox = driver.findElement(By.id("selectnav1"));
        Select dropDown = new Select(dropDownBox);
        BrowserUtils.wait(2);
        dropDown.selectByVisibleText("Tech News");
        //their webSite didnt work so i used another website and it works. you can either pass element or id and name
        //if there are multiple you may use index.





    }
}
