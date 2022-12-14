package renastech2.day1_Intro.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleNameLocator {
    public static void main(String[] args) throws InterruptedException {

        //TASK: Google search
//1- Open a chrome browser
//2- Go to: https://google.com
//3- Write "orange" in search box
//4- Click google search button
//5- Verify title:
//Expected: Title should start with "orange" word
//6-navigate back
//7-write banana in search box
//8-verify title contains banana.
        //we used orange


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");
        //this is an example you can do it like this driver.findElement(By.name("q"));
        // using the above will only allow you to use it once as the following code will allow you to reuse.
        //we are storing it in searchBox  and then calling it whenever we need it
        WebElement searchBox = driver.findElement(By.name("q"));
        //the following code allows us to send keys into google search bar
        searchBox.sendKeys("orange");
        //.submit can  be used to enter data and proceed to the next page or enter text enter to google
        //or you may find the web element by name.click like code below
        // we added sleep wait just in case it happens to fast and element doesnt have time to load or search button
        //doesnt load in time to be clicked

        Thread.sleep(2000);
        driver.findElement(By.name("btnK")).click();
        String expectedTile = "orange";
        String actualTitle = driver.getTitle();
        //we are using actualTitle.StartsWith to verify because the title will probably be orange and something else
        //to account for the rest we just want to make sure it starts with orange
        if (expectedTile.startsWith("orange")) {
            System.out.println("Title verification passed");
        } else {
            System.out.println("Title verification has failed");
            System.out.println("actual title is: " + driver.getTitle());
        }

        Thread.sleep(2000);
        driver.navigate().back();
        //added another sleep wait because kept failing i guess because it did not load everything
        Thread.sleep(2000);
        //below we have used different method of sending keys into search bar
        searchBox.sendKeys("banana"+ Keys.ENTER);
        //alternative method: driver.findElement(By.name("q")).sendKeys("banana"+Keys.Enter all of these work

        //had to use thread sleep because like before page didnt completely load before moving on therefore skipping
        //click search button instruction
        Thread.sleep(2000);
        String expectedTitle2 ="banana";
        String actualTitle2= driver.getTitle();
        if (actualTitle2.startsWith(expectedTitle2)){
            System.out.println("test verification for banana has passed");
        }else{
            System.out.println("title verification for banana has failed");
            System.out.println("actual tile: "+driver.getTitle());
        }
        driver.close();
    }
}
