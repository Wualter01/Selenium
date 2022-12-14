package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeveignTitleVerification {
    //Task: open chrome browser go to google verify title expected Google


    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://Amazon.com");
        Thread.sleep(4000);
        driver.navigate().to("https://Google.com");

        String ExpectedTitle="Google";
        String ActualTitle= driver.getTitle();
        Thread.sleep(2000);

        if (ActualTitle.equalsIgnoreCase(ExpectedTitle)){
            System.out.println("Google title verification has passed");
        }else{
            System.out.println("Google verification has failed");
            System.out.println("Actual title = "+ActualTitle);
        }

        driver.close();

    }
}
