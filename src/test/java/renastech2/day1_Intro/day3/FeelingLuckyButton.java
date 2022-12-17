package renastech2.day1_Intro.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import renastech2.day1_Intro.utilities.WebDriverUtil;

public class FeelingLuckyButton {
    //TASK: Google Feeling lucky button
//1- Open a chrome browser
//2- Go to: https://googLe.com
//3- Write "apple" in search box
//click i am feeling Lucky button
//Verify title is Apple

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://google.com");
        Thread.sleep(2000);
        WebElement GoogleSearchBox = driver.findElement(By.name("q"));
        GoogleSearchBox.sendKeys("Apple");
        Thread.sleep(2000);
        WebElement ImFeelingLuckyButton= driver.findElement(By.className("RNmpXc"));
        ImFeelingLuckyButton.click();
        String ContainsTitle="Apple";
        String actualTitle =driver.getTitle();
        Thread.sleep(2000);

        if (actualTitle.contains(ContainsTitle)){
            System.out.println("Apple verification has passed!");
        }else{
            System.out.println("Apple verification has failed!");
            System.out.println("Actual title = "+actualTitle);
        }
        driver.close();

    }
}
