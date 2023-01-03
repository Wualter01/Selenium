package renastech2.day1_Intro.Day7_Windows_Tabs_Properties;

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

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablePractice {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/Weborders/login.aspx");
    }

    @Test
    public void TC1_LoginVerification(){
        SmartBearUtils.loginForSmartBear(driver);
        Assert.assertEquals(driver.getTitle(),"Web Orders");
    }

    @Test
    public void TC2_streetVerification(){
        SmartBearUtils.loginForSmartBear(driver);
        //create a test that will check given street name and verify that it is present on table
        //EX: given street name : 17, Park Avenue
        //result passed because it is present in table
        //EX: wall street
        //result failed because street name is not present in table

        SmartBearUtils.verifyStreet(driver,"17, Park Avenue");

    }

    @Test(dataProvider = "testDataForStreetName")
    public void TC3_streetVerification(String streetName) {
        SmartBearUtils.loginForSmartBear(driver);
        SmartBearUtils.verifyStreet(driver, streetName);

    }

    @DataProvider(name ="testDataForStreetName")
    public static Object [][] test() {
        return new Object[][]{
                {"17, Park Avenue"},
                {"hello world"},
                {"Wall Street"},
                {"7, Flower Street"}};
        }

        @AfterMethod
    public void closing(){
        driver.close();

        //this is an example of data driven testing.
        }
    }

