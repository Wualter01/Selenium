package renastech2.day1_Intro.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import renastech2.day1_Intro.utilities.WebDriverUtil;

import java.util.concurrent.TimeUnit;

public class c1_ImplicitWait {
    public static void main(String[] args) {
        /*Tasks
        1.open browser
        2.go to the page https://www.vinexponewyork.com/
        3.click on attend button
         */
        //we are calling chrome driver from our utilities package and defining what browser we want to use
        //in the parameters we could also have written firefox. this is the syntax to call our utilWebDriver
        WebDriver driver = WebDriverUtil.getDriver("chrome");
        driver.get("https://www.vinexponewyork.com/");
        //bottom EX: i used href because it had a white link and href means link using by linktext method
        //driver.findElement(By.linkText("ATTEND")).click();

        //syntax for implicit wait
        //implicit waits for the element to appear or as soon as it can execute the next line of code also referred to
        //as dynamic wait as opposed to static wait or thread sleep which will wait the entirety of the seconds
        //or hours,mins you have wrote.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //when using [. the dot will make it so it doesnt care about attribute just value much easier this way
        //other way was not unique use the most unique method
        //driver.findElement(By.xpath("//span[.='ATTEND']")).click();

        //css selector
        driver.findElement(By.cssSelector("a[href='/attend/'")).click();
        System.out.println("TEST PASSED");

    }
}
