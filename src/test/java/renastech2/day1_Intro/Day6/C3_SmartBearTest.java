package renastech2.day1_Intro.Day6;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import renastech2.day1_Intro.utilities.SmartBearUtils;
import renastech2.day1_Intro.utilities.WebDriverUtil;

import java.util.concurrent.TimeUnit;

public class C3_SmartBearTest {
    //We have created instance for webDriver below then we define our driver and set it up by calling it
    //WebDriverUtil
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver=WebDriverUtil.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearUtils.loginForSmartBear(driver);
    }
    @Test
    public void TC1(){
        //select familyAlbum from dropdownbox set quantity to 5
        //remember when you see >select< tag you can use Select method and only if you see it in html code

        driver.findElement(By.linkText("Order")).click();
        //below is dropdown bar being enabled or we are creating instance for dropdown box
        Select dropDownProduct = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        dropDownProduct.selectByVisibleText("FamilyAlbum");

        WebElement Quantity = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        //Quantity.clear method sometimes will allow you to clear the default 0 if not try
        //passing Keys in parameter syntax example: Quantity.sendKeys(Keys.BACK_SPACE);
        Quantity.sendKeys(Keys.BACK_SPACE);
        Quantity.sendKeys("5");
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();
        Faker faker = new Faker();
         //Fill in address info with java faker.. usin "street address" rather than "streetName" works better
        //using streetName will be just that just the name and not the address format
        WebElement CustomerName = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        WebElement streetName = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        WebElement city = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        WebElement state = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
        WebElement zip = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));

        //now we use our element and sendKeys method then pass faker in the parameters and look for whatever it is we
        //need
        CustomerName.sendKeys(faker.name().fullName());
        streetName.sendKeys(faker.address().streetAddress());
        city.sendKeys(faker.address().cityName());
        state.sendKeys(faker.address().state());
        //the following code .replaceAll will let you replace a letter symbol or w.e for something else in this case
        // we have replaced "-" with "" nothing just an empty space
        zip.sendKeys(faker.address().zipCode().replaceAll("-",""));
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
        WebElement visaCard = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
        //if we do not use replaceAll method it will appear with hyphen "-"
        visaCard.sendKeys(faker.finance().creditCard().replaceAll("-",""));
        WebElement expDate = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));
        expDate.sendKeys("02/24");
        //i dont write or store button in WebElement but down side of doing that is that i might forget what this code
        //is for so for future refrence write it in webElement
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();

        //verify success message "new order has been successfully added."
        WebElement successMessage = driver.findElement(By.xpath("//strong"));
//below we used assertEquals and our stored webElement to our expected message and of theyre equal it will pass
        Assert.assertEquals(successMessage.getText(),"New order has been successfully added.");
    }

}
