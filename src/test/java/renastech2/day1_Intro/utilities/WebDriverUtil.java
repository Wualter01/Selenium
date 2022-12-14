package renastech2.day1_Intro.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverUtil {

    //create a util that takes browser type and create a connection between browser and selenium

    public static WebDriver getDriver(String browser){
        //we are saying if we choose to use chrome driver go ahead and set it up
        if(browser.equalsIgnoreCase("chrome")){
//chrome browser needs to be setup
            WebDriverManager.chromedriver().setup();
            //since we didnt use void we must have a return type hence return new chromedriver
            return new ChromeDriver();
        }else if (browser.equalsIgnoreCase("firefox")){
            //set up for fire fox
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }else{
            System.out.println("browser does not exist or is not setup in utils");
            System.out.println("check browser name");
            System.out.println("browser= "+browser);
            return null;
            //all of them return either a browser or must return null because we did not use void
        }
    }

    }

