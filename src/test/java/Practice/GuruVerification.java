package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import renastech2.day1_Intro.utilities.BrowserUtils;
import renastech2.day1_Intro.utilities.WebDriverUtil;

public class GuruVerification {
    /*
    1. got to https://www.demo.guru99.com/V4/
    2. Enter valid userID
    3.Enter valid password
    4. click login
     */
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver =WebDriverUtil.getDriver("chrome");
        driver.get("https://www.demo.guru99.com/V4/");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);
    }

    @Test
    public void TC1_GuruLoginVerification(){
        WebElement UserIdBox = driver.findElement(By.xpath("//input[@name='uid']"));
        UserIdBox.sendKeys("mngr470047");
        WebElement passwordBox = driver.findElement(By.xpath("//input[@name='password']"));
        passwordBox.sendKeys("mUdusAm", Keys.ENTER);

    }
    @AfterMethod
    public void closing(){
        BrowserUtils.wait(2);
        driver.close();
    }
}
