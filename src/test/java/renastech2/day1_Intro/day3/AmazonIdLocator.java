package renastech2.day1_Intro.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonIdLocator {
    public static void main(String[] args) throws InterruptedException {
        /*
        //1.open Chrome browser
        Go to https://www.amazon.com
        type laptop on search box then
        click on search button
        verify title
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://Amazon.com");
        Thread.sleep(3000);
        WebElement AmazonSearchBox = driver.findElement(By.id("twotabsearchtextbox"));//when using ID to check if
        //its unique you can refresh page and if it doesnt change when you inspect again and if it didnt change its
        //static it doesnt change
        AmazonSearchBox.sendKeys("Laptop"+ Keys.ENTER);

        String ExpectedTitle="Laptop";
        String ActualTitle = driver.getTitle();

        if (ActualTitle.contains(ExpectedTitle)){
            System.out.println("Amazon verification has passed!!");
        }else{
            System.out.println("Amazon verification has failed!");
            System.out.println("ActualTitle = " + ActualTitle);
        }

        driver.close();
    }
}
