package renastech2.day1_Intro.Day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import renastech2.day1_Intro.utilities.BrowserUtils;
import renastech2.day1_Intro.utilities.SmartBearUtils;
import renastech2.day1_Intro.utilities.WebDriverUtil;

import java.util.concurrent.TimeUnit;

public class SmartBearLogin2 {

    //1- Open a chrome browser
//2- Go to:http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/Login.aspx
//3- Enter username --->Tester
//4- Enter password---›test
//5- Click "Login" button
//6- Verify title equals: Web Orders

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        //1- Open a chrome browser
//2- Go to:http://secure.smartbearsoftware. com/samples/testcomplete12/WebOrders/Login.aspx
        driver= WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }
    @AfterMethod
    public void closing() throws InterruptedException {
        BrowserUtils.wait(2);
        driver.close();
    }

    @Test
    public void TC1_loginVerification(){
        //3- Enter username --->Tester
        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");
        //4- Enter password---›test
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        //5- Click "Login" button
        loginButton.click();
        //6- Verify title equals: Web Orders
        String ExpectedTitle = "Web Orders";
        String ActualTitle = driver.getTitle();
        Assert.assertEquals(ActualTitle,ExpectedTitle);


    }

    @Test
    public void TC2_loginVerification(){
        SmartBearUtils.loginForSmartBear(driver);
        Assert.assertTrue(driver.getTitle().equals("Web Orders"),"Login failed");
    }
}
