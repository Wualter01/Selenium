package renastech2.day1_Intro.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C1_HelloSelenium {
    public static void main(String[] args) throws InterruptedException {

        //create connection between selenium and browser
        //setup / webDriverManager class comes from boniGarica maven repository and it is an abstract class
        //chromedriver is the method
        WebDriverManager.chromedriver().setup();

        //we create the instance of chromedriver to be able to test with chrome
        //WebDriver is an interface so we cannot create an object so we use polymorphism to create using
        //child class
        WebDriver driver = new ChromeDriver();
        //we created an instance (object) of my class
        Thread.sleep(2000);//we handle this checked exception using keyword throws
        driver.manage().window().maximize();

        Thread.sleep(2000);
        driver.get("https://Amazon.com");
        driver.getCurrentUrl();
        System.out.println("Current url is" +driver.getCurrentUrl());//this gets url address
        System.out.println("driver.getTitle() = " + driver.getTitle());//this gets open tab title..(whatever tab
        //reads)

        Thread.sleep(2000);
        driver.close();




    }
}
