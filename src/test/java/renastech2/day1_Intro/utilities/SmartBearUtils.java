package renastech2.day1_Intro.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SmartBearUtils {

//we are creating web page utils for smartBear page this will enable us to call it from anywhere using static method
    //also we wont have  to re write this code every time, now we can just call it
    public static void loginForSmartBear(WebDriver driver){
        // we passed WebDriver driver in our parameters in order to be able to fetch all these elements for us that we
        //have in this class otherwise driver could not fetch
        //this is different method from which was done in class i have sent password keys + Enter which achieves the
        //same thing essentially but my way is more time efficient and requires less typing it still clicks login
        WebElement userName = driver.findElement(By.id("ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test"+ Keys.ENTER);
    }
    //We need to pass our driver in our parameters and username and password remember we have made this method static
    //so that it may be called from anywhere
    public static void negativeLoginForSmartBear(WebDriver driver, String userID,String passwordID){
        //in this method we are sending invalid data in order to test our login using incorrect username and password
        WebElement userName = driver.findElement(By.id("ctl00_MainContent_username"));
        //we passed userID in parameters for both passwordID and userID so that we may define them later in our classes
        //we have defined them in our dataProvider annotation see c4_smartBearNegative testing
        //when we call them both passed in negativeLoginForSmartBear(     )
        //now when we call this method we will use everything passed in parameters
        userName.sendKeys(userID);
        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys(passwordID+Keys.ENTER);

    }
//when you pass string street name in parameters now when you define in main class it will label it street name when
    //you hit quote marks ""
    public static void verifyStreet(WebDriver driver, String streetName){
//to locate all table data //table[@class='SampleTable']....- to find everything in tr or to select everything
        //one by one //table[@class='SampleTable']//tr this will give us all data in rows
        //to locate 4th row //table[@class='SampleTable']//tr[4] this chooses individual row
        //to locate all streets //table[@class='SampleTable']//tr//td[6] these double dashes mean parent tag
        //the above code will get everything in that row which is streets

//tr up and down td goes side to side <--> street list contains all street names
    List<WebElement> streetList= driver.findElements(By.xpath("//table[@class='SampleTable']//tr//td[6]"));
//we are storing our webElement in another webElement and then doing for loop method to check street name one by one
        //then we add our if statement
    for (WebElement eachStreet: streetList){
//we have not defined streetName yet but we will in the future
        if (eachStreet.getText().equals(streetName)){
            Assert.assertTrue(eachStreet.getText().equals(streetName));
            return;
        }
        Assert.fail("Street name: "+streetName+"is not present on table");
    }
    //WHEN WE USE PARAMETER IN UTILS OUR PURPOSE IS TO USE IT IN CLASSES OR DEFINE THEM IN OUR MAIN CLASSES OR WE CALL
        //OUR METHOD
}}
