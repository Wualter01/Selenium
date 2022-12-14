package renastech2.day1_Intro.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class c2_BrowserNavigation {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();//this creates the connection from selenium to webBrowser
        //WebDriverManager is the parent of all webDriver classes and interfaces
        WebDriver driver= new ChromeDriver();//create the object or instance of your class chromeDriver using
        //polymorphism and child class/ WebDriver is parent ChromeDriver is child

        driver.manage().window().maximize();
        driver.navigate().to("https://www.facebook.com");

        Thread.sleep(2000);//code may be faster than computer so thats why its best to use some thread.sleep
        driver.navigate().to("https://amazon.com");
        driver.navigate().back();
        System.out.println("driver.getTitle() = " + driver.getTitle());

        driver.close();

    }
}
