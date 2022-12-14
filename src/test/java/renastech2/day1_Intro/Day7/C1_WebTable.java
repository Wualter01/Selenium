package renastech2.day1_Intro.Day7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import renastech2.day1_Intro.utilities.SmartBearUtils;
import renastech2.day1_Intro.utilities.WebDriverUtil;

import java.util.concurrent.TimeUnit;

public class C1_WebTable {
    /*SmartBear software street verification
    1.open browser and login to smartBear software
    2.click on view all orders
    3.verify mark smith has street as "9,maple valley"
     */
//dont forget to setup your instance before your @BeforeMethod annotation then define it in setup

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= WebDriverUtil.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        //Login
        SmartBearUtils.loginForSmartBear(driver);
    }

    @Test
    public void TC1_VerifyMarkStreetName(){
        //verify mark smith has street as "9,maple valley"
        //The following code allows us to verify street name using x path and actualStreet and ExpectedStreet methods
         WebElement MarkStreet = driver.findElement(By.xpath("//td[.='9, Maple Valley']"));
        System.out.println("mark street name = "+MarkStreet.getText());

        String actualStreet = MarkStreet.getText();
        String expected ="9, Maple Valley";
//message part of assert method will only run if it fails
        Assert.assertEquals(actualStreet,expected,"street name verification has failed");
    }
}
