package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTitleVerification {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();//create our connection selenium to browser
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://Amazon.com");
        Thread.sleep(4000);
        driver.navigate().to("https://Google.com");
        Thread.sleep(2000);
        driver.navigate().back();

        String containsTitle= "Smile";
        if (driver.getTitle().contains(containsTitle)){
            System.out.println("Amazon title verification has passed");
        }else{
            System.out.println("Amazon title verification has failed");
            System.out.println("Actual title = "+driver.getTitle());
        }

        driver.close();
    }
}
