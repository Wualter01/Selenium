package renastech2.day1_Intro.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import renastech2.day1_Intro.utilities.WebDriverUtil;

public class FacebookNegativeTesting {
    //negative testing using facebook
    // Enter incorrect password
    //5. Verify title changed to:
//Expected: "Log into Facebook"
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver =WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://facbook.com");
        driver.findElement(By.id("email")).sendKeys("hdabjd@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("njdfbjdbs"+Keys.ENTER);
        Thread.sleep(3000);



        String ExpectedTitle="Facebook - log in or sign up";
        String actualTitle = driver.getTitle();

        if (actualTitle.equalsIgnoreCase(ExpectedTitle)){
            System.out.println("Facebook negative test has passed");
        }else{
            System.out.println("Facebook negative test has failed!");
            System.out.println("actual title = "+actualTitle);
        }
        driver.close();

    }
}
