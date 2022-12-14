package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import renastech2.day1_Intro.utilities.WebDriverUtil;

public class Practicing_verifyingTitle {
    public static void main(String[] args) {
        WebDriver driver = WebDriverUtil.getDriver("chrome");
        driver.get("https://google.com");
      WebElement Searchbox2= driver.findElement(By.xpath("//input[@name='q']"));
      Searchbox2.sendKeys("Barcelona",Keys.ENTER);

        String expectedTitle2 = "barcelona";
        String actualTitle2 = driver.getTitle();

        if(actualTitle2.startsWith("Barcelona")){
            System.out.println("Title verification has passed!");
        }else{
            System.out.println("Title verification has failed");
        }
        System.out.println("actualTitle is: "+actualTitle2);
    }
}
