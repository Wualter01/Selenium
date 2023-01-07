package renastech2.day1_Intro.Base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import renastech2.day1_Intro.utilities.BrowserUtils;
import renastech2.day1_Intro.utilities.WebDriverUtil;

import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;//we had made this default and default is not accessible outside of package
    //we can make it more visible using protected since protected is allowed access outside of package

    @BeforeMethod
    public void setup() {
        driver = WebDriverUtil.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void closing(){
        BrowserUtils.wait(3);
        //driver.close(); this will only close current tab in driver focus
        //driver.quit(); //will close webBrowser
    }
}
