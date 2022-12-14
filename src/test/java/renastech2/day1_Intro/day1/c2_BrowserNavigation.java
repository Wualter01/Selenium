package renastech2.day1_Intro.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class c2_BrowserNavigation {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.navigate().to("https://www.facebook.com");
        Thread.sleep(5000);
        driver.navigate().to("https://amazon.com");
        driver.navigate().back();
        driver.close();

    }
}
