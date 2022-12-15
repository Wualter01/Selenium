package renastech2.day1_Intro.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkedText {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(); //this creates the connection between selenium and browser
        //since WebDriver is an interface we have to use child class to create the object

        driver.manage().window().maximize();
        driver.get("https://google.com");
        Thread.sleep(2000);
        WebElement GmailButton =driver.findElement(By.linkText("Gmail"));//checks for exact match
        //driver.findElement(By.partialLinkText("Gma")); THIS IS AN EXAMPLE OF PARTIAL LINK TEXT
        GmailButton.click();
        String ExpectedTitle = "Gmail";
        String ActualTitle= driver.getTitle();

        if (ActualTitle.contains(ExpectedTitle)){
            System.out.println("Gmail verification has passed");
        }else{
            System.out.println("Gmail verification has failed!");
            System.out.println("Title is = "+ActualTitle);
        }

        driver.close();
    }

}
