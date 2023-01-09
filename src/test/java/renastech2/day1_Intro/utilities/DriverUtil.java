package renastech2.day1_Intro.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverUtil {
    //to be able to achieve singleton design pattern we will need to have a private constructor
    //no one will be able to create object from this class because we are making constructor private

    private DriverUtil(){//this is our private constructor. remember constructor is made using same name as class.
        //this class can have multiple constructors with different parameters, no two constructors can be the same.

    }

    private static WebDriver driver; //we are using encapsulation method logic by making driver private
    //we will need to create getter and setter methods for our driver

    public static WebDriver getDriver(){
        if (driver==null){
            String browser= PropertiesReaderUtil.getProperties("browser");

            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver= new ChromeDriver();
                    break;
                case"firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver= new FirefoxDriver();
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver= new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    break;
            }
        }
        return driver; //will return whatever driver it catches. the driver caught is determined by the keyword we've
        //passed itll check properties and whatever is defined there is what will catch. i can change in properties
        //file and it'll catch something else.
    }

    public static void closeDriver(){
        if (driver != null){//if driver does not equal null then quit driver and assign to null
            driver.quit();
            driver=null;
        }
    }
}
