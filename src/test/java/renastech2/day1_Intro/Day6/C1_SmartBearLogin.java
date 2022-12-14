package renastech2.day1_Intro.Day6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import renastech2.day1_Intro.utilities.BrowserUtils;
import renastech2.day1_Intro.utilities.SmartBearUtils;
import renastech2.day1_Intro.utilities.WebDriverUtil;

import java.util.concurrent.TimeUnit;

public class C1_SmartBearLogin {
    /*Open a chrome browser
    go to: https://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    Enter username--->Tester
    Enter password--->test
    click "Login" button
    verify title equals: Web orders
     */
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        //open chrome browser
        //go to:https://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver = WebDriverUtil.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }
    @AfterMethod
    public void closing() throws InterruptedException {
        //BrowserUtils is the class and dot .wait method is provided with description of what will pass in parameters
        //it will wait 2 seconds because we have it in mill seconds in BrowserUtils it will multiply
        BrowserUtils.wait(2);
        //driver.close();
    }
    @Test
    public void TC1_LoginVerification(){
        //Enter username
        //below is the way we filled in username and password then we need the login button element to click
        //that must be done separately we cannot .click or .Enter
        WebElement userName = driver.findElement(By.id("ctl00_MainContent_username"));
        //now below you couldve added after "Test"+Keys.Enter and that would have worked to try to login
        //instead of having to get element for login button but remember to do it or add +Keys.Enter after
        //Password otherwise youd be pressing enter before your password gets filled in
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test"+Keys.ENTER);
//this is how we verify title using assert* and strings
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Web Orders";
        //below we are comparing using assertEquals if they match it will pass or continue if not code will break
        Assert.assertEquals(ActualTitle,ExpectedTitle);
        System.out.println("Actual title is: "+driver.getTitle());
    }
    @Test
    public void TC2_LoginVerification(){
        //SmartBearUtils is class name and loginForSmartBear is method name in this method we have the code written
        //above stored so we can avoid writing it all out and we just call it. driver is what we have passed in
        //parameters in our SmartBearUtils
        SmartBearUtils.loginForSmartBear(driver);
        //verify title equals "Web Orders" using Assert.assertTrue this time. if it is true it will pass if not it
        //will print out message
        Assert.assertTrue(driver.getTitle().equals("Web Orders"),"Login Failed");
        System.out.println("actual title is: "+driver.getTitle());
    }
}
