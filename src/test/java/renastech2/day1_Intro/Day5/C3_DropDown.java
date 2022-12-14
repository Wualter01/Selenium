package renastech2.day1_Intro.Day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import renastech2.day1_Intro.utilities.WebDriverUtil;

import java.util.concurrent.TimeUnit;

public class C3_DropDown {
   /*task 1
   1. open chrome browser
   2.go to "https://the-internet.herokuapp.com/"
   3.click on dropDown
   4.confirm default selected is dropDown is "please select an option"
   TASK2
   1.open chrome browser
   2.go to "https://the-internet.herokuapp.com/"
   3.click on dropDown
   4.choose option 2 from dropDown
   5.choose option 1 from dropdown
   6.choose option 2 from dropdown

    */
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){System.out.println("Before calss is running");}
    @AfterClass
    public void AfterClass(){System.out.println("After class is running");}
    @BeforeMethod
    public void setUp(){
        driver = WebDriverUtil.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/");
    }
    @Test
    public void TC_verifyDefaultOptionInDropDown(){
        System.out.println("TC1 is running");
        driver.findElement(By.xpath("//a[@href='/dropdown']")).click();

        //confirm default selected dropDown is "please select an option"
        WebElement DropDownBox = driver.findElement(By.id("dropdown"));

        //in the parameters we must provide webElement so we pass our DropDownBox element we stored above
        Select dropdown = new Select(DropDownBox);

        //this is saying choose the first option and bring(GET) me the text
        //the second string is verifying our expected option and then we may compare with actual option
        String defaultOption = dropdown.getFirstSelectedOption().getText();
        String expectedDefault= "Please select an option";
//below code will print out actual defaultOption thats why its gettingText
        System.out.println("default option is: "+defaultOption);
        //the below code is comparing the two to verify they are EQUAL. if not code block {} will get break and
        //anything after this method within our code block will not run
        //REMEMBER WHEN USING A MESSAGE WITHING ASSERT IT WILL ONLY PRINT IF IT FAILS
        Assert.assertEquals(defaultOption,expectedDefault,"default option not\"Please select an option\"");


        /*TASK2
        1.open chrome browser
        2.go to "https://the-internet.herokuapp.com/"
        3.click on dropDown
        4.choose option 2 from dropDown
        5.choose option 1 from dropdown
        6.choose option 2 from dropdown */
    }
    @Test
    public void TC2_verifyOptionsFromDropDown() throws InterruptedException {
        System.out.println("TC2 is running");
        //we do not have to get url again because we have put it before method so it will run after every test case
        //I create
        driver.findElement(By.xpath("//a[@href='/dropdown']")).click();

        //select dropdowns are created by using <Select> tag in HTML
        //and if it is select dropdown you can handle by using Select class
//we have stored web page webElement in dropDownBox and using select and creating dropDown and now making a new Select
        //to call dropDownBox which we can use from now on example: dropDown.selectby.. another example in
        //DAy6 C3SmartBearTest
        WebElement dropDownBox= driver.findElement(By.id("dropdown"));
        Select dropDown= new Select(dropDownBox);
        //visible text means "options 2" inspect webpage to see example
        Thread.sleep(2000);
        dropDown.selectByVisibleText("Option 2");
        Thread.sleep(2000);
        //choosing option 1 by value and it should be in inspect tag (html code)
        dropDown.selectByValue("1");
        //choose option2 again using different method index is the sequence the element is in
        //ex: shown below remember index is not written in quotations "" since we are providing index(sequence its in)
        dropDown.selectByIndex(2);

    }

    @AfterMethod
    public void closing(){
        driver.close();
    }
}
