package renastech2.day1_Intro.Day6;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import renastech2.day1_Intro.utilities.BrowserUtils;
import renastech2.day1_Intro.utilities.SmartBearUtils;
import renastech2.day1_Intro.utilities.WebDriverUtil;

import java.util.concurrent.TimeUnit;

public class SmartBearTest {

    /*
    1.open Chrome browser
    2.go to http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    3.Login
    4.click on order
    5.select familyAlbum from product, set quantity to 5
    6.click "calculate" button
    7. Fill address Info with JavaFaker
    8. click on "visa" radio button
    9.generate card number using javaFaker
    10.Enter expiration date
    11.click on "Process"
    12.verify success message "New order has been successfully added" is displayed.
     */

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        //1.open Chrome browser
        //2.go to http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx

        driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        SmartBearUtils.loginForSmartBear(driver);



    }
    @Test
    public void TC1(){
        // 4.click on order
        WebElement orderButton = driver.findElement(By.linkText("Order"));
        orderButton.click();
        //5.select familyAlbum from product, set quantity to 5
        driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']")).click();
        //i dont need the step above but if you want to see it physically click and select this will let you see action
        WebElement dropDownBox = driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']"));
        Select dropDown = new Select(dropDownBox);
        //Select dropDown2 = new Select
        // (driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']")));
        //you can also do it directly instead of creating webElement for dropdownBox but its too long and looks messy
        //the way ive done it give it a cleaner and more readable look
        dropDown.selectByVisibleText("FamilyAlbum");
        WebElement quantityBox= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantityBox.sendKeys(Keys.BACK_SPACE,"5");

        //6.click "calculate" button
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        //7. Fill address Info with JavaFaker
        Faker faker = new Faker();
        WebElement customerName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        customerName.sendKeys(faker.name().fullName());
        WebElement address = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
        address.sendKeys(faker.address().streetAddress());
        WebElement cityName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
        cityName.sendKeys(faker.address().city());
        WebElement stateName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"));
        stateName.sendKeys(faker.address().state());
        WebElement zipcode = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"));
        zipcode.sendKeys(faker.address().zipCode().replaceAll("-",""));

        //8. click on "visa" radio button
        driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']")).click();
        WebElement cardNumber = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
        cardNumber.sendKeys(faker.finance().creditCard().replaceAll("-",""));
        WebElement cardExpNumber = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
        cardExpNumber.sendKeys("05/27");
        // 11.click on "Process"
        WebElement processButton = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
        processButton.click();
        //12.verify success message "New order has been successfully added" is displayed.
        WebElement successMessage = driver.findElement(By.xpath("//strong"));
        Assert.assertEquals(successMessage.getText(),"New order has been successfully added.");

    }
    @AfterMethod
    public void closing(){
        BrowserUtils.wait(2);
        driver.close();
        //example of end to end testing
    }
}

