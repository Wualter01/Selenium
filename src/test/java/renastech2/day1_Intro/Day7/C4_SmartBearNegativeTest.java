package renastech2.day1_Intro.Day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import renastech2.day1_Intro.utilities.SmartBearUtils;
import renastech2.day1_Intro.utilities.WebDriverUtil;

import java.util.concurrent.TimeUnit;

public class C4_SmartBearNegativeTest {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= WebDriverUtil.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx" );
    }
//we have passed data provider in our test annotation and provided the name of our dataProvider method so it is saying
    //go and get data from "testData" remember to create your dataProvider though like so..
    @Test(dataProvider = "testData")
    public void TC1_negativeTest(String userID, String passwordID){
        //we could pass one username and password through our parameters but we want to use multiple so we will not
        //instead we will use a method called data provider
        //we must pass what we created in our parameters in smartBearUtils
        //you have to arrange them in the order that the web page asks for password and username
        //if username is asked for first provide  username first and then password this will be true with any data
        SmartBearUtils.negativeLoginForSmartBear(driver,userID,passwordID);

        //verify error message displayed :invalid login or password
        //the following is an example of finding element by class name since it happened to be unique
        WebElement errorMessage = driver.findElement(By.className("error"));
        //assert true using our webElement errorMessage and then we are saying if it is true pass this is what we want
        //since we want to make sure error message is displayed and we have used isDisplayed method.
        Assert.assertTrue(errorMessage.isDisplayed());

    }
//@Data provider is also an annotation,DATA PROVIDER IS CONSIDERED CONTAINER FOR DATA
    @DataProvider(name = "testData")
    //we have done this without void because our return type will be object and void has no return type
    public static Object[][] wrongUserCredentials(){
        return new Object[][]{
                //remember we did not define username and password in smartBearUtils so we do that now this is where it
                //will take username and password from.
                //YOUR RESULT TABLE WILL SHOW 4 TESTS EVEN THO YOU DO NOT HAVE 4 TESTS THE REASON FOR THIS IS BECAUSE
                //YOU HAVE PROVIDED DATA 4 TIMES AND IT WILL TRY IT 4 TIMES THERE FOR CONSIDERING THEM 4 TESTS
                {"Wualter","test"},
                {"Jennifer","Rosa"},
                {"brenda","Dorian"},
                {"Katalina","tester"},
                //Tester and test are   valid username and password hence when it gets to here one test will fail because
                //we are negative testing and since it did not prompt "invalid username or password" your validation
                //using assert and isDisplayed method will fail meaning one time it did indeed pass using correct data
                {"Tester","test"}
        };
    }
}
