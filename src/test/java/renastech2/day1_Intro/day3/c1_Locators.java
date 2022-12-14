package renastech2.day1_Intro.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class c1_Locators {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");
        //linkText locator
        driver.findElement(By.linkText("Gmail")).click();

        //partialLinkText locator so that if you dont want to write it all out or its too long you have this
        //alternative
        //driver.findElement(By.partialLinkText("Gma")).click();

        //finding element by class name
       // driver.findElement(By.className("gb_d")).click();
        //Thread.sleep(2000);
    }
}
