package renastech2.day1_Intro.Day5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import renastech2.day1_Intro.utilities.WebDriverUtil;

import java.util.concurrent.TimeUnit;

public class TestNG_Google {

    //1- Go to google
//2- Verify title is google

//1- Go to google
//search laptop
//make sure title contains laptop

    //common steps : setup driver, and go to google

    WebDriver driver; //null driver right now because its not assigned. (instance variable)

    @BeforeMethod
    public void setup(){
        //this annotation will apply to all your tests. it is better to use common steps here so that you dont
        //duplicate steps

        driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://google.com");
    }
    @Test(priority = 1)
    public void TC1_googleVerifyTitle() throws InterruptedException {
        System.out.println("TC1 is running!");
        //go to google <-- this is being done in before method
        //verify title
        String expectedTitle="Google";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle,"Title Verification has failed!");
    }
    @Test(priority = 2)
    public void TC2_GoogleVerifySearchBox(){
        //go to google, search laptop, and make sure title contains laptop. go to google is done in before method
        System.out.println("TC2 is running");
        WebElement googleSearchBox = driver.findElement(By.xpath("//input[@name='q']"));
        googleSearchBox.sendKeys("laptop", Keys.ENTER);

        //make sure title contains "laptop"
        String actualTitle= driver.getTitle();
        String containsTitle= "laptop";

        boolean b= actualTitle.contains(containsTitle);
        Assert.assertTrue(b,"search function failed!!");
    }

    @AfterMethod
    public void closing(){
        driver.close();
    }
}
