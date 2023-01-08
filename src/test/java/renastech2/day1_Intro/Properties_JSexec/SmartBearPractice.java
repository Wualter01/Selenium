package renastech2.day1_Intro.Properties_JSexec;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import renastech2.day1_Intro.Base.TestBase;
import renastech2.day1_Intro.utilities.PropertiesReaderUtil;
import renastech2.day1_Intro.utilities.SmartBearUtils;

import java.util.List;

public class SmartBearPractice extends TestBase {

    /*
    1- open chrome browser
    2- go to http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    3- click on box which belongs to "charles Dodgeson"
    4- click on delete button
    5- verify if charles deleted from the list
     */

    @Test
    public void TC1_CharlesDeleteVerification(){
        //2- go to http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver.get(PropertiesReaderUtil.getProperties("SmartBear_url"));
        SmartBearUtils.loginForSmartBear(driver);
        //3- click on box which belongs to "charles Dodgeson"
        WebElement charlesCheckBox =driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl05_OrderSelector"));
        charlesCheckBox.click();
        //4- click on delete button
        WebElement deleteButton =driver.findElement(By.name("ctl00$MainContent$btnDelete"));
        deleteButton.click();
        //after deleting charles we'll need to check whole table to make sure his name is no longer on webTable
        //first store all names
        List<WebElement> listOfNames = driver.findElements(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));
        //using 2 dashes instead of one would get you to td faster and less work EX://tr//td[2]
        //5- verify if charles deleted from the list
        for(WebElement eachName : listOfNames){
            Assert.assertFalse(eachName.getText().equals("Charles Dodgeson"), "failed to delete off table");
        }
    }
}


