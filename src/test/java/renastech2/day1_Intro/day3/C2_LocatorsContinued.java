package renastech2.day1_Intro.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C2_LocatorsContinued {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver  = new ChromeDriver();
        driver.get("https://Amazon.com");
        //finding element by id and sending keys
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptop");
       // driver.findElement(By.id("nav-search-submit-button")).click();

        //Xpath locator 1-//tagName[@attribute='value']--looks for tagName attribute and value
        driver.findElement(By.xpath("//input[@type='submit']" )).click();

        Thread.sleep(2000);
        System.out.println("Test has passed!");
        driver.close();



    }
}
