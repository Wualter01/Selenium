package renastech2.day1_Intro.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C2_Amazon_Title_Verification {
    public static void main(String[] args) throws InterruptedException {
        //Task - 2
//Open Chrome Browser
//Go to google
//Navigate back
//Navigate forward
//Navigate to https://www.amazon.com
//Verify title contains : Smile

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
        driver.navigate().to("https://amazon.com");

        String containsTitle= "Smile";

        String actualTitle = driver.getTitle();
        //in containsTitle "smile" is stored so we're saying if it is equal to smile pass test
        if(actualTitle.equalsIgnoreCase(containsTitle)){
            System.out.println("Test has Passed!");

            //in your else condition curly braces should only be your condition after yout right sout plus message
            //then you may add driver.getActualTitle and driver.close
        }else {
            System.out.println("Test has failed");
        }
        System.out.println("Actual title: " +driver.getTitle());
        driver.close();
    }
}
