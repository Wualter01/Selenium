package renastech2.day1_Intro.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FBClassLocator {
    public static void main(String[] args) throws InterruptedException {
        //TC #3: Facebook header verification
      //1. Open Chrome browser
        //Go to https://www. facebook.com
      //3. Verify header text is as expected:
       //Expected: "Connect with friends and the world around you on Facebook."

        WebDriverManager.chromedriver().setup();//we always have to setup our connection from selenium to browser
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://facebook.com");
        Thread.sleep(2000);
        String ExpectedHeader="Connect with friends and the world around you on Facebook.";
        //i couldve also done: String actualHeader=driver. findElement (By.className (' _8eso")) .getText ();
        //and stored it in a string instead of a webElement
        WebElement ActualHeader =driver.findElement(By.className("_8eso"));

        if (ActualHeader.getText().equals(ExpectedHeader)){
            System.out.println("Facebook header verification passed");
        }else{
            System.out.println("Facebook header verification failed ");
            System.out.println("ActualHeader = " + ActualHeader);
        }

        driver.close();

    }
}
