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

public class C2_GoogleTestNG {

    //we create our instance outside of any method so that we can use it wherever we want
    WebDriver driver;

    //below is syntax for calling and setting up webDriver within testNG
    @BeforeMethod
    public void setUp(){
//all of the things below will run before each test cases this is the benefit of using beforeMethod so that you dont
        //have to keep re writing things you can just have them execute everytime before a test case
        //although you may not run this it needs a @TEST annotation that serves as a main method to run
        driver =WebDriverUtil.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
    }
    @Test(priority = 1)
    public void TC1_GoogleVerifyTitle(){
        System.out.println("Test1 is running");
        //xpath with attribute name and value 'q' qould have been quicker and easier //input[@name='q']
        WebElement SearchBox= driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        //using ,comma after your character sequence and adding Keys.Enter will allow you to click
        //its a faster method instead of having to use searchbox.click afterwards
        SearchBox.sendKeys("Laptop", Keys.ENTER);
//make sure title contains laptop using the following syntax, we are looking for laptop in the title
        String ActualTile=driver.getTitle();
        String containedTitle="Laptop";
        //now we can add our condition using if else assert boolean etc whichever we choose
        boolean b=ActualTile.contains(containedTitle);
        //using assert method and true condition it must be tru in order for it to pass in the paramater we pass
        //our stored boolean variable and with a comma we can add message in case it fails this is also benefit of
        //using assert we no longer have to use sout to print a message.. message will only print if it fails
        Assert.assertTrue(b,"search function failed");
    }
    @AfterMethod
    public void closing(){
        driver.quit();
    }
}
