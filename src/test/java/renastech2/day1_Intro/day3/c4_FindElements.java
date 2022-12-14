package renastech2.day1_Intro.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class c4_FindElements {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.apple.com");
        Thread.sleep(3000);
// this is xpath from child to parent check journal pg.11 xpath syntax
        driver.findElement(By.xpath("//span[.='iPhone']/..")).click();

        //print out the text of all links 2.print out all links 3.count of links that doesnt have text
        //4.a tag has all the links
//find elements will allow you to get more than one link and then your list will also help <>
        //we will be using tag name locator and in this case 'a' is our tag name
        //we have stored all tags in allLinks then we use for each loop to check one by one
        //we are saying this list consists of webElement "type"

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

         int linkWithText =0;
         int linkWithoutText =0;

         //we used String because its returning characters not numbers for that we will use int
        for(WebElement eachLink:allLinks){
            String elementToText=eachLink.getText();
            System.out.println(elementToText);
//the bottom code is saying if it is empty count it hense each time that it is empty its going to count one
            if (elementToText.isEmpty()){
                linkWithoutText++;
                        //bottom is saying if link has text count it or add 1 to the count
            }else {
                linkWithText++;
            }
        }
        System.out.println("link with text="+linkWithText);
        System.out.println("link without text="+linkWithoutText);
        //the bottom will get the sum of all the links
        System.out.println("all the link size="+allLinks.size());

    }
}
