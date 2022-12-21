package renastech2.day1_Intro.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import renastech2.day1_Intro.utilities.WebDriverUtil;

import java.util.List;

public class AppleFindElements {

    //1. Open Chrome browser
//2. Go to https://www.apple.com
//3. Click to iPhone
//4. Print out the texts of all links both with and without text and total of links

    public static void main(String[] args) {
        WebDriver driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://Apple.com");
        WebElement iphoneButton=driver.findElement(By.xpath("//a[.='iPhone']"));
        iphoneButton.click();

        //print text of all links
        //a tag name mean it has links, we checked and a tag carries linksTexts
        //we used FindElements with plural and used xPath child to parent to get all a tags
        List<WebElement> allLinks =driver.findElements(By.xpath("//body//a"));

        int linkWithText=0;//to count elements with text
        int linkWithoutText=0;//to count elements without text

        for (WebElement eachLink : allLinks){//WebElemnt is the type of object like int, String, boolean etc..
            //and we are going through and taking information from our allLinks List and temporarily putting it in
            //eachLink. then we use if else statement to check with it has text or not..below them we set our condition
            //for each if it has text increase linkWithText++ by one if not  increase by 1++ for withoutLinkText
            String elementsToText=eachLink.getText();//if it does not have text it'll be empty "" or AirTag
            System.out.println(elementsToText);

            if (elementsToText.isEmpty()){
                linkWithoutText++;
            }else{
                linkWithText++;
            }
        }

        System.out.println("linkWithoutText = " + linkWithoutText);
        System.out.println("linkWithText = " + linkWithText);
        System.out.println("allLinks.size() = " + allLinks.size());

    }
}
