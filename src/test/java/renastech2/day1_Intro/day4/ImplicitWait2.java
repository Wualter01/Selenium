package renastech2.day1_Intro.day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import renastech2.day1_Intro.utilities.WebDriverUtil;

import java.util.concurrent.TimeUnit;

public class ImplicitWait2 {
    /*
    Implicit wait
--An implicit wait is tell webDriver to pull the html code for a certain amount of time when you're trying to
find element
--if page is loaded immediately it wont wait up to given second.
--type of selenium wait
     */


    public static void main(String[] args) {

        WebDriver driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://vinexponewyork.com");
        //since element is not immediately present we use implicit wait so that it loads and then executes
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement AttendButton = driver.findElement(By.xpath("//span[.='ATTEND']/.."));//had to use parent
        //tag using /.. forward slash dot dot
        AttendButton.click();
        driver.close();

    }
}
