package renastech2.day1_Intro.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import renastech2.day1_Intro.utilities.WebDriverUtil;

public class GetText_GetAttribute {
    public static void main(String[] args) throws InterruptedException {
        //create connection between driver and browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://google.com");
        Thread.sleep(2000);
        WebElement gmailButton = driver.findElement(By.linkText("Gmail"));
        System.out.println("gmailButton.getText() = " + gmailButton.getText());//will get me text from html code
        //anything in black is text, //in order for it to work there must be some text.
        System.out.println("gmailButton.getAttribute(\"href\") = " + gmailButton.getAttribute("href"));
        //the above will get me the attribute value of whatever ive passed if i pass ID, id get the attribute value
        System.out.println("gmailButton.getAttribute(\"class\") = " + gmailButton.getAttribute("class"));
         //the above returned the className attribute value "gb_j"
        //Attribute will be in orange thats what we get when we use getAttribute()

        WebElement aboutButton = driver.findElement(By.className("MV3Tnb"));
        System.out.println("aboutButton.getAttribute(\"class\") = " + aboutButton.getAttribute("class"));

        driver.close();


    }
}



