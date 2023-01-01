package renastech2.day1_Intro.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

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
}
