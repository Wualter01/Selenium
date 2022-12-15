package renastech2.day1_Intro.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;

public class TaskWithSeveign {
    //TASK: Google search
//- open a chrome browser
//2- Go to: https://google.com
//3- Write "orange" in search box
//4- Click google search button
//5- Verify title:
//Expected: Title should start with "orange" word
//6-navigate back
//7-write banana in search box
//8-verify title contains banana.

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(); //creates my connection selenium to browser
        //using child class and polymorphism since class in interface you cannot create the object

        driver.manage().window().maximize();
        driver.get("https://google.com");
        Thread.sleep(2000);
        WebElement searchBox =driver.findElement(By.name("q"));
        searchBox.sendKeys("Orange");
        Thread.sleep(2000);
        WebElement searchButton =driver.findElement(By.name("btnK"));
        searchButton.click();
        Thread.sleep(2000);

        String ExpectedTitle = "Orange";
        String ActualTitle = driver.getTitle();

        if (ActualTitle.startsWith(ExpectedTitle)){
            System.out.println("Google verification has passed");
        }else{
            System.out.println("google verification has failed!");
        }

        driver.navigate().back();
        Thread.sleep(3000);
        searchBox.sendKeys("Banana"+ Keys.ENTER); //will use keyboard to enter comes from
        //our dependencies


        Thread.sleep(2000);

        String ExpectedTitle2= "Banana";
        String ActualTitle2 = driver.getTitle();

        if (ActualTitle2.startsWith(ExpectedTitle2)){
            System.out.println("Title verification for banana has passed");
        }else{
            System.out.println("title verification for banana has failed!");
            System.out.println("ActualTitle = "+ActualTitle2);
        }

        driver.close();
    }
}
