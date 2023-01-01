package renastech2.day1_Intro.Day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import renastech2.day1_Intro.utilities.SmartBearUtils;
import renastech2.day1_Intro.utilities.WebDriverUtil;

import java.util.concurrent.TimeUnit;

public class NegativeTest {
    //1- Open a chrome browser
//2- Go to:http://secure.smartbearsoftware. com/samples/testcomplete12/WebOrders/login. asp
//3- enter incorrect userngme
//4- enter wrong password
//5- click login button
//6- verify error message displayed : Invalid Login or Password.
//Note : create another utils method under SmartBearUtil class called negativeLoginForSmartBear
// this method should cover step3,4,5

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        //1.open Chrome browser
        //2.go to http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx

        driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

    }

    @Test(dataProvider = "testData")
    public void TC1_NegativeTest(String username, String password){//since i have passed username first in parameters
        //it'll take data from testData 2 dimensional objects and use the first object as username and second as
        //password

        //3- enter incorrect username
//4- enter wrong password
//5- click login button
        SmartBearUtils.negativeLoginForSmartBear(driver, username, password);
//6- verify error message displayed : Invalid Login or Password.
        WebElement errorMessage = driver.findElement(By.id("ctl00_MainContent_status"));
        Assert.assertTrue(errorMessage.isDisplayed());//this will check if it is displayed using WebElement
    }

    @DataProvider(name = "testData")
    public static Object[][] wrongUserCredentials(){

        return new Object[][]{
                {"Wualter", "Katalina"},
                {"gambit", "jennifer"},
                {"", "4455553"},
                {"messut", "easy"},
                {"sss%%4$", "234 566"},
                {"Tester","Test"}
        };
        }

        @AfterMethod
    public void closing(){
        driver.close();
        }

    }

