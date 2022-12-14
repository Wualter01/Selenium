package renastech2.day1_Intro.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class c6_getText_GetAttribute {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        WebElement GmailButton = driver.findElement(By.linkText("Gmail"));
//the bottom code is getting the text for gmailButton so whatever the text is on the button will print
        System.out.println("gmail button text is: "+GmailButton.getText());
        //href attribute and whatll print is the value
        System.out.println("gmail button href attribute is: "+GmailButton.getAttribute("href"));

    }
}
