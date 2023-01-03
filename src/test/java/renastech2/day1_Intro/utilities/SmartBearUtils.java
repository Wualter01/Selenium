package renastech2.day1_Intro.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SmartBearUtils {

    //method goal is to create a util that will do login functions for smartBear

    public static void loginForSmartBear(WebDriver driver){
        //3- Enter username --->Tester
        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");
        //4- Enter password---›test
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        //5- Click "Login" button
        loginButton.click();


    }

    //3- enter incorrect userngme
//4- enter wrong password
//5- click login button
    //Note : create another utils method under SmartBearUtil class called negativeLoginForSmartBear
// this method should cover step3,4,5

    public static void negativeLoginForSmartBear(WebDriver driver, String UserID, String PasswordID){
        //using variables for username and password allows us to remove hard coding and now we can
        //change password and username as we need to
        //3- Enter username --->incorrect username
        WebElement username = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys(UserID);
        //4- Enter password---›incorrect password
        WebElement password = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys(PasswordID);
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        //5- Click "Login" button
        loginButton.click();
    }

    public static void verifyStreet(WebDriver driver, String streetName){
        //to locate whole table by id = ctl00_MainContent_orderGrid
        //to locate all 9 rows //table[@id='ctl00_MainContent_orderGrid']//tr
        //to locate specific row in this case row 3 --> //table[@id='ctl00_MainContent_orderGrid']//tr[3]
        //this will locate entire column in table data starting with header and first row
        //--//table[@id='ctl00_MainContent_orderGrid']//tr//td[6] row 1 which is header column 6

        //to find and to store multiple WebElements
        List<WebElement> streetList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr//td[6]"));
        //the above will store all street names from web table

        for (WebElement eachStreet : streetList){

            if (eachStreet.getText().equals(streetName)){
                Assert.assertTrue(eachStreet.getText().equals(streetName));
                return;
            }
        }

        Assert.fail("Street name : "+ streetName + " is not present on table");
    }
}
