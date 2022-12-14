package renastech2.day1_Intro.Day8;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import renastech2.day1_Intro.utilities.SmartBearUtils;
import renastech2.day1_Intro.utilities.WebDriverUtil;

import java.util.concurrent.TimeUnit;

public class C1_WebTablePractice {

    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= WebDriverUtil.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx") ;

    }
    @Test
    public void TC1_StreetVerification(){
        SmartBearUtils.loginForSmartBear(driver);
        //When validating tab title simply use assertEquals and then type your quote marks " " and expected as in
        //expected title in this case will prompt remember if you add another coma and quotes you can write a message
        //that will print only if assertion fails.
        Assert.assertEquals(driver.getTitle(),"Web Orders");
    }

    @Test(dataProvider = "TestDataForStreetName")
    public void TC2_streetVerification(String streetName){
        SmartBearUtils.loginForSmartBear(driver);
        //it says street name because we passed String street name in utils so everything put in " " is string street
        //name
        SmartBearUtils.verifyStreet(driver,streetName);

    }
    @DataProvider(name="TestDataStreetName")
    public static Object [] [] test(){
        return new Object[][]{
                {"17, Park Avenue"},
                {"44, Nibluck"}

        };
    }

}
