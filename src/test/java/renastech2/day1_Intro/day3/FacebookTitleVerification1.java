package renastech2.day1_Intro.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookTitleVerification1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup(); //creates the connection between selenium and my browser
        WebDriver driver = new ChromeDriver();//now we create the object or instance of our class using polymorphism
        //with our child class since WebDriver is an interface
        driver.manage().window().maximize();
        driver.get("https://Facebook.com");

        String ExpectedTitle = "Facebook - log in or sign up";
        String ActualTitle = driver.getTitle();

        if (ExpectedTitle.equals(ActualTitle)){
            System.out.println("Facebook verification passed");
        }else{
            System.out.println("Facebook verification failed!");
        }
        driver.close();
    }
}
