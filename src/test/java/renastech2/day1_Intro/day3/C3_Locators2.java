package renastech2.day1_Intro.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C3_Locators2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.guru99.com/test/selenium-xpath.html");
        //we can store a webElement so now everytime we call testingHeader we're calling our stored xpath
        //xPath second way //tagname[.='text']--looks for exact text match for any attribute
        WebElement TestingHeader= driver.findElement(By.xpath("//b[.='Testing']"));
        //.getText will get the text stored in our xpath
        System.out.println(TestingHeader.getText());

        //absolute xpath method is explained in your notes pg 9 of renastech2.day1_Intro.day3 selenium testng setup
        WebElement TestingHeader2 = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/h4[1]/b"));
        System.out.println(TestingHeader2.getText());

    }
}
