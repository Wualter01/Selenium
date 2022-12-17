package renastech2.day1_Intro.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import renastech2.day1_Intro.utilities.BrowserUtils;
import renastech2.day1_Intro.utilities.WebDriverUtil;

import java.sql.DriverManager;

public class CssLocator {
    public static void main(String[] args) {
        WebDriver driver =WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://amazon.com");
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("TV");
        driver.close();
    }
}
