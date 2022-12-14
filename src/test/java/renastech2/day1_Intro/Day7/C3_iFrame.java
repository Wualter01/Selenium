package renastech2.day1_Intro.Day7;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import renastech2.day1_Intro.utilities.WebDriverUtil;

import java.util.concurrent.TimeUnit;

public class C3_iFrame {
    //open chrome browser
    //2.go to https://the-internet.herokuapp.com/iframe
    //3.switching by id or name attribute value
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = WebDriverUtil.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/iframe");
    }
    @Test
    public void TC1_iFrame(){
//switching to iframe by id or name attribute value your iframe element will either be in the form of either ID
        //or "Name" only these two and when switching to ifram itll simply be switchto.frame not iframe.
        driver.switchTo().frame("mce_0_ifr");
        //now we find element for box so we can send data keys etc. we cannot just simply switch and begin writing or
        //sending data.  We have stored our messageBox in an element and then called it to send keys but first we
        //cleared because there was already data in the box. no instance required like with alert
        WebElement messageBox= driver.findElement(By.id("tinymce"));
        messageBox.clear();
        messageBox.sendKeys("this is us first clearing and then sending data");

        //when you use switchTo.defaultContent itll go all the way back to the top of html code (html as in when you..
        //inspect).this is the first method
        //driver.switchTo().defaultContent();//returns to main html
        driver.switchTo().parentFrame();//if you are inside multiple frames it will return to first frame.
        driver.findElement(By.xpath("//span[.='Edit']")).click();
        //above we have switched out of iframe and selected or clicked edit

    }
}
