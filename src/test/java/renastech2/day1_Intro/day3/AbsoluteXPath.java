package renastech2.day1_Intro.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import renastech2.day1_Intro.utilities.WebDriverUtil;

public class AbsoluteXPath {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver =WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://renas-practice.herokuapp.com/home");
        WebElement SeleniumHeader=driver.findElement(By.xpath("/html/body/app-root/div/div/app-home/h1[1]"));
        Thread.sleep(3000);

        //validate if selenium header is displayed
        if (SeleniumHeader.isDisplayed()){
            System.out.println("selenium header is displayed");
        }else{
            System.out.println("selenium is not displayed as header");
            System.out.println("header = "+ SeleniumHeader);

        }
        driver.close();
    }
}
