package renastech2.day1_Intro.Day6;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import renastech2.day1_Intro.utilities.BrowserUtils;
import renastech2.day1_Intro.utilities.SmartBearUtils;
import renastech2.day1_Intro.utilities.WebDriverUtil;

import java.util.concurrent.TimeUnit;

public class Alerts {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://renas-practice.herokuapp.com/home");



}
     @Test
    public void TC1_alertPractice() {

        driver.findElement(By.xpath("//mat-card[@id='selenium-Elements']")).click();
        driver.findElement(By.id("Alert BoxI")).click();
         WebElement alertButton = driver.findElement(By.id("confirm-demo"));
         alertButton.click();
         //now we must handle alert by switching our driver focus to alert box
         Alert alert= driver.switchTo().alert();
         BrowserUtils.wait(2);
         alert.accept();//clicks on okay button
         alertButton.click();
         BrowserUtils.wait(2);
         alert.dismiss();//this one will click on cancel

     }
}
