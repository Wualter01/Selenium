package renastech2.day1_Intro.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverUtil {

   /*
   create connection between driver and browser
   WebDriverManager. chromedriver () .setup ();
   WebDriver driver =new ChromeDriver);
   driver.get ("https://www.google. com")

   //create a util that takes browser type and create connection between browser and selenium
    */

    public static WebDriver getDriver(String browser){//static so this wont change and i can call with reference of
        //class. specifier is WebDriver it can be anything int long etc.. and name is getDriver must return type of
        //web browser
        if (browser.equalsIgnoreCase("chrome")){
            //this is saying is String =chrome then setup our chrome browser EX:WebDriverUtil.getDriver("if this string
            //equals chrome driver then go ahead and set it up".)
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }else if (browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }else{
            System.out.println("Browser not setup yet! or does not exist!");
            System.out.println("browser = "+browser);
            return null; //we can have null as a return statement
        }
    }

    }

