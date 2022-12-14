package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import renastech2.day1_Intro.utilities.WebDriverUtil;

public class google_Verification {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
       driver= WebDriverUtil.getDriver("chrome");
        driver.get("https://www.google.com");

    }
    @Test
    public void TC1_Verification(){

        Assert.assertEquals(driver.getTitle(),"Google","Test has failed");
        System.out.println("actualTitle: = " +driver.getTitle());
    }



}
