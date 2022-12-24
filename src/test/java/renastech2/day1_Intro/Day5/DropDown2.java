package renastech2.day1_Intro.Day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import renastech2.day1_Intro.utilities.WebDriverUtil;

import java.util.concurrent.TimeUnit;

public class DropDown2 {

    //TASK:1
//1. Open Chrome browser
//2. Go to "http://the-internet.herokuapp.com/"I
//3 click on dropdown
//confirm default selected dropdown is "Please select an option"
// TASK: 2
//1. Open Chrome browser
//2. Go to "http://the-internet.herokuapp.com/"
//3 click on dropdown //choose option 2 from dropdown //choose option 1 from dropdown //choose option 2 from dropdown

    WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        System.out.println("=======dropDown Testing Started=========");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("=========DropDown Testing Finished=========");
    }
    @BeforeMethod
    public void setup(){
        driver= WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com");
    }

    @Test
    public void TC1_verifyDefaultOptionInDropDown(){

        System.out.println("=========Test1 Started==========");
        //1. Open Chrome browser / being done in BeforeMethod
        // 2. Go to "http://the-internet.herokuapp.com/" / being done in BeforeMethod
        //3 click on dropdown/ below is how to click on dropdown option at main menu
        driver.findElement(By.xpath("//a[.='Dropdown']")).click();

        //confirm default selected dropdown is "Please select an option"
        //1-select dropdowns are created by using <Select> tag in HTML
        // and if it is select dropdown you can handle by using Select class
        WebElement dropDownBox = driver.findElement(By.id("dropdown"));//this get us our select dropdown box and its
        //options then we use below class to select between options
        Select dropDown = new Select(dropDownBox);

        String defaultOption = dropDown.getFirstSelectedOption().getText();
        String expectedDefault="Please select an option";

        System.out.println("defaultOption = " + defaultOption);//so that we can see what default option is
        Assert.assertEquals(defaultOption,expectedDefault,"Default option is not \"Please select an option\"");

    }

    @Test
    public void TC_2verifyOptionsFromDropDown() throws InterruptedException {
        System.out.println("=========Test2 Started==========");
        //click on DropDown
        //choose option 2 from dropDown
        //choose option 1 from droDown
        //choose option 2 from drowDown
        driver.findElement(By.xpath("//a[.='Dropdown']")).click();

        WebElement dropDownBox= driver.findElement(By.id("dropdown"));
        Select dropDown = new Select(dropDownBox);

        Thread.sleep(2000);//used for slowing down test so we may see functions happen during test
        dropDown.selectByVisibleText("Option 2");
        Thread.sleep(200);
        dropDown.selectByValue("1");
        Thread.sleep(2000);
        dropDown.selectByIndex(2);
    }

    @AfterMethod
    public void closing(){
        driver.close();
    }
}
