package renastech2.day1_Intro.Day7;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import renastech2.day1_Intro.utilities.BrowserUtils;
import renastech2.day1_Intro.utilities.WebDriverUtil;

import java.util.concurrent.TimeUnit;

public class C2_Alerts {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        //1. open chrome browser
        //2. go to https://renas-practice.herokuapp.com/home
        driver = WebDriverUtil.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://renas-practice.herokuapp.com/home");
    }
    @Test
    public void TC1_AlertPractice() throws InterruptedException {
        driver.findElement(By.id("selenium-Elements")).click();
        driver.findElement(By.id("Alert BoxI")).click();
        WebElement AlertButton = driver.findElement(By.id("alert-demo"));
        AlertButton.click();
        //handle alert: you create instance for alert just like we do for faker and then we do the following code
        //to switch over to the alert box
        Alert alert = driver.switchTo().alert();
        BrowserUtils.wait(3);
        //alert.accept is now handling the alert box and we add wait time to allow the alert box to be prompted
        alert.accept();
        AlertButton.click();
        //dismiss and accept will essentially do the same thing they are both useful when handling alert
        BrowserUtils.wait(3);
        alert.dismiss();//will click on cancel



    }
}
