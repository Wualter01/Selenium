package renastech2.day1_Intro.Day6;

import org.openqa.selenium.By;
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

public class WebTable {

    /*
   SmartBear software street verification
1. Open browser and login to Smartbear software
2. Click on View all orders
3. Verify Mark Smith has street as "9, Maple Valley'
     */

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        SmartBearUtils.loginForSmartBear(driver);
    }
    @Test
    public void TC1_verifyMarkStreetName(){
        //2. Click on View all orders
        //3. Verify Mark Smith has street as "9, Maple Valley'
        //if your data is unique you can use //td[.='9, Maple Valley'] if this address repeats you cannot. it is
        //better to go with card number since we know visa card numbers are always unique and then use the parent
        //to locate our address ex: //td[.='770077007700']//..//td[6] 6 is number down that the address falls on
        WebElement markStreet = driver.findElement(By.xpath("//td[.='770077007700']//..//td[6]"));
        System.out.println("markStreet.getText() = " + markStreet.getText());
        //to verify address
        String actualStreet= markStreet.getText();//this will compare your WebElement text to your expected street
        String expectedStreet= "9, Maple Valley";
        Assert.assertEquals(actualStreet,expectedStreet,"Street name verification failed");
    }
    @AfterMethod
    public void closing(){
        BrowserUtils.wait(2);
         driver.close();
    }
}
