package renastech2.day1_Intro.day3;

import org.openqa.selenium.WebDriver;
import renastech2.day1_Intro.utilities.WebDriverUtil;

public class DriverUtilPractice {
    public static void main(String[] args) {
        WebDriver driver =WebDriverUtil.getDriver("chrome");//since my return method is new chromeDriver
        //i can do it this way and it is the equivalent of me typing WebDriver driver = new chromeDriver

        driver.get("https://google.com ");
        //if there is any mistake in my WEbDriverUtil my else block should cover it and print me useful information
        //as to why it failed.

    }
}
