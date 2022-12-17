package renastech2.day1_Intro.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import renastech2.day1_Intro.utilities.WebDriverUtil;

//1-//tagname [attribute= 'value']-- looks for tagname attribute and value
// 2-//tagname [contains (@attribute, 'value') --locate webelemnt with the given value if contains
//3-tagname [.='text'] --looks for exact text match for any attribute

public class RelativeXpath {
    public static void main(String [] args) throws InterruptedException {
        WebDriver driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://renas-practice.herokuapp.com/home");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//mat-card[@id='selenium-Elements']")).click();

        WebElement seleniumHeader1=driver.findElement(By.xpath("//h1[.='Elements part I']"));
        if (seleniumHeader1.isDisplayed()){
            System.out.println("selenium header present");
        }else{
            System.out.println("selenium header is not present! header = "+seleniumHeader1);
        }
        Thread.sleep(2000);
        driver.close();

    }
}
