package renastech2.day1_Intro.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class c5_cssSelector {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://amazon.com");
        //css locator
        driver.findElement(By.cssSelector("input[dir='auto']")).sendKeys("Tv");
        //3-tagName#value # means id in css
        //driver.findElement(By.id("twotabsearchtextbox"));
        //driver.findElement(By.cssSelector("input[id='thwtabsearchbox']"));
        //below is another way to use css selector with# using id after tag and then id
        driver.findElement(By.cssSelector("input#twotabsearchtextbox"));


    }
}
